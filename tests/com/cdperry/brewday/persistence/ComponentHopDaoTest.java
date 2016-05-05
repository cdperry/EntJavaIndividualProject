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
public class ComponentHopDaoTest {

    private ComponentDao componentDao;
    private ComponentEntity componentEntity;
    private ComponentHopDao componentHopDao;
    private ComponentHopEntity componentHopEntity;
    private List<ComponentEntity> componentEntities;

    @Before
    public void setup() {

        int componentEntityId;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        componentDao = new ComponentDao();
        componentHopDao = new ComponentHopDao();
        componentEntities = new ArrayList<ComponentEntity>();

        for (int componentNumber = 1; componentNumber < 4; componentNumber++) {

            componentEntity = new ComponentEntity();
            componentHopEntity = new ComponentHopEntity();

            componentEntity.setName("Test ComponentHopEntity " + componentNumber);

            componentHopEntity.setName("Test ComponentEntity " + componentNumber);
            componentHopEntity.setAlphaPct(new BigDecimal("1.5"));
            componentHopEntity.setBetaPct(new BigDecimal("3.2"));
            componentHopEntity.setNotes("This is a note.");
            componentHopEntity.setUpdateDate(ts);
            componentHopEntity.setCreateDate(ts);

            /*
              ComponentEntity and ComponentHopEntity have a one-to-one relationship with a foreign key
              from ComponentEntity.ComponentHopEntity to ComponentHopEntity.compHopId.  Therefore to test
              this DAO we need to create a parent ComponentEntity and let Hibernate create the keys on both
              sides of the relationship.
            */
            componentEntity.setComponentHop(componentHopEntity);
            componentHopEntity.setComponentEntity(componentEntity);

            componentEntityId = componentDao.addComponentEntity(componentEntity);
            assertTrue("Expected non-zero ID, got a zero", componentEntityId > 0);
            componentEntities.add(componentEntity);

        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentHopEntity entities
        for (ComponentEntity thisEntity : componentEntities) {
            componentDao.deleteComponentEntity(thisEntity);
        }

        // clean up
        componentDao = null;
        componentEntity = null;
        componentEntities = null;
        componentHopDao = null;
        componentHopEntity = null;

    }

    @Test
    public void testGetAllComponentHops() throws Exception {

        List<ComponentHopEntity> componentHops;

        componentHops = componentHopDao.getAllComponentHops();
        assertTrue("Expected more than zero entities, got zero", componentHops.size() > 0);
        
    }

    @Test
    public void testGetComponentHopEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // confirm that the ComponentHopEntity can be retrieved from the database
        componentHopEntity = null;
        componentHopEntity = componentHopDao.getComponentHopEntity(componentId);
        assertNotNull("Expected non-null entity, got null", componentHopEntity);
        
    }

    @Test
    public void testUpdateComponentHopEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // retrieve the test ComponentHopEntity from the database and change its name
        componentHopEntity = null;
        componentHopEntity = componentHopDao.getComponentHopEntity(componentId);
        componentHopEntity.setName("New Name");
        componentHopDao.updateComponentHopEntity(componentHopEntity);

        // retrieve the updated ComponentHopEntity and test that the update took place
        componentHopEntity = null;
        componentHopEntity = componentHopDao.getComponentHopEntity(componentId);

        assertEquals("Expected New Name, got " + componentHopEntity.getName(),
                "New Name", componentHopEntity.getName());

    }

    @Test
    public void testDeleteComponentHopEntity() throws Exception {

        int componentId = componentEntities.get(0).getComponentId();

        // delete the ComponentHopEntity and verify that it is no longer in the database
        componentHopDao.deleteComponentHopEntity(componentHopDao.getComponentHopEntity(componentId));
        assertNull("Expected a null entity, got a real entity", componentHopDao.getComponentHopEntity(componentId));

        // remove the deleted ComponentHopEntity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        componentEntities.remove(0);
        
    }

}