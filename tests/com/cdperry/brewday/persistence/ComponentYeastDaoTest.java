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
public class ComponentYeastDaoTest {

    private ComponentDao componentDao;
    private ComponentEntity componentEntity;
    private ComponentYeastDao componentYeastDao;
    private ComponentYeastEntity componentYeastEntity;
    private List<ComponentEntity> componentEntities;

    @Before
    public void setup() {

        int componentEntityId;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        componentDao = new ComponentDao();
        componentYeastDao = new ComponentYeastDao();
        componentEntities = new ArrayList<ComponentEntity>();

        for (int componentNumber = 1; componentNumber < 4; componentNumber++) {

            componentEntity = new ComponentEntity();
            componentYeastEntity = new ComponentYeastEntity();

            componentEntity.setName("Test ComponentYeastEntity " + componentNumber);

            componentYeastEntity.setName("Test ComponentEntity " + componentNumber);
            componentYeastEntity.setCellsPerPack(new BigDecimal("1.5"));
            componentYeastEntity.setTemperatureMin(new BigDecimal("1.5"));
            componentYeastEntity.setAttenuationMax(new BigDecimal("1.5"));
            componentYeastEntity.setAttenuationMin(new BigDecimal("1.5"));
            componentYeastEntity.setTemperatureMax(new BigDecimal("1.5"));
            componentYeastEntity.setNotes("This is a note.");
            componentYeastEntity.setUpdateDate(ts);
            componentYeastEntity.setCreateDate(ts);

            /*
              ComponentEntity and ComponentYeastEntity have a one-to-one relationship with a foreign key
              from ComponentEntity.ComponentYeastEntity to ComponentYeastEntity.compYeastId.  Therefore to test
              this DAO we need to create a parent ComponentEntity and let Hibernate create the keys on both
              sides of the relationship.
            */
            componentEntity.setComponentYeast(componentYeastEntity);
            componentYeastEntity.setComponentEntity(componentEntity);

            componentEntityId = componentDao.addComponentEntity(componentEntity);
            assertTrue("Expected non-zero ID, got a zero", componentEntityId > 0);
            componentEntities.add(componentEntity);

        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentYeastEntity entities
        for (ComponentEntity thisEntity : componentEntities) {
            componentDao.deleteComponentEntity(thisEntity);
        }

        // clean up
        componentDao = null;
        componentEntity = null;
        componentEntities = null;
        componentYeastDao = null;
        componentYeastEntity = null;

    }

    @Test
    public void testGetAllComponentYeasts() throws Exception {

        List<ComponentYeastEntity> componentYeasts;

        componentYeasts = componentYeastDao.getAllComponentYeasts();
        assertTrue("Expected more than zero entities, got zero", componentYeasts.size() > 0);

    }

    @Test
    public void testGetComponentYeastEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // confirm that the ComponentYeastEntity can be retrieved from the database
        componentYeastEntity = null;
        componentYeastEntity = componentYeastDao.getComponentYeastEntity(componentId);
        assertNotNull("Expected non-null entity, got null", componentYeastEntity);

    }

    @Test
    public void testUpdateComponentYeastEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // retrieve the test ComponentYeastEntity from the database and change its name
        componentYeastEntity = null;
        componentYeastEntity = componentYeastDao.getComponentYeastEntity(componentId);
        componentYeastEntity.setName("New Name");
        componentYeastDao.updateComponentYeastEntity(componentYeastEntity);

        // retrieve the updated ComponentYeastEntity and test that the update took place
        componentYeastEntity = null;
        componentYeastEntity = componentYeastDao.getComponentYeastEntity(componentId);

        assertEquals("Expected New Name, got " + componentYeastEntity.getName(),
                "New Name", componentYeastEntity.getName());

    }

    @Test
    public void testDeleteComponentYeastEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // delete the ComponentYeastEntity and verify that it is no longer in the database
        componentYeastDao.deleteComponentYeastEntity(componentYeastDao.getComponentYeastEntity(componentId));
        assertNull("Expected a null entity, got a real entity", componentYeastDao.getComponentYeastEntity(componentId));

        // remove the deleted ComponentYeastEntity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        componentEntities.remove(0);

    }

}