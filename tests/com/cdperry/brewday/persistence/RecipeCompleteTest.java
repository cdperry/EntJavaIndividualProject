package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.*;
import com.sun.tools.javac.jvm.Profile;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by cdperry on 4/17/16.
 *
 * TODO: Fix test so that it only works with records it created.  Failing due to test recipes created outside
 * TODO: the testing framework
 */
public class RecipeCompleteTest {

    @Test
    public void testCompleteRecipe() throws Exception {

        // create entities
        RecipeEntity testRecipe;
        RecipeComponentEntity component;
        UomTypeEntity uom = new UomTypeEntity();
        RecipeTypeEntity recipeType = new RecipeTypeEntity();
        ProfileEquipmentEntity profileEquipment = new ProfileEquipmentEntity();

        // create DAOs
        RecipeDao me = new RecipeDao();
        ProfileEquipmentDao profileEquipmentDao = new ProfileEquipmentDao();
        UomTypeDao uomTypeDao = new UomTypeDao();
        RecipeTypeDao recipeTypeDao = new RecipeTypeDao();

        // create other variables
        int id;
        List<RecipeEntity> recipes;
        HashSet set1;
        Set set2;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a UOM
        uom.setName("zgal");
        uom.setCreateDate(ts);
        uom.setUpdateDate(ts);
        id = uomTypeDao.addUomTypeEntity(uom);
        uom = uomTypeDao.getUomTypeEntity(id);

        // create a recipe type
        recipeType.setName("zAll Grain");
        recipeType.setCreateDate(ts);
        recipeType.setUpdateDate(ts);
        id = recipeTypeDao.addRecipeTypeEntity(recipeType);
        recipeType = recipeTypeDao.getRecipeTypeEntity(id);

        // create an equipment profile
        profileEquipment.setName("zPot and Cooler (10G)");
        id = profileEquipmentDao.addProfileEquipmentEntity(profileEquipment);
        profileEquipment = profileEquipmentDao.getProfileEquipmentEntity(id);

        // create a test recipe and add it to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 1");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeType(recipeType);
        testRecipe.setBatchSize(new BigDecimal("1.0"));
        testRecipe.setBatchSizeUom(uom);
        testRecipe.setProfileEquipment(profileEquipment);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        id = me.addRecipeEntity(testRecipe);

        // create recipe components and attach them to the recipe
        set1 = new HashSet();
        component = new RecipeComponentEntity();
        component.setRecipeId(id);
        component.setComponent(new ComponentEntity());
        component.setAmount(new BigDecimal("1.0"));
        component.setAmountUomId(1);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        component = new RecipeComponentEntity();
        component.setRecipeId(id);
        component.setComponent(new ComponentEntity());
        component.setAmount(new BigDecimal("2.0"));
        component.setAmountUomId(2);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        component = new RecipeComponentEntity();
        component.setRecipeId(id);
        component.setComponent(new ComponentEntity());
        component.setAmount(new BigDecimal("3.0"));
        component.setAmountUomId(3);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        testRecipe = me.getRecipeEntity(id);
        testRecipe.setRecipeComponents(set1);
        me.updateRecipeEntity(testRecipe);

        // create a test recipe and add it to the database
        testRecipe = new RecipeEntity();
        testRecipe.setRecipeName("Recipe 2");
        testRecipe.setBrewerName("Brewer 1");
        testRecipe.setRecipeType(recipeType);
        testRecipe.setBatchSize(new BigDecimal("5.0"));
        testRecipe.setBatchSizeUom(uom);
        testRecipe.setProfileEquipment(profileEquipment);
        testRecipe.setUpdateDate(ts);
        testRecipe.setCreateDate(ts);

        id = me.addRecipeEntity(testRecipe);

        // create recipe components and attach them to the recipe
        set1 = new HashSet();
        component = new RecipeComponentEntity();
        component.setRecipeId(id);
        component.setComponent(new ComponentEntity());
        component.setAmount(new BigDecimal("1.0"));
        component.setAmountUomId(1);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        component = new RecipeComponentEntity();
        component.setRecipeId(id);
        component.setComponent(new ComponentEntity());
        component.setAmount(new BigDecimal("2.0"));
        component.setAmountUomId(2);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        component = new RecipeComponentEntity();
        component.setRecipeId(id);
        component.setComponent(new ComponentEntity());
        component.setAmount(new BigDecimal("3.0"));
        component.setAmountUomId(3);
        component.setUpdateDate(ts);
        component.setCreateDate(ts);
        set1.add(component);

        testRecipe = me.getRecipeEntity(id);
        testRecipe.setRecipeComponents(set1);
        me.updateRecipeEntity(testRecipe);

        // run tests
        recipes = me.getAllRecipes();
        assertTrue("recipes size failure", recipes.size() > 0);

        testRecipe = recipes.get(0);
        System.out.println(testRecipe.getRecipeName());
        set2 = testRecipe.getRecipeComponents();
        System.out.println(set2.size());
        assertTrue("recipes component size failure", set2.size() == 3);

        uom = null;
        uom = testRecipe.getBatchSizeUom();
        assertTrue("uom name failure", uom.getName().equals("zgal"));

        recipeType = null;
        recipeType = testRecipe.getRecipeType();
        assertTrue("recipe type name failure", recipeType.getName().equals("zAll Grain"));

        profileEquipment = null;
        profileEquipment = testRecipe.getProfileEquipment();
        assertTrue("equip profile name failure", profileEquipment.getName().equals("zPot and Cooler (10G)"));

        // clean up
        for (RecipeEntity recipe : recipes) {
            //me.deleteRecipeEntity(recipe);
        }

    }
}

