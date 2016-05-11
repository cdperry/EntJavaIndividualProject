package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.HopTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class HopTypeDaoTest {

    private HopTypeDao me;
    private HopTypeEntity testEntity;
    private List<HopTypeEntity> entities;

    @Before
    public void setup() {

        me = new HopTypeDao();

        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<HopTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new HopTypeEntity();
            testEntity.setName("zHop Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            hopTypeEntityID = me.addHopTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the HopEntity entities which will cascade and delete the HopGrainEntity entities
        for (HopTypeEntity thisEntity : entities) {
            me.deleteHopTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllHopTypes() throws Exception {

        List<HopTypeEntity> results;
        results = me.getAllHopTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetHopTypeEntity() throws Exception {

        int id = entities.get(0).getHopTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getHopTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateHopTypeEntity() throws Exception {

        int id = entities.get(0).getHopTypeId();

        // retrieve the test HopGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getHopTypeEntity(id);
        testEntity.setName("New Name");
        me.updateHopTypeEntity(testEntity);

        // retrieve the updated HopGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getHopTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteHopTypeEntity() throws Exception {

        int id = entities.get(0).getHopTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteHopTypeEntity(me.getHopTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getHopTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddHopTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new HopTypeEntity();
        testEntity.setName("zHop Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addHopTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}