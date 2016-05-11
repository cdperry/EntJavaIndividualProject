package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastFormEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class YeastFormDaoTest {

    private YeastFormDao me;
    private YeastFormEntity testEntity;
    private List<YeastFormEntity> entities;

    @Before
    public void setup() {

        me = new YeastFormDao();

        int yeastFormEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<YeastFormEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new YeastFormEntity();
            testEntity.setName("zComponent Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            yeastFormEntityID = me.addYeastFormEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentGrainEntity entities
        for (YeastFormEntity thisEntity : entities) {
            me.deleteYeastFormEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllYeastForms() throws Exception {

        List<YeastFormEntity> results;
        results = me.getAllYeastForms();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetYeastFormEntity() throws Exception {

        int id = entities.get(0).getYeastFormId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getYeastFormEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateYeastFormEntity() throws Exception {

        int id = entities.get(0).getYeastFormId();

        // retrieve the test ComponentGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getYeastFormEntity(id);
        testEntity.setName("New Name");
        me.updateYeastFormEntity(testEntity);

        // retrieve the updated ComponentGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getYeastFormEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteYeastFormEntity() throws Exception {

        int id = entities.get(0).getYeastFormId();

        // delete the entity and verify that it is no longer in the database
        me.deleteYeastFormEntity(me.getYeastFormEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getYeastFormEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddYeastFormEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new YeastFormEntity();
        testEntity.setName("zComponent Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addYeastFormEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}