package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastFlocTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class YeastFlocTypeDaoTest {

    private YeastFlocTypeDao me;
    private YeastFlocTypeEntity testEntity;
    private List<YeastFlocTypeEntity> entities;

    @Before
    public void setup() {

        me = new YeastFlocTypeDao();

        int yeastFlocTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<YeastFlocTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new YeastFlocTypeEntity();
            testEntity.setName("zYeastFloc Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the YeastFlocEntity entities which will cascade and delete the YeastFlocGrainEntity entities
        for (YeastFlocTypeEntity thisEntity : entities) {
            me.deleteYeastFlocTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllYeastFlocTypes() throws Exception {

        List<YeastFlocTypeEntity> results;
        results = me.getAllYeastFlocTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetYeastFlocTypeEntity() throws Exception {

        int id = entities.get(0).getYeastFlocTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getYeastFlocTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateYeastFlocTypeEntity() throws Exception {

        int id = entities.get(0).getYeastFlocTypeId();

        // retrieve the test YeastFlocGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getYeastFlocTypeEntity(id);
        testEntity.setName("New Name");
        me.updateYeastFlocTypeEntity(testEntity);

        // retrieve the updated YeastFlocGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getYeastFlocTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteYeastFlocTypeEntity() throws Exception {

        int id = entities.get(0).getYeastFlocTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteYeastFlocTypeEntity(me.getYeastFlocTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getYeastFlocTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddYeastFlocTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new YeastFlocTypeEntity();
        testEntity.setName("zYeastFloc Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addYeastFlocTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}