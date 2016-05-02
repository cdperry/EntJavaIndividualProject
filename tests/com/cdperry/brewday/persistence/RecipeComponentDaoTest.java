package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentEntity;
import com.cdperry.brewday.entity.RecipeComponentEntity;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/10/16.
 */
public class RecipeComponentDaoTest {

    @Test
    public void testGetAllRecipeComponents() throws Exception {

        RecipeComponentDao me = new RecipeComponentDao();
        RecipeComponentEntity testRecipeComponent;
        List<RecipeComponentEntity> recipeComponents;
        int recipeComponentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testRecipeComponent = new RecipeComponentEntity();
        testRecipeComponent.setRecipeId(1);
        testRecipeComponent.setComponent(new ComponentEntity());
        testRecipeComponent.setAmount(new BigDecimal("1.0"));
        testRecipeComponent.setAmountUomId(1);
        testRecipeComponent.setUpdateDate(ts);
        testRecipeComponent.setCreateDate(ts);

        recipeComponentEntityID = me.addRecipeComponentEntity(testRecipeComponent);

        // create a test grain and add them to the database
        testRecipeComponent = new RecipeComponentEntity();
        testRecipeComponent.setRecipeId(2);
        testRecipeComponent.setComponent(new ComponentEntity());
        testRecipeComponent.setAmount(new BigDecimal("2.0"));
        testRecipeComponent.setAmountUomId(2);
        testRecipeComponent.setUpdateDate(ts);
        testRecipeComponent.setCreateDate(ts);

        recipeComponentEntityID = me.addRecipeComponentEntity(testRecipeComponent);

        recipeComponents = me.getAllRecipeComponents();
        assertTrue(recipeComponents.size() > 0);

        // clean up
        for (RecipeComponentEntity component : recipeComponents) {
            me.deleteRecipeComponentEntity(component);
        }

    }

    @Test
    public void testGetRecipeComponentEntity() throws Exception {

        RecipeComponentDao me = new RecipeComponentDao();
        RecipeComponentEntity testRecipeComponent = new RecipeComponentEntity();
        int recipeComponentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test grain and add them to the database
        testRecipeComponent = new RecipeComponentEntity();
        testRecipeComponent.setRecipeId(1);
        testRecipeComponent.setComponent(new ComponentEntity());
        testRecipeComponent.setAmount(new BigDecimal("1.0"));
        testRecipeComponent.setAmountUomId(1);
        testRecipeComponent.setUpdateDate(ts);
        testRecipeComponent.setCreateDate(ts);

        recipeComponentEntityID = me.addRecipeComponentEntity(testRecipeComponent);

        // confirm that a non-zero component ID was returned (indicator of success)
        assertTrue("Expected a non-zero recipe component ID, got " + recipeComponentEntityID, recipeComponentEntityID > 0);

        // confirm that the component can be retrieved from the database
        testRecipeComponent = me.getRecipeComponentEntity(recipeComponentEntityID);
        assertNotNull(testRecipeComponent);

        // clean up
        me.deleteRecipeComponentEntity(testRecipeComponent);

    }

    @Test
    public void testUpdateRecipeComponentEntity() throws Exception {

        RecipeComponentDao me = new RecipeComponentDao();
        RecipeComponentEntity testRecipeComponent = new RecipeComponentEntity();
        int recipeComponentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipeComponent = new RecipeComponentEntity();
        testRecipeComponent.setRecipeId(1);
        testRecipeComponent.setComponent(new ComponentEntity());
        testRecipeComponent.setAmount(new BigDecimal("1.0"));
        testRecipeComponent.setAmountUomId(1);
        testRecipeComponent.setUpdateDate(ts);
        testRecipeComponent.setCreateDate(ts);

        recipeComponentEntityID = me.addRecipeComponentEntity(testRecipeComponent);

        // retrieve the test component from the database and change its name
        testRecipeComponent = me.getRecipeComponentEntity(recipeComponentEntityID);
        testRecipeComponent.setAmount(new BigDecimal("2.0"));
        me.updateRecipeComponentEntity(testRecipeComponent);

        // retrieve the updated employee and test that the update took place
        testRecipeComponent = me.getRecipeComponentEntity(recipeComponentEntityID);

        assertEquals("Expected 2.0, got " + testRecipeComponent.getAmount(),
                new BigDecimal("2.00"), testRecipeComponent.getAmount());

        // clean up
        me.deleteRecipeComponentEntity(testRecipeComponent);

    }

    @Test
    public void testDeleteRecipeComponentEntity() throws Exception {

        RecipeComponentDao me = new RecipeComponentDao();
        RecipeComponentEntity testRecipeComponent = new RecipeComponentEntity();
        int recipeComponentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipeComponent = new RecipeComponentEntity();
        testRecipeComponent.setRecipeId(1);
        testRecipeComponent.setComponent(new ComponentEntity());
        testRecipeComponent.setAmount(new BigDecimal("1.0"));
        testRecipeComponent.setAmountUomId(1);
        testRecipeComponent.setUpdateDate(ts);
        testRecipeComponent.setCreateDate(ts);

        recipeComponentEntityID = me.addRecipeComponentEntity(testRecipeComponent);

        // make sure the employee was added before proceeding
        assertTrue("Expected a non-zero recipe component ID, got " + recipeComponentEntityID, recipeComponentEntityID > 0);

        // delete the employee and verify that they are no longer in the database
        me.deleteRecipeComponentEntity(me.getRecipeComponentEntity(recipeComponentEntityID));
        assertNull(me.getRecipeComponentEntity(recipeComponentEntityID));

    }

    @Test
    public void testAddRecipeComponentEntity() throws Exception {

        RecipeComponentDao me = new RecipeComponentDao();
        RecipeComponentEntity testRecipeComponent = new RecipeComponentEntity();
        int recipeComponentEntityID;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a test component and add them to the database
        testRecipeComponent = new RecipeComponentEntity();
        testRecipeComponent.setRecipeId(1);
        testRecipeComponent.setComponent(new ComponentEntity());
        testRecipeComponent.setAmount(new BigDecimal("1.0"));
        testRecipeComponent.setAmountUomId(1);
        testRecipeComponent.setUpdateDate(ts);
        testRecipeComponent.setCreateDate(ts);

        recipeComponentEntityID = me.addRecipeComponentEntity(testRecipeComponent);

        // confirm that a non-zero employee ID was returned (indicator of success)
        assertTrue("Expected a non-zero recipe component ID, got " + recipeComponentEntityID, recipeComponentEntityID > 0);

        // clean up
        testRecipeComponent = me.getRecipeComponentEntity(recipeComponentEntityID);
        me.deleteRecipeComponentEntity(testRecipeComponent);

    }
}