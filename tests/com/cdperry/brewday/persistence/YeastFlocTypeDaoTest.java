package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastFlocTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class YeastFlocTypeDaoTest {

    @Test
    public void testGetAllYeastFlocTypes() throws Exception {

        YeastFlocTypeDao me = new YeastFlocTypeDao();
        YeastFlocTypeEntity testYeastFlocType;
        List<YeastFlocTypeEntity> yeastFlocTypes;
        int yeastFlocTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testYeastFlocType = new YeastFlocTypeEntity();
        testYeastFlocType.setName("YeastFloc Type 1");
        testYeastFlocType.setUpdateDate(ts);
        testYeastFlocType.setCreateDate(ts);

        yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testYeastFlocType);

        // create a test grain and add them to the database
        testYeastFlocType = new YeastFlocTypeEntity();
        testYeastFlocType.setName("YeastFloc Type 2");
        testYeastFlocType.setUpdateDate(ts);
        testYeastFlocType.setCreateDate(ts);

        yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testYeastFlocType);

        yeastFlocTypes = me.getAllYeastFlocTypes();
        assertTrue(yeastFlocTypes.size() > 0);

        // clean up
        for (YeastFlocTypeEntity component : yeastFlocTypes) {
            me.deleteYeastFlocTypeEntity(component);
        }

    }

    @Test
    public void testGetYeastFlocTypeEntity() throws Exception {

        YeastFlocTypeDao me = new YeastFlocTypeDao();
        YeastFlocTypeEntity testYeastFlocType = new YeastFlocTypeEntity();
        int yeastFlocTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testYeastFlocType = new YeastFlocTypeEntity();
        testYeastFlocType.setName("YeastFloc Type 1");
        testYeastFlocType.setUpdateDate(ts);
        testYeastFlocType.setCreateDate(ts);

        yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testYeastFlocType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero yeastFloc type ID, got " + yeastFlocTypeEntityID, yeastFlocTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testYeastFlocType = me.getYeastFlocTypeEntity(yeastFlocTypeEntityID);
        assertNotNull(testYeastFlocType);

        // clean up
        me.deleteYeastFlocTypeEntity(testYeastFlocType);

    }

    @Test
    public void testUpdateYeastFlocTypeEntity() throws Exception {

        YeastFlocTypeDao me = new YeastFlocTypeDao();
        YeastFlocTypeEntity testYeastFlocType = new YeastFlocTypeEntity();
        int yeastFlocTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastFlocType = new YeastFlocTypeEntity();
        testYeastFlocType.setName("YeastFloc Type 1");
        testYeastFlocType.setUpdateDate(ts);
        testYeastFlocType.setCreateDate(ts);

        yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testYeastFlocType);

        // retrieve the test component from the database and change its name
        testYeastFlocType = me.getYeastFlocTypeEntity(yeastFlocTypeEntityID);
        testYeastFlocType.setName("New Name");
        me.updateYeastFlocTypeEntity(testYeastFlocType);

        // retrieve the updated employee and test that the update took place
        testYeastFlocType = me.getYeastFlocTypeEntity(yeastFlocTypeEntityID);

        assertEquals("Expected New Name, got " + testYeastFlocType.getName(),
                "New Name", testYeastFlocType.getName());

        // clean up
        me.deleteYeastFlocTypeEntity(testYeastFlocType);

    }

    @Test
    public void testDeleteYeastFlocTypeEntity() throws Exception {

        YeastFlocTypeDao me = new YeastFlocTypeDao();
        YeastFlocTypeEntity testYeastFlocType = new YeastFlocTypeEntity();
        int yeastFlocTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastFlocType = new YeastFlocTypeEntity();
        testYeastFlocType.setName("YeastFloc Type 1");
        testYeastFlocType.setUpdateDate(ts);
        testYeastFlocType.setCreateDate(ts);

        yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testYeastFlocType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero yeastFloc type ID, got " + yeastFlocTypeEntityID, yeastFlocTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteYeastFlocTypeEntity(me.getYeastFlocTypeEntity(yeastFlocTypeEntityID));
        assertNull(me.getYeastFlocTypeEntity(yeastFlocTypeEntityID));

    }

    @Test
    public void testAddYeastFlocTypeEntity() throws Exception {

        YeastFlocTypeDao me = new YeastFlocTypeDao();
        YeastFlocTypeEntity testYeastFlocType = new YeastFlocTypeEntity();
        int yeastFlocTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastFlocType = new YeastFlocTypeEntity();
        testYeastFlocType.setName("YeastFloc Type 1");
        testYeastFlocType.setUpdateDate(ts);
        testYeastFlocType.setCreateDate(ts);

        yeastFlocTypeEntityID = me.addYeastFlocTypeEntity(testYeastFlocType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero yeastFloc type ID, got " + yeastFlocTypeEntityID, yeastFlocTypeEntityID > 0);

        // clean up
        testYeastFlocType = me.getYeastFlocTypeEntity(yeastFlocTypeEntityID);
        me.deleteYeastFlocTypeEntity(testYeastFlocType);

    }
}