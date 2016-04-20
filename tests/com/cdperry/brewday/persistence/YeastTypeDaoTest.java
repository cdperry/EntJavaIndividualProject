package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class YeastTypeDaoTest {

    @Test
    public void testGetAllYeastTypes() throws Exception {

        YeastTypeDao me = new YeastTypeDao();
        YeastTypeEntity testYeastType;
        List<YeastTypeEntity> yeastTypes;
        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test yeast and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 1");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        // create a test yeast and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 2");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        yeastTypes = me.getAllYeastTypes();
        assertTrue(yeastTypes.size() > 0);

        // clean up
        for (YeastTypeEntity component : yeastTypes) {
            me.deleteYeastTypeEntity(component);
        }

    }

    @Test
    public void testGetYeastTypeEntity() throws Exception {

        YeastTypeDao me = new YeastTypeDao();
        YeastTypeEntity testYeastType = new YeastTypeEntity();
        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test yeast and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 1");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero yeast type ID, got " + yeastTypeEntityID, yeastTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testYeastType = me.getYeastTypeEntity(yeastTypeEntityID);
        assertNotNull(testYeastType);

        // clean up
        me.deleteYeastTypeEntity(testYeastType);

    }

    @Test
    public void testUpdateYeastTypeEntity() throws Exception {

        YeastTypeDao me = new YeastTypeDao();
        YeastTypeEntity testYeastType = new YeastTypeEntity();
        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 1");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        // retrieve the test component from the database and change its name
        testYeastType = me.getYeastTypeEntity(yeastTypeEntityID);
        testYeastType.setName("New Name");
        me.updateYeastTypeEntity(testYeastType);

        // retrieve the updated employee and test that the update took place
        testYeastType = me.getYeastTypeEntity(yeastTypeEntityID);

        assertEquals("Expected New Name, got " + testYeastType.getName(),
                "New Name", testYeastType.getName());

        // clean up
        me.deleteYeastTypeEntity(testYeastType);

    }

    @Test
    public void testDeleteYeastTypeEntity() throws Exception {

        YeastTypeDao me = new YeastTypeDao();
        YeastTypeEntity testYeastType = new YeastTypeEntity();
        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 1");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero yeast type ID, got " + yeastTypeEntityID, yeastTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteYeastTypeEntity(me.getYeastTypeEntity(yeastTypeEntityID));
        assertNull(me.getYeastTypeEntity(yeastTypeEntityID));

    }

    @Test
    public void testAddYeastTypeEntity() throws Exception {

        YeastTypeDao me = new YeastTypeDao();
        YeastTypeEntity testYeastType = new YeastTypeEntity();
        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 1");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero yeast type ID, got " + yeastTypeEntityID, yeastTypeEntityID > 0);

        // clean up
        testYeastType = me.getYeastTypeEntity(yeastTypeEntityID);
        me.deleteYeastTypeEntity(testYeastType);

    }

    @Test
    public void testDeleteYeastTypeEntityById() throws Exception {

        YeastTypeDao me = new YeastTypeDao();
        YeastTypeEntity testYeastType = new YeastTypeEntity();
        int yeastTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastType = new YeastTypeEntity();
        testYeastType.setName("Yeast Type 1");
        testYeastType.setUpdateDate(ts);
        testYeastType.setCreateDate(ts);

        yeastTypeEntityID = me.addYeastTypeEntity(testYeastType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero yeast type ID, got " + yeastTypeEntityID, yeastTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteYeastTypeEntityById(yeastTypeEntityID);
        assertNull(me.getYeastTypeEntity(yeastTypeEntityID));

    }
    
}