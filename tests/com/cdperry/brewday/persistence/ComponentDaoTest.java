package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 *
 * TODO: Update all DAO tests to use @Before and @After annotations
 */
public class ComponentDaoTest {

    private ComponentDao componentDao;
    private ComponentEntity componentEntity;
    private List<ComponentEntity> componentEntities;

    @Test
    @Before
    public void setup() {

        int componentEntityId;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        componentDao = new ComponentDao();
        componentEntities = new ArrayList<ComponentEntity>();

        for (int componentNumber = 1; componentNumber < 4; componentNumber++) {

            componentEntity = new ComponentEntity();

            componentEntity.setName("Test ComponentEntity " + componentNumber);
            componentEntity.setCreateDate(ts);
            componentEntity.setUpdateDate(ts);

            componentEntityId = componentDao.addComponentEntity(componentEntity);
            assertTrue("Expected non-zero ID, got a zero", componentEntityId > 0);
            componentEntities.add(componentEntity);

        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities
        for (ComponentEntity thisEntity : componentEntities) {
            componentDao.deleteComponentEntity(thisEntity);
        }

        // clean up
        componentDao = null;
        componentEntity = null;
        componentEntities = null;

    }

    @Test
    public void testGetAllComponents() throws Exception {

        componentEntities = componentDao.getAllComponents();
        assertTrue("Expected more than zero entities, got zero", componentEntities.size() > 0);

    }

    @Test
    public void testGetComponentEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // confirm that the ComponentEntity can be retrieved from the database
        componentEntity = null;
        componentEntity = componentDao.getComponentEntity(componentId);
        assertNotNull("Expected non-null entity, got null", componentEntity);

    }

    @Test
    public void testUpdateComponentEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // retrieve the test ComponentEntity from the database and change its name
        componentEntity = null;
        componentEntity = componentDao.getComponentEntity(componentId);
        componentEntity.setName("New Name");
        componentDao.updateComponentEntity(componentEntity);

        // retrieve the updated ComponentEntity and test that the update took place
        componentEntity = null;
        componentEntity = componentDao.getComponentEntity(componentId);

        assertEquals("Expected New Name, got " + componentEntity.getName(),
                "New Name", componentEntity.getName());

    }

    @Test
    public void testDeleteComponentEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // delete the ComponentEntity and verify that it is no longer in the database
        componentDao.deleteComponentEntity(componentDao.getComponentEntity(componentId));
        assertNull("Expected a null entity, got a real entity", componentDao.getComponentEntity(componentId));

        // remove the deleted ComponentEntity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        componentEntities.remove(0);

    }

}