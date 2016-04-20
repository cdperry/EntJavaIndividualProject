package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.OriginEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class OriginDaoTest {

    @Test
    public void testGetAllOrigins() throws Exception {

        OriginDao me = new OriginDao();
        OriginEntity testOrigin;
        List<OriginEntity> origins;
        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test origin and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin 1");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        // create a test origin and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin 2");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        origins = me.getAllOrigins();
        assertTrue(origins.size() > 0);

        // clean up
        for (OriginEntity component : origins) {
            me.deleteOriginEntity(component);
        }

    }

    @Test
    public void testGetOriginEntity() throws Exception {

        OriginDao me = new OriginDao();
        OriginEntity testOrigin = new OriginEntity();
        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test origin and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin 1");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero origin ID, got " + originEntityID, originEntityID > 0);

        // confirm that the component can be retrieved from the database
        testOrigin = me.getOriginEntity(originEntityID);
        assertNotNull(testOrigin);

        // clean up
        me.deleteOriginEntity(testOrigin);

    }

    @Test
    public void testUpdateOriginEntity() throws Exception {

        OriginDao me = new OriginDao();
        OriginEntity testOrigin = new OriginEntity();
        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin 1");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        // retrieve the test component from the database and change its name
        testOrigin = me.getOriginEntity(originEntityID);
        testOrigin.setName("New Name");
        me.updateOriginEntity(testOrigin);

        // retrieve the updated employee and test that the update took place
        testOrigin = me.getOriginEntity(originEntityID);

        assertEquals("Expected New Name, got " + testOrigin.getName(),
                "New Name", testOrigin.getName());

        // clean up
        me.deleteOriginEntity(testOrigin);

    }

    @Test
    public void testDeleteOriginEntity() throws Exception {

        OriginDao me = new OriginDao();
        OriginEntity testOrigin = new OriginEntity();
        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin 1");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero origin ID, got " + originEntityID, originEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteOriginEntity(me.getOriginEntity(originEntityID));
        assertNull(me.getOriginEntity(originEntityID));

    }

    @Test
    public void testAddOriginEntity() throws Exception {

        OriginDao me = new OriginDao();
        OriginEntity testOrigin = new OriginEntity();
        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin 1");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero origin ID, got " + originEntityID, originEntityID > 0);

        // clean up
        testOrigin = me.getOriginEntity(originEntityID);
        me.deleteOriginEntity(testOrigin);

    }

    @Test
    public void testDeleteOriginEntityById() throws Exception {

        OriginDao me = new OriginDao();
        OriginEntity testOrigin = new OriginEntity();
        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testOrigin = new OriginEntity();
        testOrigin.setName("Origin Type 1");
        testOrigin.setUpdateDate(ts);
        testOrigin.setCreateDate(ts);

        originEntityID = me.addOriginEntity(testOrigin);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero origin type ID, got " + originEntityID, originEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteOriginEntityById(originEntityID);
        assertNull(me.getOriginEntity(originEntityID));

    }
    
}