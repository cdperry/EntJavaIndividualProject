package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class YeastTypeDaoTest {

    private YeastTypeDao me;
    private YeastTypeEntity testEntity;
    private List<YeastTypeEntity> entities;

    @Before
    public void setup() {

        me = new YeastTypeDao();

        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<YeastTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new YeastTypeEntity();
            testEntity.setName("zYeast Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            yeastTypeEntityID = me.addYeastTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the YeastEntity entities which will cascade and delete the YeastGrainEntity entities
        for (YeastTypeEntity thisEntity : entities) {
            me.deleteYeastTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllYeastTypes() throws Exception {

        List<YeastTypeEntity> results;
        results = me.getAllYeastTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetYeastTypeEntity() throws Exception {

        int id = entities.get(0).getYeastTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getYeastTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateYeastTypeEntity() throws Exception {

        int id = entities.get(0).getYeastTypeId();

        // retrieve the test YeastGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getYeastTypeEntity(id);
        testEntity.setName("New Name");
        me.updateYeastTypeEntity(testEntity);

        // retrieve the updated YeastGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getYeastTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteYeastTypeEntity() throws Exception {

        int id = entities.get(0).getYeastTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteYeastTypeEntity(me.getYeastTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getYeastTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddYeastTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new YeastTypeEntity();
        testEntity.setName("zYeast Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addYeastTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}