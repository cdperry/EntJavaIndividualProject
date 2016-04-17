package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.GrainTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class GrainTypeDaoTest {

    @Test
    public void testGetAllGrainTypes() throws Exception {

        GrainTypeDao me = new GrainTypeDao();
        GrainTypeEntity testGrainType;
        List<GrainTypeEntity> grainTypes;
        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 1");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        // create a test grain and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 2");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        grainTypes = me.getAllGrainTypes();
        assertTrue(grainTypes.size() > 0);

        // clean up
        for (GrainTypeEntity component : grainTypes) {
            me.deleteGrainTypeEntity(component);
        }
        
    }

    @Test
    public void testGetGrainTypeEntity() throws Exception {

        GrainTypeDao me = new GrainTypeDao();
        GrainTypeEntity testGrainType = new GrainTypeEntity();
        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 1");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero grain type ID, got " + grainTypeEntityID, grainTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testGrainType = me.getGrainTypeEntity(grainTypeEntityID);
        assertNotNull(testGrainType);

        // clean up
        me.deleteGrainTypeEntity(testGrainType);

    }

    @Test
    public void testUpdateGrainTypeEntity() throws Exception {

        GrainTypeDao me = new GrainTypeDao();
        GrainTypeEntity testGrainType = new GrainTypeEntity();
        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 1");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        // retrieve the test component from the database and change its name
        testGrainType = me.getGrainTypeEntity(grainTypeEntityID);
        testGrainType.setName("New Name");
        me.updateGrainTypeEntity(testGrainType);

        // retrieve the updated employee and test that the update took place
        testGrainType = me.getGrainTypeEntity(grainTypeEntityID);

        assertEquals("Expected New Name, got " + testGrainType.getName(),
                "New Name", testGrainType.getName());

        // clean up
        me.deleteGrainTypeEntity(testGrainType);

    }

    @Test
    public void testDeleteGrainTypeEntity() throws Exception {

        GrainTypeDao me = new GrainTypeDao();
        GrainTypeEntity testGrainType = new GrainTypeEntity();
        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 1");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero grain type ID, got " + grainTypeEntityID, grainTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteGrainTypeEntity(me.getGrainTypeEntity(grainTypeEntityID));
        assertNull(me.getGrainTypeEntity(grainTypeEntityID));

    }

    @Test
    public void testAddGrainTypeEntity() throws Exception {

        GrainTypeDao me = new GrainTypeDao();
        GrainTypeEntity testGrainType = new GrainTypeEntity();
        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 1");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero grain type ID, got " + grainTypeEntityID, grainTypeEntityID > 0);

        // clean up
        testGrainType = me.getGrainTypeEntity(grainTypeEntityID);
        me.deleteGrainTypeEntity(testGrainType);

    }

    @Test
    public void testDeleteGrainTypeEntityById() throws Exception {

        GrainTypeDao me = new GrainTypeDao();
        GrainTypeEntity testGrainType = new GrainTypeEntity();
        int grainTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testGrainType = new GrainTypeEntity();
        testGrainType.setName("Grain Type 1");
        testGrainType.setUpdateDate(ts);
        testGrainType.setCreateDate(ts);

        grainTypeEntityID = me.addGrainTypeEntity(testGrainType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero grain type ID, got " + grainTypeEntityID, grainTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteGrainTypeEntityById(grainTypeEntityID);
        assertNull(me.getGrainTypeEntity(grainTypeEntityID));

    }

}