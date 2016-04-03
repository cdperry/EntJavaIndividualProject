package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentHopEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentHopDaoTest {

    @Test
    public void testGetAllComponentHops() throws Exception {

        ComponentHopDao me = new ComponentHopDao();
        ComponentHopEntity testComponent;
        List<ComponentHopEntity> componentHops;
        int componentHopEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentHopEntity();
        testComponent.setName("Hop 1");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setHopTypeId(1);
        testComponent.setHopFormId(1);
        testComponent.setAlphaPct(new BigDecimal("1.5"));
        testComponent.setBetaPct(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentHopEntityID = me.addComponentHopEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentHopEntity();
        testComponent.setName("Hop 2");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setHopTypeId(1);
        testComponent.setHopFormId(1);
        testComponent.setAlphaPct(new BigDecimal("1.5"));
        testComponent.setBetaPct(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentHopEntityID = me.addComponentHopEntity(testComponent);

        componentHops = me.getAllComponentHops();
        assertTrue(componentHops.size() > 0);

        // clean up
        for (ComponentHopEntity component : componentHops) {
            me.deleteComponentHopEntity(component);
        }
        
    }

    @Test
    public void testGetComponentHopEntity() throws Exception {

        ComponentHopDao me = new ComponentHopDao();
        ComponentHopEntity testComponent = new ComponentHopEntity();
        int componentHopEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test grain and add them to the database
        testComponent.setName("Hop 1");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setHopTypeId(1);
        testComponent.setHopFormId(1);
        testComponent.setAlphaPct(new BigDecimal("1.5"));
        testComponent.setBetaPct(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentHopEntityID = me.addComponentHopEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentHopEntityID, componentHopEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentHopEntity(componentHopEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentHopEntity(testComponent);
        
    }

    @Test
    public void testUpdateComponentHopEntity() throws Exception {

        ComponentHopDao me = new ComponentHopDao();
        ComponentHopEntity testComponent = new ComponentHopEntity();
        int componentHopEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Hop 1");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setHopTypeId(1);
        testComponent.setHopFormId(1);
        testComponent.setAlphaPct(new BigDecimal("1.5"));
        testComponent.setBetaPct(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentHopEntityID = me.addComponentHopEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentHopEntity(componentHopEntityID);
        testComponent.setName("New Name");
        me.updateComponentHopEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentHopEntity(componentHopEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentHopEntity(testComponent);
        
    }

    @Test
    public void testDeleteComponentHopEntity() throws Exception {

        ComponentHopDao me = new ComponentHopDao();
        ComponentHopEntity testComponent = new ComponentHopEntity();
        int componentHopEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Hop 1");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setHopTypeId(1);
        testComponent.setHopFormId(1);
        testComponent.setAlphaPct(new BigDecimal("1.5"));
        testComponent.setBetaPct(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentHopEntityID = me.addComponentHopEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + componentHopEntityID, componentHopEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentHopEntity(me.getComponentHopEntity(componentHopEntityID));
        assertNull(me.getComponentHopEntity(componentHopEntityID));
        
    }

    @Test
    public void testAddComponentHopEntity() throws Exception {

        ComponentHopDao me = new ComponentHopDao();
        ComponentHopEntity testComponent = new ComponentHopEntity();
        int componentHopEntityID;
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());

        // create a test component and add them to the database
        testComponent.setName("Hop 1");
        testComponent.setOriginId(1);
        testComponent.setSupplierId(1);
        testComponent.setHopTypeId(1);
        testComponent.setHopFormId(1);
        testComponent.setAlphaPct(new BigDecimal("1.5"));
        testComponent.setBetaPct(new BigDecimal("3.2"));
        testComponent.setNotes("This is a note.");
        testComponent.setUpdateDate(date);
        testComponent.setCreateDate(date);

        componentHopEntityID = me.addComponentHopEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + componentHopEntityID, componentHopEntityID > 0);

        // clean up
        testComponent = me.getComponentHopEntity(componentHopEntityID);
        me.deleteComponentHopEntity(testComponent);
        
    }

}