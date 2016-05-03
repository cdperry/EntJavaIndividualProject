package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentGrainEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentGrainDaoTest {

    @Test
    public void testGetAllComponentGrains() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent;
        List<ComponentGrainEntity> componentGrains;
        int componentGrainEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentGrainEntity();
        testComponent.setName("Grain 1");
        testComponent.setComponentId(1);
//        testComponent.setOriginId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentGrainEntity();
        testComponent.setName("Grain 2");
        testComponent.setComponentId(1);
//        testComponent.setOriginId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        componentGrains = me.getAllComponentGrains();
        assertTrue(componentGrains.size() > 0);

        // clean up
        for (ComponentGrainEntity component : componentGrains) {
            me.deleteComponentGrainEntity(component);
        }

    }

    @Test
    public void testGetComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent.setName("Grain");
        testComponent.setComponentId(1);
//        testComponent.setOriginId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentGrainEntityID, componentGrainEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentGrainEntity(testComponent);

    }

    @Test
    public void testUpdateComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Grain");
        testComponent.setComponentId(1);
//        testComponent.setOriginId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);
        testComponent.setName("New Name");
        me.updateComponentGrainEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentGrainEntity(testComponent);

    }

    @Test
    public void testDeleteComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Grain");
        testComponent.setComponentId(1);
//        testComponent.setOriginId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + componentGrainEntityID, componentGrainEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentGrainEntity(me.getComponentGrainEntity(componentGrainEntityID));
        assertNull(me.getComponentGrainEntity(componentGrainEntityID));

    }

    @Test
    public void testAddComponentGrainEntity() throws Exception {

        ComponentGrainDao me = new ComponentGrainDao();
        ComponentGrainEntity testComponent = new ComponentGrainEntity();
        int componentGrainEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Grain");
        testComponent.setComponentId(1);
//        testComponent.setOriginId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setGrainTypeId(1);
        testComponent.setColor(new BigDecimal("1.5"));
        testComponent.setPotential(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentGrainEntityID = me.addComponentGrainEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentGrainEntityID, componentGrainEntityID > 0);

        // clean up
        testComponent = me.getComponentGrainEntity(componentGrainEntityID);
        me.deleteComponentGrainEntity(testComponent);

    }

}