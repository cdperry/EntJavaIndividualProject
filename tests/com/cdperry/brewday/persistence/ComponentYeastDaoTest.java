package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentYeastEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentYeastDaoTest {

    @Test
    public void testGetAllComponentYeasts() throws Exception {

        ComponentYeastDao me = new ComponentYeastDao();
        ComponentYeastEntity testComponent;
        List<ComponentYeastEntity> componentYeasts;
        int componentYeastEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentYeastEntity();
        testComponent.setComponentId(1);
        testComponent.setName("Yeast 1");
//        testComponent.setLabId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setYeastTypeId(1);
//        testComponent.setYeastFormId(1);
//        testComponent.setYeastFlocTypeId(1);
        testComponent.setAttenuationMin(new BigDecimal("1.0"));
        testComponent.setAttenuationMax(new BigDecimal("1.0"));
        testComponent.setTemperatureMin(new BigDecimal("1.0"));
        testComponent.setTemperatureMax(new BigDecimal("1.0"));
        testComponent.setCellsPerPack(new BigDecimal("1.0"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentYeastEntityID = me.addComponentYeastEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentYeastEntity();
        testComponent.setComponentId(1);
        testComponent.setName("Yeast 2");
//        testComponent.setLabId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setYeastTypeId(1);
//        testComponent.setYeastFormId(1);
//        testComponent.setYeastFlocTypeId(1);
        testComponent.setAttenuationMin(new BigDecimal("1.0"));
        testComponent.setAttenuationMax(new BigDecimal("1.0"));
        testComponent.setTemperatureMin(new BigDecimal("1.0"));
        testComponent.setTemperatureMax(new BigDecimal("1.0"));
        testComponent.setCellsPerPack(new BigDecimal("1.0"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentYeastEntityID = me.addComponentYeastEntity(testComponent);

        componentYeasts = me.getAllComponentYeasts();
        assertTrue(componentYeasts.size() > 0);

        // clean up
        for (ComponentYeastEntity component : componentYeasts) {
            me.deleteComponentYeastEntity(component);
        }

    }

    @Test
    public void testGetComponentYeastEntity() throws Exception {

        ComponentYeastDao me = new ComponentYeastDao();
        ComponentYeastEntity testComponent = new ComponentYeastEntity();
        int componentYeastEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Yeast 1");
//        testComponent.setLabId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setYeastTypeId(1);
//        testComponent.setYeastFormId(1);
//        testComponent.setYeastFlocTypeId(1);
        testComponent.setAttenuationMin(new BigDecimal("1.0"));
        testComponent.setAttenuationMax(new BigDecimal("1.0"));
        testComponent.setTemperatureMin(new BigDecimal("1.0"));
        testComponent.setTemperatureMax(new BigDecimal("1.0"));
        testComponent.setCellsPerPack(new BigDecimal("1.0"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentYeastEntityID = me.addComponentYeastEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentYeastEntityID, componentYeastEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentYeastEntity(componentYeastEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentYeastEntity(testComponent);

    }

    @Test
    public void testUpdateComponentYeastEntity() throws Exception {

        ComponentYeastDao me = new ComponentYeastDao();
        ComponentYeastEntity testComponent = new ComponentYeastEntity();
        int componentYeastEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Yeast 1");
//        testComponent.setLabId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setYeastTypeId(1);
//        testComponent.setYeastFormId(1);
//        testComponent.setYeastFlocTypeId(1);
        testComponent.setAttenuationMin(new BigDecimal("1.0"));
        testComponent.setAttenuationMax(new BigDecimal("1.0"));
        testComponent.setTemperatureMin(new BigDecimal("1.0"));
        testComponent.setTemperatureMax(new BigDecimal("1.0"));
        testComponent.setCellsPerPack(new BigDecimal("1.0"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentYeastEntityID = me.addComponentYeastEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentYeastEntity(componentYeastEntityID);
        testComponent.setName("New Name");
        me.updateComponentYeastEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentYeastEntity(componentYeastEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentYeastEntity(testComponent);

    }

    @Test
    public void testDeleteComponentYeastEntity() throws Exception {

        ComponentYeastDao me = new ComponentYeastDao();
        ComponentYeastEntity testComponent = new ComponentYeastEntity();
        int componentYeastEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Yeast 1");
//        testComponent.setLabId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setYeastTypeId(1);
//        testComponent.setYeastFormId(1);
//        testComponent.setYeastFlocTypeId(1);
        testComponent.setAttenuationMin(new BigDecimal("1.0"));
        testComponent.setAttenuationMax(new BigDecimal("1.0"));
        testComponent.setTemperatureMin(new BigDecimal("1.0"));
        testComponent.setTemperatureMax(new BigDecimal("1.0"));
        testComponent.setCellsPerPack(new BigDecimal("1.0"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentYeastEntityID = me.addComponentYeastEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + componentYeastEntityID, componentYeastEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentYeastEntity(me.getComponentYeastEntity(componentYeastEntityID));
        assertNull(me.getComponentYeastEntity(componentYeastEntityID));

    }

    @Test
    public void testAddComponentYeastEntity() throws Exception {

        ComponentYeastDao me = new ComponentYeastDao();
        ComponentYeastEntity testComponent = new ComponentYeastEntity();
        int componentYeastEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Yeast 1");
//        testComponent.setLabId(1);
//        testComponent.setSupplierId(1);
//        testComponent.setYeastTypeId(1);
//        testComponent.setYeastFormId(1);
//        testComponent.setYeastFlocTypeId(1);
        testComponent.setAttenuationMin(new BigDecimal("1.0"));
        testComponent.setAttenuationMax(new BigDecimal("1.0"));
        testComponent.setTemperatureMin(new BigDecimal("1.0"));
        testComponent.setTemperatureMax(new BigDecimal("1.0"));
        testComponent.setCellsPerPack(new BigDecimal("1.0"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentYeastEntityID = me.addComponentYeastEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentYeastEntityID, componentYeastEntityID > 0);

        // clean up
        testComponent = me.getComponentYeastEntity(componentYeastEntityID);
        me.deleteComponentYeastEntity(testComponent);

    }

}