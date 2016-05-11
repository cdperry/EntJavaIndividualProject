package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeEntity;
import com.cdperry.brewday.entity.UomTypeEntity;
import org.junit.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class RecipeDaoTest {

    private RecipeDao me;
    private RecipeEntity testEntity;
    private UomTypeDao uomTypeDao;
    private UomTypeEntity uomTypeEntity;
    private List<RecipeEntity> entities;

    @Before
    public void setup() {

        me = new RecipeDao();
        uomTypeDao = new UomTypeDao();
        uomTypeEntity = uomTypeDao.getUomTypeEntity(1);

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        entities = new ArrayList<RecipeEntity>();

        for (int iteration = 1; iteration < 4; iteration++) {

            testEntity = new RecipeEntity();
            testEntity.setRecipeName("Recipe " + iteration);
            testEntity.setBrewerName("Brewer " + iteration);
            //testRecipe.setRecipeTypeId(1);
            testEntity.setBatchSize(new BigDecimal("1.0"));
            //testRecipe.setBatchSizeUomId(1);
            //testRecipe.setEquipmentProfileId(1);
            testEntity.setUpdateDate(ts);
            testEntity.setCreateDate(ts);

            id = me.addRecipeEntity(testEntity);
            entities.add(testEntity);
        }

    }

    @After
    public void teardown() {

        // delete the ComponentEntity entities which will cascade and delete the ComponentGrainEntity entities
        for (RecipeEntity thisEntity : entities) {
            me.deleteRecipeEntity(thisEntity);
        }

        // clean up
        me = null;
        uomTypeDao = null;
        uomTypeEntity = null;
        testEntity = null;
        entities = null;

    }

    @Test
    public void testGetAllRecipes() throws Exception {

        List<RecipeEntity> results;
        results = me.getAllRecipes();
        assertTrue("Expected non-zero ArrayList size, got zero.", results.size() > 0);

    }

    @Test
    public void testGetRecipeEntity() throws Exception {

        int id = entities.get(0).getRecipeId();

        // confirm that the entity can be retrieved from the database
        testEntity = null;
        testEntity = me.getRecipeEntity(id);
        assertNotNull("Expected non-null entity, got null", testEntity);

    }

    @Test
    public void testUpdateRecipeEntity() throws Exception {

        int id = entities.get(0).getRecipeId();

        // retrieve the test ComponentGrainEntity from the database and change its name
        testEntity = null;
        testEntity = me.getRecipeEntity(id);
        testEntity.setRecipeName("New Name");
        me.updateRecipeEntity(testEntity);

        // retrieve the updated ComponentGrainEntity and test that the update took place
        testEntity = null;
        testEntity = me.getRecipeEntity(id);

        assertEquals("Expected New Name, got " + testEntity.getRecipeName(),
                "New Name", testEntity.getRecipeName());
    }

    @Test
    public void testDeleteRecipeEntity() throws Exception {

        int id = entities.get(0).getRecipeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteRecipeEntity(me.getRecipeEntity(id));
        assertNull("Expected a null entity, got a real entity", me.getRecipeEntity(id));

        // remove the deleted entity from the ArrayList so that Hibernate doesn't get sad
        // during the teardown() method
        entities.remove(0);

    }

    @Test
    public void testAddRecipeEntity() throws Exception {

        int id;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        testEntity = new RecipeEntity();
        testEntity.setRecipeName("zRecipe for Add test");
        testEntity.setUpdateDate(ts);
        testEntity.setCreateDate(ts);

        id = me.addRecipeEntity(testEntity);
        entities.add(testEntity);

        // confirm that a non-zero ID was returned (indicator of success)
        assertTrue("Expected a non-zero entity ID, got " + id, id > 0);

    }    

    @Test
    public void testDeleteGrainTypeEntityById() throws Exception {

        int id = entities.get(0).getRecipeId();

        // delete the entity and verify that it is no longer in the database
        me.deleteRecipeEntityById(id);
        assertNull("Expected a null entity, got something instead.", me.getRecipeEntity(id));

        entities.remove(0);

    }

    
}