package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.UomTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class UomTypeDaoTest {

    @Test
    public void testGetAllUomTypes() throws Exception {

        UomTypeDao me = new UomTypeDao();
        UomTypeEntity testUomType;
        List<UomTypeEntity> uomTypes;
        int uomTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testUomType = new UomTypeEntity();
        testUomType.setName("Uom Type 1");
        testUomType.setUpdateDate(ts);
        testUomType.setCreateDate(ts);

        uomTypeEntityID = me.addUomTypeEntity(testUomType);

        // create a test grain and add them to the database
        testUomType = new UomTypeEntity();
        testUomType.setName("Uom Type 2");
        testUomType.setUpdateDate(ts);
        testUomType.setCreateDate(ts);

        uomTypeEntityID = me.addUomTypeEntity(testUomType);

        uomTypes = me.getAllUomTypes();
        assertTrue(uomTypes.size() > 0);

        // clean up
        for (UomTypeEntity component : uomTypes) {
            me.deleteUomTypeEntity(component);
        }

    }

    @Test
    public void testGetUomTypeEntity() throws Exception {

        UomTypeDao me = new UomTypeDao();
        UomTypeEntity testUomType = new UomTypeEntity();
        int uomTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testUomType = new UomTypeEntity();
        testUomType.setName("Uom Type 1");
        testUomType.setUpdateDate(ts);
        testUomType.setCreateDate(ts);

        uomTypeEntityID = me.addUomTypeEntity(testUomType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero uom type ID, got " + uomTypeEntityID, uomTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testUomType = me.getUomTypeEntity(uomTypeEntityID);
        assertNotNull(testUomType);

        // clean up
        me.deleteUomTypeEntity(testUomType);

    }

    @Test
    public void testUpdateUomTypeEntity() throws Exception {

        UomTypeDao me = new UomTypeDao();
        UomTypeEntity testUomType = new UomTypeEntity();
        int uomTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUomType = new UomTypeEntity();
        testUomType.setName("Uom Type 1");
        testUomType.setUpdateDate(ts);
        testUomType.setCreateDate(ts);

        uomTypeEntityID = me.addUomTypeEntity(testUomType);

        // retrieve the test component from the database and change its name
        testUomType = me.getUomTypeEntity(uomTypeEntityID);
        testUomType.setName("New Name");
        me.updateUomTypeEntity(testUomType);

        // retrieve the updated employee and test that the update took place
        testUomType = me.getUomTypeEntity(uomTypeEntityID);

        assertEquals("Expected New Name, got " + testUomType.getName(),
                "New Name", testUomType.getName());

        // clean up
        me.deleteUomTypeEntity(testUomType);

    }

    @Test
    public void testDeleteUomTypeEntity() throws Exception {

        UomTypeDao me = new UomTypeDao();
        UomTypeEntity testUomType = new UomTypeEntity();
        int uomTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUomType = new UomTypeEntity();
        testUomType.setName("Uom Type 1");
        testUomType.setUpdateDate(ts);
        testUomType.setCreateDate(ts);

        uomTypeEntityID = me.addUomTypeEntity(testUomType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero uom type ID, got " + uomTypeEntityID, uomTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteUomTypeEntity(me.getUomTypeEntity(uomTypeEntityID));
        assertNull(me.getUomTypeEntity(uomTypeEntityID));

    }

    @Test
    public void testAddUomTypeEntity() throws Exception {

        UomTypeDao me = new UomTypeDao();
        UomTypeEntity testUomType = new UomTypeEntity();
        int uomTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUomType = new UomTypeEntity();
        testUomType.setName("Uom Type 1");
        testUomType.setUpdateDate(ts);
        testUomType.setCreateDate(ts);

        uomTypeEntityID = me.addUomTypeEntity(testUomType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero uom type ID, got " + uomTypeEntityID, uomTypeEntityID > 0);

        // clean up
        testUomType = me.getUomTypeEntity(uomTypeEntityID);
        me.deleteUomTypeEntity(testUomType);

    }
}