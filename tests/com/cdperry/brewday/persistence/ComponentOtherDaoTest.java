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
 * Created by cdperry on 4/3/16.
 */
public class ComponentOtherDaoTest {

    private ComponentDao componentDao;
    private ComponentEntity componentEntity;
    private ComponentOtherDao componentOtherDao;
    private ComponentOtherEntity componentOtherEntity;
    private List<ComponentEntity> componentEntities;

    @Before
    public void setup() {

        int componentEntityId;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        componentDao = new ComponentDao();
        componentOtherDao = new ComponentOtherDao();
        componentEntities = new ArrayList<ComponentEntity>();

        for (int componentNumber = 1; componentNumber < 4; componentNumber++) {

            componentEntity = new ComponentEntity();
            componentOtherEntity = new ComponentOtherEntity();

            componentEntity.setName("Test ComponentOtherEntity " + componentNumber);

            componentOtherEntity.setName("Test ComponentEntity " + componentNumber);
            componentOtherEntity.setBatchSize(new BigDecimal("1.5"));
            componentOtherEntity.setAmount(new BigDecimal("3.2"));
            componentOtherEntity.setTime(new BigDecimal("60"));
            componentOtherEntity.setUseFor("stuff");
            componentOtherEntity.setNotes("This is a note.");
            componentOtherEntity.setUpdateDate(ts);
            componentOtherEntity.setCreateDate(ts);

            /*
              ComponentEntity and ComponentOtherEntity have a one-to-one relationship with a foreign key
              from ComponentEntity.ComponentOtherEntity to ComponentOtherEntity.compOtherId.  Therefore to test
              this DAO we need to create a parent ComponentEntity and let Hibernate create the keys on both
              sides of the relationship.
            */
            componentEntity.setComponentOther(componentOtherEntity);
            componentOtherEntity.setComponentEntity(componentEntity);

            componentEntityId = componentDao.addComponentEntity(componentEntity);
            assertTrue("Expected non-zero ID, got a zero", componentEntityId > 0);
            componentEntities.add(componentEntity);

        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentOtherEntity entities
        for (ComponentEntity thisEntity : componentEntities) {
            componentDao.deleteComponentEntity(thisEntity);
        }

        // clean up
        componentDao = null;
        componentEntity = null;
        componentEntities = null;
        componentOtherDao = null;
        componentOtherEntity = null;

    }

    @Test
    public void testGetAllComponentOthers() throws Exception {

        List<ComponentOtherEntity> componentOthers;

        componentOthers = componentOtherDao.getAllComponentOthers();
        assertTrue("Expected more than zero entities, got zero", componentOthers.size() > 0);

    }

    @Test
    public void testGetComponentOtherEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // confirm that the ComponentOtherEntity can be retrieved from the database
        componentOtherEntity = null;
        componentOtherEntity = componentOtherDao.getComponentOtherEntity(componentId);
        assertNotNull("Expected non-null entity, got null", componentOtherEntity);

    }

    @Test
    public void testUpdateComponentOtherEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // retrieve the test ComponentOtherEntity from the database and change its name
        componentOtherEntity = null;
        componentOtherEntity = componentOtherDao.getComponentOtherEntity(componentId);
        componentOtherEntity.setName("New Name");
        componentOtherDao.updateComponentOtherEntity(componentOtherEntity);

        // retrieve the updated ComponentOtherEntity and test that the update took place
        componentOtherEntity = null;
        componentOtherEntity = componentOtherDao.getComponentOtherEntity(componentId);

        assertEquals("Expected New Name, got " + componentOtherEntity.getName(),
                "New Name", componentOtherEntity.getName());

    }

    @Test
    public void testDeleteComponentOtherEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // delete the ComponentOtherEntity and verify that it is no longer in the database
        componentOtherDao.deleteComponentOtherEntity(componentOtherDao.getComponentOtherEntity(componentId));
        assertNull("Expected a null entity, got a real entity", componentOtherDao.getComponentOtherEntity(componentId));

        // remove the deleted ComponentOtherEntity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        componentEntities.remove(0);

    }

}