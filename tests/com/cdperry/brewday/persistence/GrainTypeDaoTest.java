package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.GrainTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class GrainTypeDaoTest {

    private GrainTypeDao me;
    private GrainTypeEntity testEntity;
    private List<GrainTypeEntity> entities;

    @Before
    public void setup() {

        me = new GrainTypeDao();

        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<GrainTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new GrainTypeEntity();
            testEntity.setName("zGrain Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            grainTypeEntityID = me.addGrainTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the GrainEntity entities which will cascade and delete the GrainGrainEntity entities
        for (GrainTypeEntity thisEntity : entities) {
            me.deleteGrainTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllGrainTypes() throws Exception {

        List<GrainTypeEntity> results;
        results = me.getAllGrainTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetGrainTypeEntity() throws Exception {

        int id = entities.get(0).getGrainTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getGrainTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateGrainTypeEntity() throws Exception {

        int id = entities.get(0).getGrainTypeId();

        // retrieve the test GrainGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getGrainTypeEntity(id);
        testEntity.setName("New Name");
        me.updateGrainTypeEntity(testEntity);

        // retrieve the updated GrainGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getGrainTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteGrainTypeEntity() throws Exception {

        int id = entities.get(0).getGrainTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteGrainTypeEntity(me.getGrainTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getGrainTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddGrainTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new GrainTypeEntity();
        testEntity.setName("zGrain Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addGrainTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}