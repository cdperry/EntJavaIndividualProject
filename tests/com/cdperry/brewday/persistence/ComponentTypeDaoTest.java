package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class ComponentTypeDaoTest {

    private ComponentTypeDao me;
    private ComponentTypeEntity testEntity;
    private List<ComponentTypeEntity> entities;

    @Before
    public void setup() {

        me = new ComponentTypeDao();

        int componentTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<ComponentTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new ComponentTypeEntity();
            testEntity.setName("zComponent Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            componentTypeEntityID = me.addComponentTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentGrainEntity entities
        for (ComponentTypeEntity thisEntity : entities) {
            me.deleteComponentTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllComponentTypes() throws Exception {

        List<ComponentTypeEntity> results;
        results = me.getAllComponentTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetComponentTypeEntity() throws Exception {

        int id = entities.get(0).getComponentTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getComponentTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateComponentTypeEntity() throws Exception {

        int id = entities.get(0).getComponentTypeId();

        // retrieve the test ComponentGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getComponentTypeEntity(id);
        testEntity.setName("New Name");
        me.updateComponentTypeEntity(testEntity);

        // retrieve the updated ComponentGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getComponentTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteComponentTypeEntity() throws Exception {

        int id = entities.get(0).getComponentTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteComponentTypeEntity(me.getComponentTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getComponentTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddComponentTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new ComponentTypeEntity();
        testEntity.setName("zComponent Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addComponentTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}