package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ProfileEquipmentEntity;
import com.cdperry.brewday.entity.UomTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class ProfileEquipmentDaoTest {

    private ProfileEquipmentDao me;
    private ProfileEquipmentEntity testEntity;
    private UomTypeDao uomTypeDao;
    private UomTypeEntity uomTypeEntity;
    private List<ProfileEquipmentEntity> entities;

    @Before
    public void setup() {

        me = new ProfileEquipmentDao();
        uomTypeDao = new UomTypeDao();
        uomTypeEntity = uomTypeDao.getUomTypeEntity(1);

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<ProfileEquipmentEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {

            testEntity = new ProfileEquipmentEntity();
            testEntity.setName("Equipment Profile " + iteration);
            testEntity.setEfficiency(new BigDecimal("1.0"));
            testEntity.setFermBatchVol(new BigDecimal("1.0"));
            testEntity.setBatchVolUomId(1);
            testEntity.setMashTunVol(new BigDecimal("1.0"));
            testEntity.setMashTunUomId(1);
            testEntity.setBoilVol(new BigDecimal("1.0"));
            testEntity.setBoilVolUomId(1);
            testEntity.setBoilTime(new BigDecimal("1.0"));
            testEntity.setBoilTimeUomId(1);
            testEntity.setBoilOffPerHrVol(new BigDecimal("1.0"));
            testEntity.setBoilOffPerHrUomId(1);
            testEntity.setBoilShrinkage(new BigDecimal("1.0"));
            testEntity.setBoilTotalBoilOff(new BigDecimal("1.0"));
            testEntity.setBoilTotalBoilOffUomId(1);
            testEntity.setBoilPostBoilVol(new BigDecimal("1.0"));
            testEntity.setBoilPostBoilVolUomId(1);
            testEntity.setFermLoss(new BigDecimal("1.0"));
            testEntity.setFermLossUomId(1);
            testEntity.setFermTopUp(new BigDecimal("1.0"));
            testEntity.setFermTopUpUomId(1);
            testEntity.setFermLossTrubChill(new BigDecimal("1.0"));
            testEntity.setFermLossTrubChillUomId(1);
            testEntity.setBottlingVol(new BigDecimal("1.0"));
            testEntity.setBottlingVolUomId(1);
            testEntity.setNotes("This is a note.");
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            id = me.addProfileEquipmentEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentGrainEntity entities
        for (ProfileEquipmentEntity thisEntity : entities) {
            me.deleteProfileEquipmentEntity(thisEntity);
        }

        // clean up
        me = null;
        uomTypeDao = null;
        uomTypeEntity = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllProfileEquipments() throws Exception {

        List<ProfileEquipmentEntity> results;
        results = me.getAllProfileEquipment();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetProfileEquipmentEntity() throws Exception {

        int id = entities.get(0).getProfileEquipmentId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getProfileEquipmentEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateProfileEquipmentEntity() throws Exception {

        int id = entities.get(0).getProfileEquipmentId();

        // retrieve the test ComponentGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getProfileEquipmentEntity(id);
        testEntity.setName("New Name");
        me.updateProfileEquipmentEntity(testEntity);

        // retrieve the updated ComponentGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getProfileEquipmentEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());
    }

    @Test
    public void testDeleteProfileEquipmentEntity() throws Exception {

        int id = entities.get(0).getProfileEquipmentId();

        // delete the entity and verify that it is no longer in the database
        me.deleteProfileEquipmentEntity(me.getProfileEquipmentEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getProfileEquipmentEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddProfileEquipmentEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new ProfileEquipmentEntity();
        testEntity.setName("zProfile for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addProfileEquipmentEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }
}