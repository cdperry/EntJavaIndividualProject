package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.SupplierEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class SupplierDaoTest {

    @Test
    public void testGetAllSuppliers() throws Exception {

        SupplierDao me = new SupplierDao();
        SupplierEntity testSupplier;
        List<SupplierEntity> suppliers;
        int supplierEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testSupplier = new SupplierEntity();
        testSupplier.setName("Supplier 1");
        testSupplier.setSupplierTypeId(1);
        testSupplier.setUrl("http://www.google.com");
        testSupplier.setEmail("a@a.com");
        testSupplier.setPhone("414-555-5555");
        testSupplier.setContactName("Name");
        testSupplier.setNotes("This is a note.");
        testSupplier.setUpdateDate(ts);
        testSupplier.setCreateDate(ts);

        supplierEntityID = me.addSupplierEntity(testSupplier);

        // create a test grain and add them to the database
        testSupplier = new SupplierEntity();
        testSupplier.setName("Supplier 2");
        testSupplier.setSupplierTypeId(1);
        testSupplier.setUrl("http://www.bing.com");
        testSupplier.setEmail("b@b.com");
        testSupplier.setPhone("262-555-5555");
        testSupplier.setContactName("Name");
        testSupplier.setNotes("This is a note.");
        testSupplier.setUpdateDate(ts);
        testSupplier.setCreateDate(ts);

        supplierEntityID = me.addSupplierEntity(testSupplier);

        suppliers = me.getAllSuppliers();
        assertTrue(suppliers.size() > 0);

        // clean up
        for (SupplierEntity component : suppliers) {
            me.deleteSupplierEntity(component);
        }

    }

    @Test
    public void testGetSupplierEntity() throws Exception {

        SupplierDao me = new SupplierDao();
        SupplierEntity testSupplier = new SupplierEntity();
        int supplierEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testSupplier = new SupplierEntity();
        testSupplier.setName("Supplier 1");
        testSupplier.setSupplierTypeId(1);
        testSupplier.setUrl("http://www.google.com");
        testSupplier.setEmail("a@a.com");
        testSupplier.setPhone("414-555-5555");
        testSupplier.setContactName("Name");
        testSupplier.setNotes("This is a note.");
        testSupplier.setUpdateDate(ts);
        testSupplier.setCreateDate(ts);

        supplierEntityID = me.addSupplierEntity(testSupplier);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero supplier ID, got " + supplierEntityID, supplierEntityID > 0);

        // confirm that the component can be retrieved from the database
        testSupplier = me.getSupplierEntity(supplierEntityID);
        assertNotNull(testSupplier);

        // clean up
        me.deleteSupplierEntity(testSupplier);

    }

    @Test
    public void testUpdateSupplierEntity() throws Exception {

        SupplierDao me = new SupplierDao();
        SupplierEntity testSupplier = new SupplierEntity();
        int supplierEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testSupplier = new SupplierEntity();
        testSupplier.setName("Supplier 1");
        testSupplier.setSupplierTypeId(1);
        testSupplier.setUrl("http://www.google.com");
        testSupplier.setEmail("a@a.com");
        testSupplier.setPhone("414-555-5555");
        testSupplier.setContactName("Name");
        testSupplier.setNotes("This is a note.");
        testSupplier.setUpdateDate(ts);
        testSupplier.setCreateDate(ts);

        supplierEntityID = me.addSupplierEntity(testSupplier);

        // retrieve the test component from the database and change its name
        testSupplier = me.getSupplierEntity(supplierEntityID);
        testSupplier.setName("New Name");
        me.updateSupplierEntity(testSupplier);

        // retrieve the updated employee and test that the update took place
        testSupplier = me.getSupplierEntity(supplierEntityID);

        assertEquals("Expected New Name, got " + testSupplier.getName(),
                "New Name", testSupplier.getName());

        // clean up
        me.deleteSupplierEntity(testSupplier);

    }

    @Test
    public void testDeleteSupplierEntity() throws Exception {

        SupplierDao me = new SupplierDao();
        SupplierEntity testSupplier = new SupplierEntity();
        int supplierEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testSupplier = new SupplierEntity();
        testSupplier.setName("Supplier 1");
        testSupplier.setSupplierTypeId(1);
        testSupplier.setUrl("http://www.google.com");
        testSupplier.setEmail("a@a.com");
        testSupplier.setPhone("414-555-5555");
        testSupplier.setContactName("Name");
        testSupplier.setNotes("This is a note.");
        testSupplier.setUpdateDate(ts);
        testSupplier.setCreateDate(ts);

        supplierEntityID = me.addSupplierEntity(testSupplier);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero supplier ID, got " + supplierEntityID, supplierEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteSupplierEntity(me.getSupplierEntity(supplierEntityID));
        assertNull(me.getSupplierEntity(supplierEntityID));

    }

    @Test
    public void testAddSupplierEntity() throws Exception {

        SupplierDao me = new SupplierDao();
        SupplierEntity testSupplier = new SupplierEntity();
        int supplierEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testSupplier = new SupplierEntity();
        testSupplier.setName("Supplier 1");
        testSupplier.setSupplierTypeId(1);
        testSupplier.setUrl("http://www.google.com");
        testSupplier.setEmail("a@a.com");
        testSupplier.setPhone("414-555-5555");
        testSupplier.setContactName("Name");
        testSupplier.setNotes("This is a note.");
        testSupplier.setUpdateDate(ts);
        testSupplier.setCreateDate(ts);

        supplierEntityID = me.addSupplierEntity(testSupplier);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero supplier ID, got " + supplierEntityID, supplierEntityID > 0);

        // clean up
        testSupplier = me.getSupplierEntity(supplierEntityID);
        me.deleteSupplierEntity(testSupplier);

    }

}