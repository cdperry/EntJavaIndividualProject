package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.HopFormTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class HopFormTypeDaoTest {

    private HopFormTypeDao me;
    private HopFormTypeEntity testEntity;
    private List<HopFormTypeEntity> entities;

    @Before
    public void setup() {

        me = new HopFormTypeDao();

        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<HopFormTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new HopFormTypeEntity();
            testEntity.setName("zHopForm Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            hopFormTypeEntityID = me.addHopFormTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the HopFormEntity entities which will cascade and delete the HopFormGrainEntity entities
        for (HopFormTypeEntity thisEntity : entities) {
            me.deleteHopFormTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllHopFormTypes() throws Exception {

        List<HopFormTypeEntity> results;
        results = me.getAllHopFormTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetHopFormTypeEntity() throws Exception {

        int id = entities.get(0).getHopFormTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getHopFormTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateHopFormTypeEntity() throws Exception {

        int id = entities.get(0).getHopFormTypeId();

        // retrieve the test HopFormGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getHopFormTypeEntity(id);
        testEntity.setName("New Name");
        me.updateHopFormTypeEntity(testEntity);

        // retrieve the updated HopFormGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getHopFormTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteHopFormTypeEntity() throws Exception {

        int id = entities.get(0).getHopFormTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteHopFormTypeEntity(me.getHopFormTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getHopFormTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddHopFormTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new HopFormTypeEntity();
        testEntity.setName("zHopForm Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addHopFormTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }
    
}