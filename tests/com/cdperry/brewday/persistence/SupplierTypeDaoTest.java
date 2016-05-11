package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.SupplierTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class SupplierTypeDaoTest {

    private SupplierTypeDao me;
    private SupplierTypeEntity testEntity;
    private List<SupplierTypeEntity> entities;

    @Before
    public void setup() {

        me = new SupplierTypeDao();

        int supplierTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<SupplierTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new SupplierTypeEntity();
            testEntity.setName("zSupplier Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            supplierTypeEntityID = me.addSupplierTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the SupplierEntity entities which will cascade and delete the SupplierGrainEntity entities
        for (SupplierTypeEntity thisEntity : entities) {
            me.deleteSupplierTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllSupplierTypes() throws Exception {

        List<SupplierTypeEntity> results;
        results = me.getAllSupplierTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetSupplierTypeEntity() throws Exception {

        int id = entities.get(0).getSupplierTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getSupplierTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateSupplierTypeEntity() throws Exception {

        int id = entities.get(0).getSupplierTypeId();

        // retrieve the test SupplierGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getSupplierTypeEntity(id);
        testEntity.setName("New Name");
        me.updateSupplierTypeEntity(testEntity);

        // retrieve the updated SupplierGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getSupplierTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteSupplierTypeEntity() throws Exception {

        int id = entities.get(0).getSupplierTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteSupplierTypeEntity(me.getSupplierTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getSupplierTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddSupplierTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new SupplierTypeEntity();
        testEntity.setName("zSupplier Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addSupplierTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}