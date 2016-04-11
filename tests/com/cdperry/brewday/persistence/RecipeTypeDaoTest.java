package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeTypeEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class RecipeTypeDaoTest {

    @Test
    public void testGetAllRecipeTypes() throws Exception {

        RecipeTypeDao me = new RecipeTypeDao();
        RecipeTypeEntity testRecipeType;
        List<RecipeTypeEntity> recipeTypes;
        int recipeTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testRecipeType = new RecipeTypeEntity();
        testRecipeType.setName("Recipe Type 1");

        testRecipeType.setUpdateDate(ts);
        testRecipeType.setCreateDate(ts);

        recipeTypeEntityID = me.addRecipeTypeEntity(testRecipeType);

        // create a test grain and add them to the database
        testRecipeType = new RecipeTypeEntity();
        testRecipeType.setName("Recipe Type 2");
        testRecipeType.setUpdateDate(ts);
        testRecipeType.setCreateDate(ts);

        recipeTypeEntityID = me.addRecipeTypeEntity(testRecipeType);

        recipeTypes = me.getAllRecipeTypes();
        assertTrue(recipeTypes.size() > 0);

        // clean up
        for (RecipeTypeEntity component : recipeTypes) {
            me.deleteRecipeTypeEntity(component);
        }

    }

    @Test
    public void testGetRecipeTypeEntity() throws Exception {

        RecipeTypeDao me = new RecipeTypeDao();
        RecipeTypeEntity testRecipeType = new RecipeTypeEntity();
        int recipeTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testRecipeType = new RecipeTypeEntity();
        testRecipeType.setName("Recipe Type 1");
        testRecipeType.setUpdateDate(ts);
        testRecipeType.setCreateDate(ts);

        recipeTypeEntityID = me.addRecipeTypeEntity(testRecipeType);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero recipe type ID, got " + recipeTypeEntityID, recipeTypeEntityID > 0);

        // confirm that the component can be retrieved from the database
        testRecipeType = me.getRecipeTypeEntity(recipeTypeEntityID);
        assertNotNull(testRecipeType);

        // clean up
        me.deleteRecipeTypeEntity(testRecipeType);

    }

    @Test
    public void testUpdateRecipeTypeEntity() throws Exception {

        RecipeTypeDao me = new RecipeTypeDao();
        RecipeTypeEntity testRecipeType = new RecipeTypeEntity();
        int recipeTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipeType = new RecipeTypeEntity();
        testRecipeType.setName("Recipe Type 1");
        testRecipeType.setUpdateDate(ts);
        testRecipeType.setCreateDate(ts);

        recipeTypeEntityID = me.addRecipeTypeEntity(testRecipeType);

        // retrieve the test component from the database and change its name
        testRecipeType = me.getRecipeTypeEntity(recipeTypeEntityID);
        testRecipeType.setName("New Name");
        me.updateRecipeTypeEntity(testRecipeType);

        // retrieve the updated employee and test that the update took place
        testRecipeType = me.getRecipeTypeEntity(recipeTypeEntityID);

        assertEquals("Expected New Name, got " + testRecipeType.getName(),
                "New Name", testRecipeType.getName());

        // clean up
        me.deleteRecipeTypeEntity(testRecipeType);

    }

    @Test
    public void testDeleteRecipeTypeEntity() throws Exception {

        RecipeTypeDao me = new RecipeTypeDao();
        RecipeTypeEntity testRecipeType = new RecipeTypeEntity();
        int recipeTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipeType = new RecipeTypeEntity();
        testRecipeType.setName("Recipe Type 1");
        testRecipeType.setUpdateDate(ts);
        testRecipeType.setCreateDate(ts);

        recipeTypeEntityID = me.addRecipeTypeEntity(testRecipeType);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero recipe type ID, got " + recipeTypeEntityID, recipeTypeEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteRecipeTypeEntity(me.getRecipeTypeEntity(recipeTypeEntityID));
        assertNull(me.getRecipeTypeEntity(recipeTypeEntityID));

    }

    @Test
    public void testAddRecipeTypeEntity() throws Exception {

        RecipeTypeDao me = new RecipeTypeDao();
        RecipeTypeEntity testRecipeType = new RecipeTypeEntity();
        int recipeTypeEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipeType = new RecipeTypeEntity();
        testRecipeType.setName("Recipe Type 1");
        testRecipeType.setUpdateDate(ts);
        testRecipeType.setCreateDate(ts);

        recipeTypeEntityID = me.addRecipeTypeEntity(testRecipeType);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero recipe type ID, got " + recipeTypeEntityID, recipeTypeEntityID > 0);

        // clean up
        testRecipeType = me.getRecipeTypeEntity(recipeTypeEntityID);
        me.deleteRecipeTypeEntity(testRecipeType);

    }
}