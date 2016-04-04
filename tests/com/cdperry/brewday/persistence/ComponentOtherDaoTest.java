package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentOtherEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentOtherDaoTest {

    @Test
    public void testGetAllComponentOthers() throws Exception {

        ComponentOtherDao me = new ComponentOtherDao();
        ComponentOtherEntity testComponent;
        List<ComponentOtherEntity> componentOthers;
        int componentOtherEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentOtherEntity();
        testComponent.setComponentId(1);
        testComponent.setName("Other 1");
        testComponent.setUseFor("Use this for ...");
        testComponent.setUseTypeId(1);
        testComponent.setTime(new BigDecimal("10"));
        testComponent.setTimeUomId(1);
        testComponent.setAmount(new BigDecimal("10"));
        testComponent.setAmountUomId(1);
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentOtherEntityID = me.addComponentOtherEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentOtherEntity();
        testComponent.setComponentId(1);
        testComponent.setName("Other 2");
        testComponent.setUseFor("Use this for ...");
        testComponent.setUseTypeId(1);
        testComponent.setTime(new BigDecimal("10"));
        testComponent.setTimeUomId(1);
        testComponent.setAmount(new BigDecimal("10"));
        testComponent.setAmountUomId(1);
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentOtherEntityID = me.addComponentOtherEntity(testComponent);

        componentOthers = me.getAllComponentOthers();
        assertTrue(componentOthers.size() > 0);

        // clean up
        for (ComponentOtherEntity component : componentOthers) {
            me.deleteComponentOtherEntity(component);
        }

    }

    @Test
    public void testGetComponentOtherEntity() throws Exception {

        ComponentOtherDao me = new ComponentOtherDao();
        ComponentOtherEntity testComponent = new ComponentOtherEntity();
        int componentOtherEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Other 1");
        testComponent.setUseFor("Use this for ...");
        testComponent.setUseTypeId(1);
        testComponent.setTime(new BigDecimal("10"));
        testComponent.setTimeUomId(1);
        testComponent.setAmount(new BigDecimal("10"));
        testComponent.setAmountUomId(1);
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentOtherEntityID = me.addComponentOtherEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentOtherEntityID, componentOtherEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentOtherEntity(componentOtherEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentOtherEntity(testComponent);

    }

    @Test
    public void testUpdateComponentOtherEntity() throws Exception {

        ComponentOtherDao me = new ComponentOtherDao();
        ComponentOtherEntity testComponent = new ComponentOtherEntity();
        int componentOtherEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Other 1");
        testComponent.setUseFor("Use this for ...");
        testComponent.setUseTypeId(1);
        testComponent.setTime(new BigDecimal("10"));
        testComponent.setTimeUomId(1);
        testComponent.setAmount(new BigDecimal("10"));
        testComponent.setAmountUomId(1);
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);
        componentOtherEntityID = me.addComponentOtherEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentOtherEntity(componentOtherEntityID);
        testComponent.setName("New Name");
        me.updateComponentOtherEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentOtherEntity(componentOtherEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentOtherEntity(testComponent);

    }

    @Test
    public void testDeleteComponentOtherEntity() throws Exception {

        ComponentOtherDao me = new ComponentOtherDao();
        ComponentOtherEntity testComponent = new ComponentOtherEntity();
        int componentOtherEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Other 1");
        testComponent.setUseFor("Use this for ...");
        testComponent.setUseTypeId(1);
        testComponent.setTime(new BigDecimal("10"));
        testComponent.setTimeUomId(1);
        testComponent.setAmount(new BigDecimal("10"));
        testComponent.setAmountUomId(1);
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentOtherEntityID = me.addComponentOtherEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + componentOtherEntityID, componentOtherEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentOtherEntity(me.getComponentOtherEntity(componentOtherEntityID));
        assertNull(me.getComponentOtherEntity(componentOtherEntityID));

    }

    @Test
    public void testAddComponentOtherEntity() throws Exception {

        ComponentOtherDao me = new ComponentOtherDao();
        ComponentOtherEntity testComponent = new ComponentOtherEntity();
        int componentOtherEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Other 1");
        testComponent.setUseFor("Use this for ...");
        testComponent.setUseTypeId(1);
        testComponent.setTime(new BigDecimal("10"));
        testComponent.setTimeUomId(1);
        testComponent.setAmount(new BigDecimal("10"));
        testComponent.setAmountUomId(1);
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentOtherEntityID = me.addComponentOtherEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentOtherEntityID, componentOtherEntityID > 0);

        // clean up
        testComponent = me.getComponentOtherEntity(componentOtherEntityID);
        me.deleteComponentOtherEntity(testComponent);

    }

}