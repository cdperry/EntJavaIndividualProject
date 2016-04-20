package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.UseTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class UseTypeDaoTest {

    @Test
    public void testGetAllUseTypes() throws Exception {

        UseTypeDao me = new UseTypeDao();
        UseTypeEntity testUseType;
        List<UseTypeEntity> useTypes;
        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test use and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 1");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        // create a test use and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 2");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        useTypes = me.getAllUseTypes();
        assertTrue(useTypes.size() > 0);

        // clean up
        for (UseTypeEntity component : useTypes) {
            me.deleteUseTypeEntity(component);
        }

    }

    @Test
    public void testGetUseTypeEntity() throws Exception {

        UseTypeDao me = new UseTypeDao();
        UseTypeEntity testUseType = new UseTypeEntity();
        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test use and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 1");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero use type ID, got " + useTypeEntityID, useTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testUseType = me.getUseTypeEntity(useTypeEntityID);
        assertNotNull(testUseType);

        // clean up
        me.deleteUseTypeEntity(testUseType);

    }

    @Test
    public void testUpdateUseTypeEntity() throws Exception {

        UseTypeDao me = new UseTypeDao();
        UseTypeEntity testUseType = new UseTypeEntity();
        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 1");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        // retrieve the test component from the database and change its name
        testUseType = me.getUseTypeEntity(useTypeEntityID);
        testUseType.setName("New Name");
        me.updateUseTypeEntity(testUseType);

        // retrieve the updated employee and test that the update took place
        testUseType = me.getUseTypeEntity(useTypeEntityID);

        assertEquals("Expected New Name, got " + testUseType.getName(),
                "New Name", testUseType.getName());

        // clean up
        me.deleteUseTypeEntity(testUseType);

    }

    @Test
    public void testDeleteUseTypeEntity() throws Exception {

        UseTypeDao me = new UseTypeDao();
        UseTypeEntity testUseType = new UseTypeEntity();
        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 1");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero use type ID, got " + useTypeEntityID, useTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteUseTypeEntity(me.getUseTypeEntity(useTypeEntityID));
        assertNull(me.getUseTypeEntity(useTypeEntityID));

    }

    @Test
    public void testAddUseTypeEntity() throws Exception {

        UseTypeDao me = new UseTypeDao();
        UseTypeEntity testUseType = new UseTypeEntity();
        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 1");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero use type ID, got " + useTypeEntityID, useTypeEntityID > 0);

        // clean up
        testUseType = me.getUseTypeEntity(useTypeEntityID);
        me.deleteUseTypeEntity(testUseType);

    }

    @Test
    public void testDeleteUseTypeEntityById() throws Exception {

        UseTypeDao me = new UseTypeDao();
        UseTypeEntity testUseType = new UseTypeEntity();
        int useTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testUseType = new UseTypeEntity();
        testUseType.setName("Use Type 1");
        testUseType.setUpdateDate(ts);
        testUseType.setCreateDate(ts);

        useTypeEntityID = me.addUseTypeEntity(testUseType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero use type ID, got " + useTypeEntityID, useTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteUseTypeEntityById(useTypeEntityID);
        assertNull(me.getUseTypeEntity(useTypeEntityID));

    }
    
}