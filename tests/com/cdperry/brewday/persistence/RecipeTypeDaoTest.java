package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class RecipeTypeDaoTest {

    private RecipeTypeDao me;
    private RecipeTypeEntity testEntity;
    private List<RecipeTypeEntity> entities;

    @Before
    public void setup() {

        me = new RecipeTypeDao();

        int recipeTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<RecipeTypeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {
            testEntity = new RecipeTypeEntity();
            testEntity.setName("zRecipe Type " + iteration);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            recipeTypeEntityID = me.addRecipeTypeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the RecipeEntity entities which will cascade and delete the RecipeGrainEntity entities
        for (RecipeTypeEntity thisEntity : entities) {
            me.deleteRecipeTypeEntity(thisEntity);
        }

        // clean up
        me = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllRecipeTypes() throws Exception {

        List<RecipeTypeEntity> results;
        results = me.getAllRecipeTypes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetRecipeTypeEntity() throws Exception {

        int id = entities.get(0).getRecipeTypeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getRecipeTypeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateRecipeTypeEntity() throws Exception {

        int id = entities.get(0).getRecipeTypeId();

        // retrieve the test RecipeGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getRecipeTypeEntity(id);
        testEntity.setName("New Name");
        me.updateRecipeTypeEntity(testEntity);

        // retrieve the updated RecipeGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getRecipeTypeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getName(),
                "New Name", testEntity.getName());

    }

    @Test
    public void testDeleteRecipeTypeEntity() throws Exception {

        int id = entities.get(0).getRecipeTypeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteRecipeTypeEntity(me.getRecipeTypeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getRecipeTypeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddRecipeTypeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new RecipeTypeEntity();
        testEntity.setName("zRecipe Type for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addRecipeTypeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }

}