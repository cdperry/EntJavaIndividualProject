package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.UomTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class UomTypeDaoTest {

    private UomTypeDao me;
    private UomTypeEntity testEntity;
    private List<UomTypeEntity> entities;

    @Before
    public void setup() {

        me = new UomTypeDao();

        int uomTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<UomTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new UomTypeEntity();
            testEntity.setName("zUom Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            uomTypeEntityID = me.addUomTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the UomEntity entities which will cascade and delete the UomGrainEntity entities
        for (UomTypeEntity thisEntity : entities) {
            me.deleteUomTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllUomTypes() throws Exception {

        List<UomTypeEntity> results;
        results = me.getAllUomTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetUomTypeEntity() throws Exception {

        int id = entities.get(0).getUomId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getUomTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateUomTypeEntity() throws Exception {

        int id = entities.get(0).getUomId();

        // retrieve the test UomGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getUomTypeEntity(id);
        testEntity.setName("New Name");
        me.updateUomTypeEntity(testEntity);

        // retrieve the updated UomGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getUomTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteUomTypeEntity() throws Exception {

        int id = entities.get(0).getUomId();

        // delete the entity and verify that it is no longer in the database
        me.deleteUomTypeEntity(me.getUomTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getUomTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddUomTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new UomTypeEntity();
        testEntity.setName("zUom Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addUomTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}