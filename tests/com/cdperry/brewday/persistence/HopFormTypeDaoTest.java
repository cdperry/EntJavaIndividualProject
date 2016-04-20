package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.HopFormTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class HopFormTypeDaoTest {

    @Test
    public void testGetAllHopFormTypes() throws Exception {

        HopFormTypeDao me = new HopFormTypeDao();
        HopFormTypeEntity testHopFormType;
        List<HopFormTypeEntity> hopFormTypes;
        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 1");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        // create a test grain and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 2");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        hopFormTypes = me.getAllHopFormTypes();
        assertTrue(hopFormTypes.size() > 0);

        // clean up
        for (HopFormTypeEntity component : hopFormTypes) {
            me.deleteHopFormTypeEntity(component);
        }

    }

    @Test
    public void testGetHopFormTypeEntity() throws Exception {

        HopFormTypeDao me = new HopFormTypeDao();
        HopFormTypeEntity testHopFormType = new HopFormTypeEntity();
        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 1");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero hop form type ID, got " + hopFormTypeEntityID, hopFormTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testHopFormType = me.getHopFormTypeEntity(hopFormTypeEntityID);
        assertNotNull(testHopFormType);

        // clean up
        me.deleteHopFormTypeEntity(testHopFormType);

    }

    @Test
    public void testUpdateHopFormTypeEntity() throws Exception {

        HopFormTypeDao me = new HopFormTypeDao();
        HopFormTypeEntity testHopFormType = new HopFormTypeEntity();
        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 1");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        // retrieve the test component from the database and change its name
        testHopFormType = me.getHopFormTypeEntity(hopFormTypeEntityID);
        testHopFormType.setName("New Name");
        me.updateHopFormTypeEntity(testHopFormType);

        // retrieve the updated employee and test that the update took place
        testHopFormType = me.getHopFormTypeEntity(hopFormTypeEntityID);

        assertEquals("Expected New Name, got " + testHopFormType.getName(),
                "New Name", testHopFormType.getName());

        // clean up
        me.deleteHopFormTypeEntity(testHopFormType);

    }

    @Test
    public void testDeleteHopFormTypeEntity() throws Exception {

        HopFormTypeDao me = new HopFormTypeDao();
        HopFormTypeEntity testHopFormType = new HopFormTypeEntity();
        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 1");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero hop form type ID, got " + hopFormTypeEntityID, hopFormTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteHopFormTypeEntity(me.getHopFormTypeEntity(hopFormTypeEntityID));
        assertNull(me.getHopFormTypeEntity(hopFormTypeEntityID));

    }

    @Test
    public void testAddHopFormTypeEntity() throws Exception {

        HopFormTypeDao me = new HopFormTypeDao();
        HopFormTypeEntity testHopFormType = new HopFormTypeEntity();
        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 1");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero hop form type ID, got " + hopFormTypeEntityID, hopFormTypeEntityID > 0);

        // clean up
        testHopFormType = me.getHopFormTypeEntity(hopFormTypeEntityID);
        me.deleteHopFormTypeEntity(testHopFormType);

    }

    @Test
    public void testDeleteHopFormTypeEntityById() throws Exception {

        HopFormTypeDao me = new HopFormTypeDao();
        HopFormTypeEntity testHopFormType = new HopFormTypeEntity();
        int hopFormTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopFormType = new HopFormTypeEntity();
        testHopFormType.setName("Hop Form Type 1");
        testHopFormType.setUpdateDate(ts);
        testHopFormType.setCreateDate(ts);

        hopFormTypeEntityID = me.addHopFormTypeEntity(testHopFormType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero hop form type ID, got " + hopFormTypeEntityID, hopFormTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteHopFormTypeEntityById(hopFormTypeEntityID);
        assertNull(me.getHopFormTypeEntity(hopFormTypeEntityID));

    }
    
}