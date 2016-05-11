package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.UseTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class UseTypeDaoTest {

    private UseTypeDao me;
    private UseTypeEntity testEntity;
    private List<UseTypeEntity> entities;

    @Before
    public void setup() {

        me = new UseTypeDao();

        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<UseTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new UseTypeEntity();
            testEntity.setName("zUse Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            useTypeEntityID = me.addUseTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the UseEntity entities which will cascade and delete the UseGrainEntity entities
        for (UseTypeEntity thisEntity : entities) {
            me.deleteUseTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllUseTypes() throws Exception {

        List<UseTypeEntity> results;
        results = me.getAllUseTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetUseTypeEntity() throws Exception {

        int id = entities.get(0).getUseTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getUseTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateUseTypeEntity() throws Exception {

        int id = entities.get(0).getUseTypeId();

        // retrieve the test UseGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getUseTypeEntity(id);
        testEntity.setName("New Name");
        me.updateUseTypeEntity(testEntity);

        // retrieve the updated UseGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getUseTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteUseTypeEntity() throws Exception {

        int id = entities.get(0).getUseTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteUseTypeEntity(me.getUseTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getUseTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddUseTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new UseTypeEntity();
        testEntity.setName("zUse Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addUseTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}