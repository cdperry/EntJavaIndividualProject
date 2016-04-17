package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeEntity;
import com.cdperry.brewday.entity.RecipeComponentEntity;
import com.cdperry.brewday.persistence.RecipeDao;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import static org.junit.Assert.*;

/**
 * Created by cdperry on 4/17/16.
 */
public class RecipeComponentOneToManyTest {

    @Test
    public void testOneToMany() throws Exception {

        RecipeEntity testRecipe = new RecipeEntity();
        RecipeDao me = new RecipeDao();
        List<RecipeEntity> recipes;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        HashSet set1 = new HashSet();
        Set set2;

        RecipeComponentEntity component = new RecipeComponentEntity();
        component.setRecipeId(1);
        component.setComponentId(1);
        component.setAmount(new BigDecimal("1.0"));
        component.setAmountUomId(1);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        component = new RecipeComponentEntity();
        component.setRecipeId(1);
        component.setComponentId(2);
        component.setAmount(new BigDecimal("2.0"));
        component.setAmountUomId(2);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        component = new RecipeComponentEntity();
        component.setRecipeId(1);
        component.setComponentId(3);
        component.setAmount(new BigDecimal("3.0"));
        component.setAmountUomId(3);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        int recipeEntityID;

        // create a test component and add them to the database
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeTypeId(1);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUomId(1);
        testRecipe.setEquipmentProfileId(1);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);
        testRecipe.setRecipeComponents(set1);

        recipeEntityID = me.addRecipeEntity(testRecipe);

        recipes = me.getAllRecipes();
        testRecipe = recipes.get(0);
        assertTrue(recipes.size() > 0);
        set2 = testRecipe.getRecipeComponents();
        assertTrue(set2.size() == 3);

        // clean up
        for (RecipeEntity recipe : recipes) {
            me.deleteRecipeEntity(recipe);
        }

    }
}

