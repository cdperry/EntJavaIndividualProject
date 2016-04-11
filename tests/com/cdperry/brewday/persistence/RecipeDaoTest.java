package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class RecipeDaoTest {

    @Test
    public void testGetAllRecipes() throws Exception {

        RecipeDao me = new RecipeDao();
        RecipeEntity testRecipe;
        List<RecipeEntity> recipes;
        int recipeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        // create a test grain and add them to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 2");
        testRecipe.setBrewerName("Brewer 2");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        recipes = me.getAllRecipes();
        assertTrue(recipes.size() > 0);

        // clean up
        for (RecipeEntity component : recipes) {
            me.deleteRecipeEntity(component);
        }

    }

    @Test
    public void testGetRecipeEntity() throws Exception {

        RecipeDao me = new RecipeDao();
        RecipeEntity testRecipe = new RecipeEntity();
        int recipeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero recipe ID, got " + recipeEntityID, recipeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testRecipe = me.getRecipeEntity(recipeEntityID);
        assertNotNull(testRecipe);

        // clean up
        me.deleteRecipeEntity(testRecipe);

    }

    @Test
    public void testUpdateRecipeEntity() throws Exception {

        RecipeDao me = new RecipeDao();
        RecipeEntity testRecipe = new RecipeEntity();
        int recipeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        // retrieve the test component from the database and change its name
        testRecipe = me.getRecipeEntity(recipeEntityID);
        testRecipe.setRecipeName("New Name");
        me.updateRecipeEntity(testRecipe);

        // retrieve the updated employee and test that the update took place
        testRecipe = me.getRecipeEntity(recipeEntityID);

        assertEquals("Expected New Name, got " + testRecipe.getRecipeName(),
                "New Name", testRecipe.getRecipeName());

        // clean up
        me.deleteRecipeEntity(testRecipe);

    }

    @Test
    public void testDeleteRecipeEntity() throws Exception {

        RecipeDao me = new RecipeDao();
        RecipeEntity testRecipe = new RecipeEntity();
        int recipeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero recipe ID, got " + recipeEntityID, recipeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteRecipeEntity(me.getRecipeEntity(recipeEntityID));
        assertNull(me.getRecipeEntity(recipeEntityID));

    }

    @Test
    public void testAddRecipeEntity() throws Exception {

        RecipeDao me = new RecipeDao();
        RecipeEntity testRecipe = new RecipeEntity();
        int recipeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero recipe ID, got " + recipeEntityID, recipeEntityID > 0);

        // clean up
        testRecipe = me.getRecipeEntity(recipeEntityID);
        me.deleteRecipeEntity(testRecipe);

    }
}