package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.HopTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class HopTypeDaoTest {

    @Test
    public void testGetAllHopTypes() throws Exception {

        HopTypeDao me = new HopTypeDao();
        HopTypeEntity testHopType;
        List<HopTypeEntity> hopTypes;
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testHopType = new HopTypeEntity();
        testHopType.setName("Hop Type 1");
        testHopType.setUpdateDate(ts);
        testHopType.setCreateDate(ts);

        hopTypeEntityID = me.addHopTypeEntity(testHopType);

        // create a test grain and add them to the database
        testHopType = new HopTypeEntity();
        testHopType.setName("Hop Type 2");
        testHopType.setUpdateDate(ts);
        testHopType.setCreateDate(ts);

        hopTypeEntityID = me.addHopTypeEntity(testHopType);

        hopTypes = me.getAllHopTypes();
        assertTrue(hopTypes.size() > 0);

        // clean up
        for (HopTypeEntity component : hopTypes) {
            me.deleteHopTypeEntity(component);
        }

    }

    @Test
    public void testGetHopTypeEntity() throws Exception {

        HopTypeDao me = new HopTypeDao();
        HopTypeEntity testHopType = new HopTypeEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testHopType = new HopTypeEntity();
        testHopType.setName("Hop Type 1");
        testHopType.setUpdateDate(ts);
        testHopType.setCreateDate(ts);

        hopTypeEntityID = me.addHopTypeEntity(testHopType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero hop type ID, got " + hopTypeEntityID, hopTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testHopType = me.getHopTypeEntity(hopTypeEntityID);
        assertNotNull(testHopType);

        // clean up
        me.deleteHopTypeEntity(testHopType);

    }

    @Test
    public void testUpdateHopTypeEntity() throws Exception {

        HopTypeDao me = new HopTypeDao();
        HopTypeEntity testHopType = new HopTypeEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopType = new HopTypeEntity();
        testHopType.setName("Hop Type 1");
        testHopType.setUpdateDate(ts);
        testHopType.setCreateDate(ts);

        hopTypeEntityID = me.addHopTypeEntity(testHopType);

        // retrieve the test component from the database and change its name
        testHopType = me.getHopTypeEntity(hopTypeEntityID);
        testHopType.setName("New Name");
        me.updateHopTypeEntity(testHopType);

        // retrieve the updated employee and test that the update took place
        testHopType = me.getHopTypeEntity(hopTypeEntityID);

        assertEquals("Expected New Name, got " + testHopType.getName(),
                "New Name", testHopType.getName());

        // clean up
        me.deleteHopTypeEntity(testHopType);

    }

    @Test
    public void testDeleteHopTypeEntity() throws Exception {

        HopTypeDao me = new HopTypeDao();
        HopTypeEntity testHopType = new HopTypeEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopType = new HopTypeEntity();
        testHopType.setName("Hop Type 1");
        testHopType.setUpdateDate(ts);
        testHopType.setCreateDate(ts);

        hopTypeEntityID = me.addHopTypeEntity(testHopType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero hop type ID, got " + hopTypeEntityID, hopTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteHopTypeEntity(me.getHopTypeEntity(hopTypeEntityID));
        assertNull(me.getHopTypeEntity(hopTypeEntityID));

    }

    @Test
    public void testAddHopTypeEntity() throws Exception {

        HopTypeDao me = new HopTypeDao();
        HopTypeEntity testHopType = new HopTypeEntity();
        int hopTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testHopType = new HopTypeEntity();
        testHopType.setName("Hop Type 1");
        testHopType.setUpdateDate(ts);
        testHopType.setCreateDate(ts);

        hopTypeEntityID = me.addHopTypeEntity(testHopType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero hop type ID, got " + hopTypeEntityID, hopTypeEntityID > 0);

        // clean up
        testHopType = me.getHopTypeEntity(hopTypeEntityID);
        me.deleteHopTypeEntity(testHopType);

    }
}