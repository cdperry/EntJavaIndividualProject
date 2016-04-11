package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ProfileEquipmentEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class ProfileEquipmentDaoTest {

    @Test
    public void testGetAllProfileEquipments() throws Exception {

        ProfileEquipmentDao me = new ProfileEquipmentDao();
        ProfileEquipmentEntity testProfileEquipment;
        List<ProfileEquipmentEntity> profileEquipments;
        int profileEquipmentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testProfileEquipment = new ProfileEquipmentEntity();
        testProfileEquipment.setName("Equipment Profile 1");
        testProfileEquipment.setEfficiency(new BigDecimal("1.0"));
        testProfileEquipment.setFermBatchVol(new BigDecimal("1.0"));
        testProfileEquipment.setBatchVolUomId(1);
        testProfileEquipment.setMashTunVol(new BigDecimal("1.0"));
        testProfileEquipment.setMashTunUomId(1);
        testProfileEquipment.setBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilVolUomId(1);
        testProfileEquipment.setBoilTime(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTimeUomId(1);
        testProfileEquipment.setBoilOffPerHrVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilOffPerHrUomId(1);
        testProfileEquipment.setBoilShrinkage(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOff(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOffUomId(1);
        testProfileEquipment.setBoilPostBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilPostBoilVolUomId(1);
        testProfileEquipment.setFermLoss(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossUomId(1);
        testProfileEquipment.setFermTopUp(new BigDecimal("1.0"));
        testProfileEquipment.setFermTopUpUomId(1);
        testProfileEquipment.setFermLossTrubChill(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossTrubChillUomId(1);
        testProfileEquipment.setBottlingVol(new BigDecimal("1.0"));
        testProfileEquipment.setBottlingVolUomId(1);
        testProfileEquipment.setNotes("This is a note.");
        testProfileEquipment.setUpdateDate(ts);
        testProfileEquipment.setCreateDate(ts);

        profileEquipmentEntityID = me.addProfileEquipmentEntity(testProfileEquipment);

        // create a test grain and add them to the database
        testProfileEquipment = new ProfileEquipmentEntity();
        testProfileEquipment.setName("Equipment Profile 2");
        testProfileEquipment.setEfficiency(new BigDecimal("1.0"));
        testProfileEquipment.setFermBatchVol(new BigDecimal("1.0"));
        testProfileEquipment.setBatchVolUomId(1);
        testProfileEquipment.setMashTunVol(new BigDecimal("1.0"));
        testProfileEquipment.setMashTunUomId(1);
        testProfileEquipment.setBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilVolUomId(1);
        testProfileEquipment.setBoilTime(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTimeUomId(1);
        testProfileEquipment.setBoilOffPerHrVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilOffPerHrUomId(1);
        testProfileEquipment.setBoilShrinkage(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOff(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOffUomId(1);
        testProfileEquipment.setBoilPostBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilPostBoilVolUomId(1);
        testProfileEquipment.setFermLoss(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossUomId(1);
        testProfileEquipment.setFermTopUp(new BigDecimal("1.0"));
        testProfileEquipment.setFermTopUpUomId(1);
        testProfileEquipment.setFermLossTrubChill(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossTrubChillUomId(1);
        testProfileEquipment.setBottlingVol(new BigDecimal("1.0"));
        testProfileEquipment.setBottlingVolUomId(1);
        testProfileEquipment.setNotes("This is a note.");
        testProfileEquipment.setUpdateDate(ts);
        testProfileEquipment.setCreateDate(ts);

        profileEquipmentEntityID = me.addProfileEquipmentEntity(testProfileEquipment);

        profileEquipments = me.getAllProfileEquipment();
        assertTrue(profileEquipments.size() > 0);

        // clean up
        for (ProfileEquipmentEntity component : profileEquipments) {
            me.deleteProfileEquipmentEntity(component);
        }

    }

    @Test
    public void testGetProfileEquipmentEntity() throws Exception {

        ProfileEquipmentDao me = new ProfileEquipmentDao();
        ProfileEquipmentEntity testProfileEquipment = new ProfileEquipmentEntity();
        int profileEquipmentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testProfileEquipment = new ProfileEquipmentEntity();
        testProfileEquipment.setName("Equipment Profile 1");
        testProfileEquipment.setEfficiency(new BigDecimal("1.0"));
        testProfileEquipment.setFermBatchVol(new BigDecimal("1.0"));
        testProfileEquipment.setBatchVolUomId(1);
        testProfileEquipment.setMashTunVol(new BigDecimal("1.0"));
        testProfileEquipment.setMashTunUomId(1);
        testProfileEquipment.setBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilVolUomId(1);
        testProfileEquipment.setBoilTime(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTimeUomId(1);
        testProfileEquipment.setBoilOffPerHrVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilOffPerHrUomId(1);
        testProfileEquipment.setBoilShrinkage(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOff(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOffUomId(1);
        testProfileEquipment.setBoilPostBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilPostBoilVolUomId(1);
        testProfileEquipment.setFermLoss(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossUomId(1);
        testProfileEquipment.setFermTopUp(new BigDecimal("1.0"));
        testProfileEquipment.setFermTopUpUomId(1);
        testProfileEquipment.setFermLossTrubChill(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossTrubChillUomId(1);
        testProfileEquipment.setBottlingVol(new BigDecimal("1.0"));
        testProfileEquipment.setBottlingVolUomId(1);
        testProfileEquipment.setNotes("This is a note.");
        testProfileEquipment.setUpdateDate(ts);
        testProfileEquipment.setCreateDate(ts);

        profileEquipmentEntityID = me.addProfileEquipmentEntity(testProfileEquipment);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero equipment profile ID, got " + profileEquipmentEntityID, profileEquipmentEntityID > 0);

        // confirm that the component can be retrieved from the database
        testProfileEquipment = me.getProfileEquipmentEntity(profileEquipmentEntityID);
        assertNotNull(testProfileEquipment);

        // clean up
        me.deleteProfileEquipmentEntity(testProfileEquipment);

    }

    @Test
    public void testUpdateProfileEquipmentEntity() throws Exception {

        ProfileEquipmentDao me = new ProfileEquipmentDao();
        ProfileEquipmentEntity testProfileEquipment = new ProfileEquipmentEntity();
        int profileEquipmentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testProfileEquipment = new ProfileEquipmentEntity();
        testProfileEquipment.setName("Equipment Profile 1");
        testProfileEquipment.setEfficiency(new BigDecimal("1.0"));
        testProfileEquipment.setFermBatchVol(new BigDecimal("1.0"));
        testProfileEquipment.setBatchVolUomId(1);
        testProfileEquipment.setMashTunVol(new BigDecimal("1.0"));
        testProfileEquipment.setMashTunUomId(1);
        testProfileEquipment.setBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilVolUomId(1);
        testProfileEquipment.setBoilTime(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTimeUomId(1);
        testProfileEquipment.setBoilOffPerHrVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilOffPerHrUomId(1);
        testProfileEquipment.setBoilShrinkage(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOff(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOffUomId(1);
        testProfileEquipment.setBoilPostBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilPostBoilVolUomId(1);
        testProfileEquipment.setFermLoss(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossUomId(1);
        testProfileEquipment.setFermTopUp(new BigDecimal("1.0"));
        testProfileEquipment.setFermTopUpUomId(1);
        testProfileEquipment.setFermLossTrubChill(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossTrubChillUomId(1);
        testProfileEquipment.setBottlingVol(new BigDecimal("1.0"));
        testProfileEquipment.setBottlingVolUomId(1);
        testProfileEquipment.setNotes("This is a note.");
        testProfileEquipment.setUpdateDate(ts);
        testProfileEquipment.setCreateDate(ts);

        profileEquipmentEntityID = me.addProfileEquipmentEntity(testProfileEquipment);

        // retrieve the test component from the database and change its name
        testProfileEquipment = me.getProfileEquipmentEntity(profileEquipmentEntityID);
        testProfileEquipment.setName("New Name");
        me.updateProfileEquipmentEntity(testProfileEquipment);

        // retrieve the updated employee and test that the update took place
        testProfileEquipment = me.getProfileEquipmentEntity(profileEquipmentEntityID);

        assertEquals("Expected New Name, got " + testProfileEquipment.getName(),
                "New Name", testProfileEquipment.getName());

        // clean up
        me.deleteProfileEquipmentEntity(testProfileEquipment);

    }

    @Test
    public void testDeleteProfileEquipmentEntity() throws Exception {

        ProfileEquipmentDao me = new ProfileEquipmentDao();
        ProfileEquipmentEntity testProfileEquipment = new ProfileEquipmentEntity();
        int profileEquipmentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testProfileEquipment = new ProfileEquipmentEntity();
        testProfileEquipment.setName("Equipment Profile 1");
        testProfileEquipment.setEfficiency(new BigDecimal("1.0"));
        testProfileEquipment.setFermBatchVol(new BigDecimal("1.0"));
        testProfileEquipment.setBatchVolUomId(1);
        testProfileEquipment.setMashTunVol(new BigDecimal("1.0"));
        testProfileEquipment.setMashTunUomId(1);
        testProfileEquipment.setBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilVolUomId(1);
        testProfileEquipment.setBoilTime(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTimeUomId(1);
        testProfileEquipment.setBoilOffPerHrVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilOffPerHrUomId(1);
        testProfileEquipment.setBoilShrinkage(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOff(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOffUomId(1);
        testProfileEquipment.setBoilPostBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilPostBoilVolUomId(1);
        testProfileEquipment.setFermLoss(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossUomId(1);
        testProfileEquipment.setFermTopUp(new BigDecimal("1.0"));
        testProfileEquipment.setFermTopUpUomId(1);
        testProfileEquipment.setFermLossTrubChill(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossTrubChillUomId(1);
        testProfileEquipment.setBottlingVol(new BigDecimal("1.0"));
        testProfileEquipment.setBottlingVolUomId(1);
        testProfileEquipment.setNotes("This is a note.");
        testProfileEquipment.setUpdateDate(ts);
        testProfileEquipment.setCreateDate(ts);

        profileEquipmentEntityID = me.addProfileEquipmentEntity(testProfileEquipment);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero equipment profile ID, got " + profileEquipmentEntityID, profileEquipmentEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteProfileEquipmentEntity(me.getProfileEquipmentEntity(profileEquipmentEntityID));
        assertNull(me.getProfileEquipmentEntity(profileEquipmentEntityID));

    }

    @Test
    public void testAddProfileEquipmentEntity() throws Exception {

        ProfileEquipmentDao me = new ProfileEquipmentDao();
        ProfileEquipmentEntity testProfileEquipment = new ProfileEquipmentEntity();
        int profileEquipmentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testProfileEquipment = new ProfileEquipmentEntity();
        testProfileEquipment.setName("Equipment Profile 1");
        testProfileEquipment.setEfficiency(new BigDecimal("1.0"));
        testProfileEquipment.setFermBatchVol(new BigDecimal("1.0"));
        testProfileEquipment.setBatchVolUomId(1);
        testProfileEquipment.setMashTunVol(new BigDecimal("1.0"));
        testProfileEquipment.setMashTunUomId(1);
        testProfileEquipment.setBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilVolUomId(1);
        testProfileEquipment.setBoilTime(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTimeUomId(1);
        testProfileEquipment.setBoilOffPerHrVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilOffPerHrUomId(1);
        testProfileEquipment.setBoilShrinkage(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOff(new BigDecimal("1.0"));
        testProfileEquipment.setBoilTotalBoilOffUomId(1);
        testProfileEquipment.setBoilPostBoilVol(new BigDecimal("1.0"));
        testProfileEquipment.setBoilPostBoilVolUomId(1);
        testProfileEquipment.setFermLoss(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossUomId(1);
        testProfileEquipment.setFermTopUp(new BigDecimal("1.0"));
        testProfileEquipment.setFermTopUpUomId(1);
        testProfileEquipment.setFermLossTrubChill(new BigDecimal("1.0"));
        testProfileEquipment.setFermLossTrubChillUomId(1);
        testProfileEquipment.setBottlingVol(new BigDecimal("1.0"));
        testProfileEquipment.setBottlingVolUomId(1);
        testProfileEquipment.setNotes("This is a note.");
        testProfileEquipment.setUpdateDate(ts);
        testProfileEquipment.setCreateDate(ts);

        profileEquipmentEntityID = me.addProfileEquipmentEntity(testProfileEquipment);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero equipment profile ID, got " + profileEquipmentEntityID, profileEquipmentEntityID > 0);

        // clean up
        testProfileEquipment = me.getProfileEquipmentEntity(profileEquipmentEntityID);
        me.deleteProfileEquipmentEntity(testProfileEquipment);

    }
}