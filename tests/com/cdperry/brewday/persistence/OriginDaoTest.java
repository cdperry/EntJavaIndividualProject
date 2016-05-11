package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.OriginEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class OriginDaoTest {

    private OriginDao me;
    private OriginEntity testEntity;
    private List<OriginEntity> entities;

    @Before
    public void setup() {

        me = new OriginDao();

        int originEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<OriginEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new OriginEntity();
            testEntity.setName("zOrigin Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            originEntityID = me.addOriginEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentGrainEntity entities
        for (OriginEntity thisEntity : entities) {
            me.deleteOriginEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllOrigins() throws Exception {

        List<OriginEntity> results;
        results = me.getAllOrigins();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetOriginEntity() throws Exception {

        int id = entities.get(0).getOriginId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getOriginEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateOriginEntity() throws Exception {

        int id = entities.get(0).getOriginId();

        // retrieve the test ComponentGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getOriginEntity(id);
        testEntity.setName("New Name");
        me.updateOriginEntity(testEntity);

        // retrieve the updated ComponentGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getOriginEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteOriginEntity() throws Exception {

        int id = entities.get(0).getOriginId();

        // delete the entity and verify that it is no longer in the database
        me.deleteOriginEntity(me.getOriginEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getOriginEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddOriginEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new OriginEntity();
        testEntity.setName("zOrigin Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addOriginEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}