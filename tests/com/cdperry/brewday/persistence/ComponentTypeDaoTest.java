package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class ComponentTypeDaoTest {

    @Test
    public void testGetAllComponentTypes() throws Exception {

        ComponentTypeDao me = new ComponentTypeDao();
        ComponentTypeEntity testComponentType;
        List<ComponentTypeEntity> componentTypes;
        int componentTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponentType = new ComponentTypeEntity();
        testComponentType.setName("Component Type 1");
        testComponentType.setUpdateDate(ts);
        testComponentType.setCreateDate(ts);

        componentTypeEntityID = me.addComponentTypeEntity(testComponentType);

        // create a test grain and add them to the database
        testComponentType = new ComponentTypeEntity();
        testComponentType.setName("Component Type 2");
        testComponentType.setUpdateDate(ts);
        testComponentType.setCreateDate(ts);

        componentTypeEntityID = me.addComponentTypeEntity(testComponentType);

        componentTypes = me.getAllComponentTypes();
        assertTrue(componentTypes.size() > 0);

        // clean up
        for (ComponentTypeEntity component : componentTypes) {
            me.deleteComponentTypeEntity(component);
        }

    }

    @Test
    public void testGetComponentTypeEntity() throws Exception {

        ComponentTypeDao me = new ComponentTypeDao();
        ComponentTypeEntity testComponentType = new ComponentTypeEntity();
        int componentTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponentType = new ComponentTypeEntity();
        testComponentType.setName("Component Type 1");
        testComponentType.setUpdateDate(ts);
        testComponentType.setCreateDate(ts);

        componentTypeEntityID = me.addComponentTypeEntity(testComponentType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component type ID, got " + componentTypeEntityID, componentTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponentType = me.getComponentTypeEntity(componentTypeEntityID);
        assertNotNull(testComponentType);

        // clean up
        me.deleteComponentTypeEntity(testComponentType);

    }

    @Test
    public void testUpdateComponentTypeEntity() throws Exception {

        ComponentTypeDao me = new ComponentTypeDao();
        ComponentTypeEntity testComponentType = new ComponentTypeEntity();
        int componentTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponentType = new ComponentTypeEntity();
        testComponentType.setName("Component Type 1");
        testComponentType.setUpdateDate(ts);
        testComponentType.setCreateDate(ts);

        componentTypeEntityID = me.addComponentTypeEntity(testComponentType);

        // retrieve the test component from the database and change its name
        testComponentType = me.getComponentTypeEntity(componentTypeEntityID);
        testComponentType.setName("New Name");
        me.updateComponentTypeEntity(testComponentType);

        // retrieve the updated employee and test that the update took place
        testComponentType = me.getComponentTypeEntity(componentTypeEntityID);

        assertEquals("Expected New Name, got " + testComponentType.getName(),
                "New Name", testComponentType.getName());

        // clean up
        me.deleteComponentTypeEntity(testComponentType);

    }

    @Test
    public void testDeleteComponentTypeEntity() throws Exception {

        ComponentTypeDao me = new ComponentTypeDao();
        ComponentTypeEntity testComponentType = new ComponentTypeEntity();
        int componentTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponentType = new ComponentTypeEntity();
        testComponentType.setName("Component Type 1");
        testComponentType.setUpdateDate(ts);
        testComponentType.setCreateDate(ts);

        componentTypeEntityID = me.addComponentTypeEntity(testComponentType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component type ID, got " + componentTypeEntityID, componentTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentTypeEntity(me.getComponentTypeEntity(componentTypeEntityID));
        assertNull(me.getComponentTypeEntity(componentTypeEntityID));

    }

    @Test
    public void testAddComponentTypeEntity() throws Exception {

        ComponentTypeDao me = new ComponentTypeDao();
        ComponentTypeEntity testComponentType = new ComponentTypeEntity();
        int componentTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponentType = new ComponentTypeEntity();
        testComponentType.setName("Component Type 1");
        testComponentType.setUpdateDate(ts);
        testComponentType.setCreateDate(ts);

        componentTypeEntityID = me.addComponentTypeEntity(testComponentType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component type ID, got " + componentTypeEntityID, componentTypeEntityID > 0);

        // clean up
        testComponentType = me.getComponentTypeEntity(componentTypeEntityID);
        me.deleteComponentTypeEntity(testComponentType);

    }
}