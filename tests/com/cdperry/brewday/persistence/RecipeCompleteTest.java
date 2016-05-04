package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.*;
import com.sun.tools.javac.jvm.Profile;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.assertNotNull;
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

        ArrayList<Integer> recipeIds = new ArrayList<Integer>();
        int uomId;
        int equipmentProfileId;
        int recipeTypeId;
        int recipeId;
        int componentId;

        // create entities
        RecipeEntity testRecipe;
        RecipeComponentEntity recipeComponentEntity;
        ComponentEntity componentEntity;
        ComponentHopEntity componentHopEntity;
        UomTypeEntity uom = new UomTypeEntity();
        RecipeTypeEntity recipeType = new RecipeTypeEntity();
        ProfileEquipmentEntity profileEquipment = new ProfileEquipmentEntity();

        // create DAOs
        RecipeDao me = new RecipeDao();
        RecipeComponentDao recipeComponentDao = new RecipeComponentDao();
        ComponentDao componentDao = new ComponentDao();
        ComponentTypeDao componentTypeDao = new ComponentTypeDao();
        ProfileEquipmentDao profileEquipmentDao = new ProfileEquipmentDao();
        UomTypeDao uomTypeDao = new UomTypeDao();
        RecipeTypeDao recipeTypeDao = new RecipeTypeDao();

        // create other variables
        List<RecipeEntity> recipes;
        HashSet set1;
        Set set2;
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

        // create a UOM
        uom.setName("zgal");
        uom.setCreateDate(ts);
        uom.setUpdateDate(ts);
        uomId = uomTypeDao.addUomTypeEntity(uom);
        uom = uomTypeDao.getUomTypeEntity(uomId);

        // create a recipe type
        recipeType.setName("zAll Grain");
        recipeType.setCreateDate(ts);
        recipeType.setUpdateDate(ts);
        recipeTypeId = recipeTypeDao.addRecipeTypeEntity(recipeType);
        recipeType = recipeTypeDao.getRecipeTypeEntity(recipeTypeId);

        // create an equipment profile
        profileEquipment.setName("zPot and Cooler (10G)");
        equipmentProfileId = profileEquipmentDao.addProfileEquipmentEntity(profileEquipment);
        profileEquipment = profileEquipmentDao.getProfileEquipmentEntity(equipmentProfileId);

        // CREATE A HOP COMPONENT
        // create a component and add it to the database
        componentEntity = new ComponentEntity();
        componentEntity.setName("Cascade");
        componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(1));
        componentEntity.setUpdateDate(ts);
        componentEntity.setCreateDate(ts);

        // if cascading works properly we can do this add at the end instead of an add-update
        //componentId = componentDao.addComponentEntity(componentEntity);

        // TODO: need to set up a one-to-one relationship here so that we don't need to know the
        // componentId foreign key
        componentHopEntity = new ComponentHopEntity(componentId, ts, ts);
        // ... set some other hop attributes here

        // associate this component with a hop component entity
        componentEntity.setComponentHop(componentHopEntity);

        // shouldn't need this update, do an add instead
        //componentDao.updateComponentEntity(componentEntity);

        componentId = componentDao.addComponentEntity(componentEntity);

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

        recipeId = me.addRecipeEntity(testRecipe);
        recipeIds.add(recipeId);

        // add a recipe-component relationship
        recipeComponentEntity = new RecipeComponentEntity(recipeId, ts, ts);
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentDao.addRecipeComponentEntity(recipeComponentEntity);

        // associate the component with the recipe-component relationship
        recipeComponentEntity.setComponent(componentEntity);
        recipeComponentDao.updateRecipeComponentEntity(recipeComponentEntity);

/*
        // create recipe components and attach them to the recipe
        set1 = new HashSet();
        recipeComponentEntity = new RecipeComponentEntity();
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentEntity.setComponent(new ComponentEntity());
        recipeComponentEntity.setAmount(new BigDecimal("1.0"));
        recipeComponentEntity.setAmountUom(uom);
        recipeComponentEntity.setUpdateDate(ts);
        recipeComponentEntity.setCreateDate(ts);
        set1.add(recipeComponentEntity);

        recipeComponentEntity = new RecipeComponentEntity();
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentEntity.setComponent(new ComponentEntity());
        recipeComponentEntity.setAmount(new BigDecimal("2.0"));
        recipeComponentEntity.setAmountUom(uom);
        recipeComponentEntity.setUpdateDate(ts);
        recipeComponentEntity.setCreateDate(ts);
        set1.add(recipeComponentEntity);

        recipeComponentEntity = new RecipeComponentEntity();
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentEntity.setComponent(new ComponentEntity());
        recipeComponentEntity.setAmount(new BigDecimal("3.0"));
        recipeComponentEntity.setAmountUom(uom);
        recipeComponentEntity.setUpdateDate(ts);
        recipeComponentEntity.setCreateDate(ts);
        set1.add(recipeComponentEntity);

        testRecipe = me.getRecipeEntity(recipeId);
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

        recipeId = me.addRecipeEntity(testRecipe);
        recipeIds.add(recipeId);

        // create recipe components and attach them to the recipe
        set1 = new HashSet();
        recipeComponentEntity = new RecipeComponentEntity();
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentEntity.setComponent(new ComponentEntity());
        recipeComponentEntity.setAmount(new BigDecimal("1.0"));
        recipeComponentEntity.setAmountUom(uom);
        recipeComponentEntity.setUpdateDate(ts);
        recipeComponentEntity.setCreateDate(ts);
        set1.add(recipeComponentEntity);

        recipeComponentEntity = new RecipeComponentEntity();
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentEntity.setComponent(new ComponentEntity());
        recipeComponentEntity.setAmount(new BigDecimal("2.0"));
        recipeComponentEntity.setAmountUom(uom);
        recipeComponentEntity.setUpdateDate(ts);
        recipeComponentEntity.setCreateDate(ts);
        set1.add(recipeComponentEntity);

        recipeComponentEntity = new RecipeComponentEntity();
        recipeComponentEntity.setRecipeId(recipeId);
        recipeComponentEntity.setComponent(new ComponentEntity());
        recipeComponentEntity.setAmount(new BigDecimal("3.0"));
        recipeComponentEntity.setAmountUom(uom);
        recipeComponentEntity.setUpdateDate(ts);
        recipeComponentEntity.setCreateDate(ts);
        set1.add(recipeComponentEntity);

        testRecipe = me.getRecipeEntity(recipeId);
        testRecipe.setRecipeComponents(set1);
        me.updateRecipeEntity(testRecipe);

        // run tests
        testRecipe = null;
        testRecipe = me.getRecipeEntity(recipeIds.get(1));
        assertNotNull("expected recipe, got null", testRecipe);
        testRecipe = null;
        testRecipe = me.getRecipeEntity(recipeIds.get(0));
        assertNotNull("expected recipe, got null", testRecipe);

        // get the first recipe that was created in the test
        set2 = testRecipe.getRecipeComponents();
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
*/
        // clean up
        for (int thisId : recipeIds) {
            me.deleteRecipeEntityById(thisId);
        }

        profileEquipmentDao.deleteProfileEquipmentEntityById(equipmentProfileId);
        uomTypeDao.deleteUomTypeEntityById(uomId);
        recipeTypeDao.deleteRecipeTypeEntityById(recipeTypeId);


    }
}

