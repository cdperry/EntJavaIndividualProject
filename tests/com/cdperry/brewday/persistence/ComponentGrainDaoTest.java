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
public class ComponentGrainDaoTest {

    private ComponentDao componentDao;
    private ComponentEntity componentEntity;
    private ComponentGrainDao componentGrainDao;
    private ComponentGrainEntity componentGrainEntity;
    private List<ComponentEntity> componentEntities;

    @Before
    public void setup() {

        int componentEntityId;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        componentDao = new ComponentDao();
        componentGrainDao = new ComponentGrainDao();
        componentEntities = new ArrayList<ComponentEntity>();

        for (int componentNumber = 1; componentNumber < 4; componentNumber++) {

            componentEntity = new ComponentEntity();
            componentGrainEntity = new ComponentGrainEntity();

            componentEntity.setName("Test ComponentGrainEntity " + componentNumber);

            componentGrainEntity.setName("Test ComponentEntity " + componentNumber);
            componentGrainEntity.setColor(new BigDecimal("1.5"));
            componentGrainEntity.setPotential(new BigDecimal("3.2"));
            componentGrainEntity.setNotes("This is a note.");
            componentGrainEntity.setUpdateDate(ts);
            componentGrainEntity.setCreateDate(ts);

            /*
              ComponentEntity and ComponentGrainEntity have a one-to-one relationship with a foreign key
              from ComponentEntity.ComponentGrainEntity to ComponentGrainEntity.compGrainId.  Therefore to test
              this DAO we need to create a parent ComponentEntity and let Hibernate create the keys on both
              sides of the relationship.
            */
            componentEntity.setComponentGrain(componentGrainEntity);
            componentGrainEntity.setComponentEntity(componentEntity);

            componentEntityId = componentDao.addComponentEntity(componentEntity);
            assertTrue("Expected non-zero ID, got a zero", componentEntityId > 0);
            componentEntities.add(componentEntity);

        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentGrainEntity entities
        for (ComponentEntity thisEntity : componentEntities) {
            componentDao.deleteComponentEntity(thisEntity);
        }

        // clean up
        componentDao = null;
        componentEntity = null;
        componentEntities = null;
        componentGrainDao = null;
        componentGrainEntity = null;

    }

    @Test
    public void testGetAllComponentGrains() throws Exception {

        List<ComponentGrainEntity> componentGrains;

        componentGrains = componentGrainDao.getAllComponentGrains();
        assertTrue("Expected more than zero entities, got zero", componentGrains.size() > 0);

    }

    @Test
    public void testGetComponentGrainEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // confirm that the ComponentGrainEntity can be retrieved from the database
        componentGrainEntity = null;
        componentGrainEntity = componentGrainDao.getComponentGrainEntity(componentId);
        assertNotNull("Expected non-null entity, got null", componentGrainEntity);

    }

    @Test
    public void testUpdateComponentGrainEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // retrieve the test ComponentGrainEntity from the database and change its name
        componentGrainEntity = null;
        componentGrainEntity = componentGrainDao.getComponentGrainEntity(componentId);
        componentGrainEntity.setName("New Name");
        componentGrainDao.updateComponentGrainEntity(componentGrainEntity);

        // retrieve the updated ComponentGrainEntity and test that the update took place
        componentGrainEntity = null;
        componentGrainEntity = componentGrainDao.getComponentGrainEntity(componentId);

        assertEquals("Expected New Name, got " + componentGrainEntity.getName(),
                "New Name", componentGrainEntity.getName());

    }

    @Test
    public void testDeleteComponentGrainEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // delete the ComponentGrainEntity and verify that it is no longer in the database
        componentGrainDao.deleteComponentGrainEntity(componentGrainDao.getComponentGrainEntity(componentId));
        assertNull("Expected a null entity, got a real entity", componentGrainDao.getComponentGrainEntity(componentId));

        // remove the deleted ComponentGrainEntity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        componentEntities.remove(0);

    }

}