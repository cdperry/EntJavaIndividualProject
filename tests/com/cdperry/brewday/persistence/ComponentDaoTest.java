package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class ComponentDaoTest {

    @Test
    public void testGetAllComponents() throws Exception {

        ComponentDao me = new ComponentDao();
        ComponentEntity testComponent;
        List<ComponentEntity> hopTypes;
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentEntity();
        testComponent.setName("Component 1");
        testComponent.setComponentTypeId(1);
        testComponent.setCompHopId(1);
        testComponent.setCompGrainId(1);
        testComponent.setCompYeastId(1);
        testComponent.setCompWaterId(1);
        testComponent.setCompOtherId(1);
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        hopTypeEntityID = me.addComponentEntity(testComponent);

        // create a test grain and add them to the database
        testComponent = new ComponentEntity();
        testComponent.setName("Component 2");
        testComponent.setComponentTypeId(2);
        testComponent.setCompHopId(2);
        testComponent.setCompGrainId(2);
        testComponent.setCompYeastId(2);
        testComponent.setCompWaterId(2);
        testComponent.setCompOtherId(2);
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        hopTypeEntityID = me.addComponentEntity(testComponent);

        hopTypes = me.getAllComponents();
        assertTrue(hopTypes.size() > 0);

        // clean up
        for (ComponentEntity component : hopTypes) {
            me.deleteComponentEntity(component);
        }

    }

    @Test
    public void testGetComponentEntity() throws Exception {

        ComponentDao me = new ComponentDao();
        ComponentEntity testComponent = new ComponentEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testComponent = new ComponentEntity();
        testComponent.setName("Component 1");
        testComponent.setComponentTypeId(1);
        testComponent.setCompHopId(1);
        testComponent.setCompGrainId(1);
        testComponent.setCompYeastId(1);
        testComponent.setCompWaterId(1);
        testComponent.setCompOtherId(1);
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        hopTypeEntityID = me.addComponentEntity(testComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + hopTypeEntityID, hopTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testComponent = me.getComponentEntity(hopTypeEntityID);
        assertNotNull(testComponent);

        // clean up
        me.deleteComponentEntity(testComponent);

    }

    @Test
    public void testUpdateComponentEntity() throws Exception {

        ComponentDao me = new ComponentDao();
        ComponentEntity testComponent = new ComponentEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent = new ComponentEntity();
        testComponent.setName("Component 1");
        testComponent.setComponentTypeId(1);
        testComponent.setCompHopId(1);
        testComponent.setCompGrainId(1);
        testComponent.setCompYeastId(1);
        testComponent.setCompWaterId(1);
        testComponent.setCompOtherId(1);
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        hopTypeEntityID = me.addComponentEntity(testComponent);

        // retrieve the test component from the database and change its name
        testComponent = me.getComponentEntity(hopTypeEntityID);
        testComponent.setName("New Name");
        me.updateComponentEntity(testComponent);

        // retrieve the updated employee and test that the update took place
        testComponent = me.getComponentEntity(hopTypeEntityID);

        assertEquals("Expected New Name, got " + testComponent.getName(),
                "New Name", testComponent.getName());

        // clean up
        me.deleteComponentEntity(testComponent);

    }

    @Test
    public void testDeleteComponentEntity() throws Exception {

        ComponentDao me = new ComponentDao();
        ComponentEntity testComponent = new ComponentEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent = new ComponentEntity();
        testComponent.setName("Component 1");
        testComponent.setComponentTypeId(1);
        testComponent.setCompHopId(1);
        testComponent.setCompGrainId(1);
        testComponent.setCompYeastId(1);
        testComponent.setCompWaterId(1);
        testComponent.setCompOtherId(1);
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        hopTypeEntityID = me.addComponentEntity(testComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero component ID, got " + hopTypeEntityID, hopTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteComponentEntity(me.getComponentEntity(hopTypeEntityID));
        assertNull(me.getComponentEntity(hopTypeEntityID));

    }

    @Test
    public void testAddComponentEntity() throws Exception {

        ComponentDao me = new ComponentDao();
        ComponentEntity testComponent = new ComponentEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testComponent = new ComponentEntity();
        testComponent.setName("Component 1");
        testComponent.setComponentTypeId(1);
        testComponent.setCompHopId(1);
        testComponent.setCompGrainId(1);
        testComponent.setCompYeastId(1);
        testComponent.setCompWaterId(1);
        testComponent.setCompOtherId(1);
        testComponent.setUpdateDate(ts);
        testComponent.setCreateDate(ts);

        hopTypeEntityID = me.addComponentEntity(testComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero component ID, got " + hopTypeEntityID, hopTypeEntityID > 0);

        // clean up
        testComponent = me.getComponentEntity(hopTypeEntityID);
        me.deleteComponentEntity(testComponent);

    }
}