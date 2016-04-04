package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentWaterEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentWaterDaoTest {

    @Test
    public void testGetAllComponentWaters() throws Exception {

        ComponentWaterDao me = new ComponentWaterDao();
        ComponentWaterEntity testComponent;
        List<ComponentWaterEntity> componentWaters;
        int componentWaterEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentWaterEntity();
        testComponent.setComponentId(1);
        testComponent.setName("Water 1");
        testComponent.setPh(new BigDecimal("1.0"));
        testComponent.setCaPpm(new BigDecimal("1.0"));
        testComponent.setMgPpm(new BigDecimal("1.0"));
        testComponent.setNaPpm(new BigDecimal("1.0"));
        testComponent.setSo4Ppm(new BigDecimal("1.0"));
        testComponent.setClPpm(new BigDecimal("1.0"));
        testComponent.setHco3Ppm(new BigDecimal("1.0"));
        testComponent.setCaso4G(new BigDecimal("1.0"));
        testComponent.setNaclG(new BigDecimal("1.0"));
        testComponent.setMgso4G(new BigDecimal("1.0"));
        testComponent.setCaclG(new BigDecimal("1.0"));
        testComponent.setNahco3G(new BigDecimal("1.0"));
        testComponent.setCaco3G(new BigDecimal("1.0"));
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentWaterEntityID = me.addComponentWaterEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentWaterEntity();
        testComponent.setComponentId(1);
        testComponent.setName("Water 2");
        testComponent.setPh(new BigDecimal("1.0"));
        testComponent.setCaPpm(new BigDecimal("1.0"));
        testComponent.setMgPpm(new BigDecimal("1.0"));
        testComponent.setNaPpm(new BigDecimal("1.0"));
        testComponent.setSo4Ppm(new BigDecimal("1.0"));
        testComponent.setClPpm(new BigDecimal("1.0"));
        testComponent.setHco3Ppm(new BigDecimal("1.0"));
        testComponent.setCaso4G(new BigDecimal("1.0"));
        testComponent.setNaclG(new BigDecimal("1.0"));
        testComponent.setMgso4G(new BigDecimal("1.0"));
        testComponent.setCaclG(new BigDecimal("1.0"));
        testComponent.setNahco3G(new BigDecimal("1.0"));
        testComponent.setCaco3G(new BigDecimal("1.0"));
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentWaterEntityID = me.addComponentWaterEntity(testComponent);

        componentWaters = me.getAllComponentWaters();
        assertTrue(componentWaters.size() > 0);

        // clean up
        for (ComponentWaterEntity component : componentWaters) {
            me.deleteComponentWaterEntity(component);
        }

    }

    @Test
    public void testGetComponentWaterEntity() throws Exception {

        ComponentWaterDao me = new ComponentWaterDao();
        ComponentWaterEntity testComponent = new ComponentWaterEntity();
        int componentWaterEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Water 1");
        testComponent.setPh(new BigDecimal("1.0"));
        testComponent.setCaPpm(new BigDecimal("1.0"));
        testComponent.setMgPpm(new BigDecimal("1.0"));
        testComponent.setNaPpm(new BigDecimal("1.0"));
        testComponent.setSo4Ppm(new BigDecimal("1.0"));
        testComponent.setClPpm(new BigDecimal("1.0"));
        testComponent.setHco3Ppm(new BigDecimal("1.0"));
        testComponent.setCaso4G(new BigDecimal("1.0"));
        testComponent.setNaclG(new BigDecimal("1.0"));
        testComponent.setMgso4G(new BigDecimal("1.0"));
        testComponent.setCaclG(new BigDecimal("1.0"));
        testComponent.setNahco3G(new BigDecimal("1.0"));
        testComponent.setCaco3G(new BigDecimal("1.0"));
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentWaterEntityID = me.addComponentWaterEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentWaterEntityID, componentWaterEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentWaterEntity(componentWaterEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentWaterEntity(testComponent);

    }

    @Test
    public void testUpdateComponentWaterEntity() throws Exception {

        ComponentWaterDao me = new ComponentWaterDao();
        ComponentWaterEntity testComponent = new ComponentWaterEntity();
        int componentWaterEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Water 1");
        testComponent.setPh(new BigDecimal("1.0"));
        testComponent.setCaPpm(new BigDecimal("1.0"));
        testComponent.setMgPpm(new BigDecimal("1.0"));
        testComponent.setNaPpm(new BigDecimal("1.0"));
        testComponent.setSo4Ppm(new BigDecimal("1.0"));
        testComponent.setClPpm(new BigDecimal("1.0"));
        testComponent.setHco3Ppm(new BigDecimal("1.0"));
        testComponent.setCaso4G(new BigDecimal("1.0"));
        testComponent.setNaclG(new BigDecimal("1.0"));
        testComponent.setMgso4G(new BigDecimal("1.0"));
        testComponent.setCaclG(new BigDecimal("1.0"));
        testComponent.setNahco3G(new BigDecimal("1.0"));
        testComponent.setCaco3G(new BigDecimal("1.0"));
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentWaterEntityID = me.addComponentWaterEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentWaterEntity(componentWaterEntityID);
        testComponent.setName("New Name");
        me.updateComponentWaterEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentWaterEntity(componentWaterEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentWaterEntity(testComponent);

    }

    @Test
    public void testDeleteComponentWaterEntity() throws Exception {

        ComponentWaterDao me = new ComponentWaterDao();
        ComponentWaterEntity testComponent = new ComponentWaterEntity();
        int componentWaterEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Water 1");
        testComponent.setPh(new BigDecimal("1.0"));
        testComponent.setCaPpm(new BigDecimal("1.0"));
        testComponent.setMgPpm(new BigDecimal("1.0"));
        testComponent.setNaPpm(new BigDecimal("1.0"));
        testComponent.setSo4Ppm(new BigDecimal("1.0"));
        testComponent.setClPpm(new BigDecimal("1.0"));
        testComponent.setHco3Ppm(new BigDecimal("1.0"));
        testComponent.setCaso4G(new BigDecimal("1.0"));
        testComponent.setNaclG(new BigDecimal("1.0"));
        testComponent.setMgso4G(new BigDecimal("1.0"));
        testComponent.setCaclG(new BigDecimal("1.0"));
        testComponent.setNahco3G(new BigDecimal("1.0"));
        testComponent.setCaco3G(new BigDecimal("1.0"));
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentWaterEntityID = me.addComponentWaterEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + componentWaterEntityID, componentWaterEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentWaterEntity(me.getComponentWaterEntity(componentWaterEntityID));
        assertNull(me.getComponentWaterEntity(componentWaterEntityID));

    }

    @Test
    public void testAddComponentWaterEntity() throws Exception {

        ComponentWaterDao me = new ComponentWaterDao();
        ComponentWaterEntity testComponent = new ComponentWaterEntity();
        int componentWaterEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent.setComponentId(1);
        testComponent.setName("Water 1");
        testComponent.setPh(new BigDecimal("1.0"));
        testComponent.setCaPpm(new BigDecimal("1.0"));
        testComponent.setMgPpm(new BigDecimal("1.0"));
        testComponent.setNaPpm(new BigDecimal("1.0"));
        testComponent.setSo4Ppm(new BigDecimal("1.0"));
        testComponent.setClPpm(new BigDecimal("1.0"));
        testComponent.setHco3Ppm(new BigDecimal("1.0"));
        testComponent.setCaso4G(new BigDecimal("1.0"));
        testComponent.setNaclG(new BigDecimal("1.0"));
        testComponent.setMgso4G(new BigDecimal("1.0"));
        testComponent.setCaclG(new BigDecimal("1.0"));
        testComponent.setNahco3G(new BigDecimal("1.0"));
        testComponent.setCaco3G(new BigDecimal("1.0"));
        testComponent.setBatchSize(new BigDecimal("10"));
        testComponent.setBatchSizeUomId(1);
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        componentWaterEntityID = me.addComponentWaterEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentWaterEntityID, componentWaterEntityID > 0);

        // clean up
        testComponent = me.getComponentWaterEntity(componentWaterEntityID);
        me.deleteComponentWaterEntity(testComponent);

    }

}