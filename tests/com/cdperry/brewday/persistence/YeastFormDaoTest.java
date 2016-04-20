package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastFormEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class YeastFormDaoTest {

    @Test
    public void testGetAllYeastForms() throws Exception {

        YeastFormDao me = new YeastFormDao();
        YeastFormEntity testYeastForm;
        List<YeastFormEntity> yeastForms;
        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Form 1");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        // create a test grain and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Form 2");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        yeastForms = me.getAllYeastForms();
        assertTrue(yeastForms.size() > 0);

        // clean up
        for (YeastFormEntity component : yeastForms) {
            me.deleteYeastFormEntity(component);
        }

    }

    @Test
    public void testGetYeastFormEntity() throws Exception {

        YeastFormDao me = new YeastFormDao();
        YeastFormEntity testYeastForm = new YeastFormEntity();
        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Form 1");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero yeast form ID, got " + yeastFormEntityID, yeastFormEntityID > 0);

        // confirm that the component can be retrieved from the database
        testYeastForm = me.getYeastFormEntity(yeastFormEntityID);
        assertNotNull(testYeastForm);

        // clean up
        me.deleteYeastFormEntity(testYeastForm);

    }

    @Test
    public void testUpdateYeastFormEntity() throws Exception {

        YeastFormDao me = new YeastFormDao();
        YeastFormEntity testYeastForm = new YeastFormEntity();
        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Form 1");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        // retrieve the test component from the database and change its name
        testYeastForm = me.getYeastFormEntity(yeastFormEntityID);
        testYeastForm.setName("New Name");
        me.updateYeastFormEntity(testYeastForm);

        // retrieve the updated employee and test that the update took place
        testYeastForm = me.getYeastFormEntity(yeastFormEntityID);

        assertEquals("Expected New Name, got " + testYeastForm.getName(),
                "New Name", testYeastForm.getName());

        // clean up
        me.deleteYeastFormEntity(testYeastForm);

    }

    @Test
    public void testDeleteYeastFormEntity() throws Exception {

        YeastFormDao me = new YeastFormDao();
        YeastFormEntity testYeastForm = new YeastFormEntity();
        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Form 1");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero yeast form ID, got " + yeastFormEntityID, yeastFormEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteYeastFormEntity(me.getYeastFormEntity(yeastFormEntityID));
        assertNull(me.getYeastFormEntity(yeastFormEntityID));

    }

    @Test
    public void testAddYeastFormEntity() throws Exception {

        YeastFormDao me = new YeastFormDao();
        YeastFormEntity testYeastForm = new YeastFormEntity();
        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Form 1");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero yeast form ID, got " + yeastFormEntityID, yeastFormEntityID > 0);

        // clean up
        testYeastForm = me.getYeastFormEntity(yeastFormEntityID);
        me.deleteYeastFormEntity(testYeastForm);

    }

    @Test
    public void testDeleteYeastFormEntityById() throws Exception {

        YeastFormDao me = new YeastFormDao();
        YeastFormEntity testYeastForm = new YeastFormEntity();
        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testYeastForm = new YeastFormEntity();
        testYeastForm.setName("Yeast Type 1");
        testYeastForm.setUpdateDate(ts);
        testYeastForm.setCreateDate(ts);

        yeastFormEntityID = me.addYeastFormEntity(testYeastForm);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero yeast type ID, got " + yeastFormEntityID, yeastFormEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteYeastFormEntityById(yeastFormEntityID);
        assertNull(me.getYeastFormEntity(yeastFormEntityID));

    }
    
}