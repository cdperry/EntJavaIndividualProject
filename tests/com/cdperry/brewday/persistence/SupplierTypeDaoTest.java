package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.SupplierTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class SupplierTypeDaoTest {

    @Test
    public void testGetAllSupplierTypes() throws Exception {

        SupplierTypeDao me = new SupplierTypeDao();
        SupplierTypeEntity testSupplierType;
        List<SupplierTypeEntity> supplierTypes;
        int supplierTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testSupplierType = new SupplierTypeEntity();
        testSupplierType.setName("Supplier Type 1");
        testSupplierType.setUpdateDate(ts);
        testSupplierType.setCreateDate(ts);

        supplierTypeEntityID = me.addSupplierTypeEntity(testSupplierType);

        // create a test grain and add them to the database
        testSupplierType = new SupplierTypeEntity();
        testSupplierType.setName("Supplier Type 2");
        testSupplierType.setUpdateDate(ts);
        testSupplierType.setCreateDate(ts);

        supplierTypeEntityID = me.addSupplierTypeEntity(testSupplierType);

        supplierTypes = me.getAllSupplierTypes();
        assertTrue(supplierTypes.size() > 0);

        // clean up
        for (SupplierTypeEntity component : supplierTypes) {
            me.deleteSupplierTypeEntity(component);
        }

    }

    @Test
    public void testGetSupplierTypeEntity() throws Exception {

        SupplierTypeDao me = new SupplierTypeDao();
        SupplierTypeEntity testSupplierType = new SupplierTypeEntity();
        int supplierTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testSupplierType = new SupplierTypeEntity();
        testSupplierType.setName("Supplier Type 1");
        testSupplierType.setUpdateDate(ts);
        testSupplierType.setCreateDate(ts);

        supplierTypeEntityID = me.addSupplierTypeEntity(testSupplierType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero supplier type ID, got " + supplierTypeEntityID, supplierTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testSupplierType = me.getSupplierTypeEntity(supplierTypeEntityID);
        assertNotNull(testSupplierType);

        // clean up
        me.deleteSupplierTypeEntity(testSupplierType);

    }

    @Test
    public void testUpdateSupplierTypeEntity() throws Exception {

        SupplierTypeDao me = new SupplierTypeDao();
        SupplierTypeEntity testSupplierType = new SupplierTypeEntity();
        int supplierTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testSupplierType = new SupplierTypeEntity();
        testSupplierType.setName("Supplier Type 1");
        testSupplierType.setUpdateDate(ts);
        testSupplierType.setCreateDate(ts);

        supplierTypeEntityID = me.addSupplierTypeEntity(testSupplierType);

        // retrieve the test component from the database and change its name
        testSupplierType = me.getSupplierTypeEntity(supplierTypeEntityID);
        testSupplierType.setName("New Name");
        me.updateSupplierTypeEntity(testSupplierType);

        // retrieve the updated employee and test that the update took place
        testSupplierType = me.getSupplierTypeEntity(supplierTypeEntityID);

        assertEquals("Expected New Name, got " + testSupplierType.getName(),
                "New Name", testSupplierType.getName());

        // clean up
        me.deleteSupplierTypeEntity(testSupplierType);

    }

    @Test
    public void testDeleteSupplierTypeEntity() throws Exception {

        SupplierTypeDao me = new SupplierTypeDao();
        SupplierTypeEntity testSupplierType = new SupplierTypeEntity();
        int supplierTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testSupplierType = new SupplierTypeEntity();
        testSupplierType.setName("Supplier Type 1");
        testSupplierType.setUpdateDate(ts);
        testSupplierType.setCreateDate(ts);

        supplierTypeEntityID = me.addSupplierTypeEntity(testSupplierType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero supplier type ID, got " + supplierTypeEntityID, supplierTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteSupplierTypeEntity(me.getSupplierTypeEntity(supplierTypeEntityID));
        assertNull(me.getSupplierTypeEntity(supplierTypeEntityID));

    }

    @Test
    public void testAddSupplierTypeEntity() throws Exception {

        SupplierTypeDao me = new SupplierTypeDao();
        SupplierTypeEntity testSupplierType = new SupplierTypeEntity();
        int supplierTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testSupplierType = new SupplierTypeEntity();
        testSupplierType.setName("Supplier Type 1");
        testSupplierType.setUpdateDate(ts);
        testSupplierType.setCreateDate(ts);

        supplierTypeEntityID = me.addSupplierTypeEntity(testSupplierType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero supplier type ID, got " + supplierTypeEntityID, supplierTypeEntityID > 0);

        // clean up
        testSupplierType = me.getSupplierTypeEntity(supplierTypeEntityID);
        me.deleteSupplierTypeEntity(testSupplierType);

    }
}