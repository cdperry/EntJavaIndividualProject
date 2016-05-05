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
public class ComponentWaterDaoTest {

    private ComponentDao componentDao;
    private ComponentEntity componentEntity;
    private ComponentWaterDao componentWaterDao;
    private ComponentWaterEntity componentWaterEntity;
    private List<ComponentEntity> componentEntities;

    @Before
    public void setup() {

        int componentEntityId;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        componentDao = new ComponentDao();
        componentWaterDao = new ComponentWaterDao();
        componentEntities = new ArrayList<ComponentEntity>();

        for (int componentNumber = 1; componentNumber < 4; componentNumber++) {

            componentEntity = new ComponentEntity();
            componentWaterEntity = new ComponentWaterEntity();

            componentEntity.setName("Test ComponentWaterEntity " + componentNumber);

            componentWaterEntity.setName("Test ComponentEntity " + componentNumber);
            componentWaterEntity.setCaco3G(new BigDecimal("1.5"));
            componentWaterEntity.setNahco3G(new BigDecimal("1.5"));
            componentWaterEntity.setBatchSize(new BigDecimal("1.5"));
            componentWaterEntity.setCaclG(new BigDecimal("1.5"));
            componentWaterEntity.setMgso4G(new BigDecimal("1.5"));
            componentWaterEntity.setCaPpm(new BigDecimal("1.5"));
            componentWaterEntity.setCaso4G(new BigDecimal("1.5"));
            componentWaterEntity.setClPpm(new BigDecimal("1.5"));
            componentWaterEntity.setHco3Ppm(new BigDecimal("1.5"));
            componentWaterEntity.setMgPpm(new BigDecimal("1.5"));
            componentWaterEntity.setNaclG(new BigDecimal("1.5"));
            componentWaterEntity.setNahco3G(new BigDecimal("1.5"));
            componentWaterEntity.setNaPpm(new BigDecimal("1.5"));
            componentWaterEntity.setPh(new BigDecimal("1.5"));
            componentWaterEntity.setSo4Ppm(new BigDecimal("1.5"));
            componentWaterEntity.setNotes("This is a note.");
            componentWaterEntity.setUpdateDate(ts);
            componentWaterEntity.setCreateDate(ts);

            /*
              ComponentEntity and ComponentWaterEntity have a one-to-one relationship with a foreign key
              from ComponentEntity.ComponentWaterEntity to ComponentWaterEntity.compWaterId.  Therefore to test
              this DAO we need to create a parent ComponentEntity and let Hibernate create the keys on both
              sides of the relationship.
            */
            componentEntity.setComponentWater(componentWaterEntity);
            componentWaterEntity.setComponentEntity(componentEntity);

            componentEntityId = componentDao.addComponentEntity(componentEntity);
            assertTrue("Expected non-zero ID, got a zero", componentEntityId > 0);
            componentEntities.add(componentEntity);

        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentWaterEntity entities
        for (ComponentEntity thisEntity : componentEntities) {
            componentDao.deleteComponentEntity(thisEntity);
        }

        // clean up
        componentDao = null;
        componentEntity = null;
        componentEntities = null;
        componentWaterDao = null;
        componentWaterEntity = null;

    }

    @Test
    public void testGetAllComponentWaters() throws Exception {

        List<ComponentWaterEntity> componentWaters;

        componentWaters = componentWaterDao.getAllComponentWaters();
        assertTrue("Expected more than zero entities, got zero", componentWaters.size() > 0);

    }

    @Test
    public void testGetComponentWaterEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // confirm that the ComponentWaterEntity can be retrieved from the database
        componentWaterEntity = null;
        componentWaterEntity = componentWaterDao.getComponentWaterEntity(componentId);
        assertNotNull("Expected non-null entity, got null", componentWaterEntity);

    }

    @Test
    public void testUpdateComponentWaterEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // retrieve the test ComponentWaterEntity from the database and change its name
        componentWaterEntity = null;
        componentWaterEntity = componentWaterDao.getComponentWaterEntity(componentId);
        componentWaterEntity.setName("New Name");
        componentWaterDao.updateComponentWaterEntity(componentWaterEntity);

        // retrieve the updated ComponentWaterEntity and test that the update took place
        componentWaterEntity = null;
        componentWaterEntity = componentWaterDao.getComponentWaterEntity(componentId);

        assertEquals("Expected New Name, got " + componentWaterEntity.getName(),
                "New Name", componentWaterEntity.getName());

    }

    @Test
    public void testDeleteComponentWaterEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // delete the ComponentWaterEntity and verify that it is no longer in the database
        componentWaterDao.deleteComponentWaterEntity(componentWaterDao.getComponentWaterEntity(componentId));
        assertNull("Expected a null entity, got a real entity", componentWaterDao.getComponentWaterEntity(componentId));

        // remove the deleted ComponentWaterEntity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        componentEntities.remove(0);

    }

}