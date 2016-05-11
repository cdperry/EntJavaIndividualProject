package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.*;

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
        RecipeEntity recipeEntity;
        RecipeComponentEntity recipeComponentEntity;
        ComponentEntity componentEntity;
        ComponentHopEntity componentHopEntity;
        ComponentGrainEntity componentGrainEntity;
        ComponentYeastEntity componentYeastEntity;
        ComponentWaterEntity componentWaterEntity;
        ComponentOtherEntity componentOtherEntity;
        UomTypeEntity uom = new UomTypeEntity();
        RecipeTypeEntity recipeType = new RecipeTypeEntity();
        ProfileEquipmentEntity profileEquipment = new ProfileEquipmentEntity();

        // create DAOs
        RecipeDao recipeDao = new RecipeDao();
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

        // CREATE A HOP COMPONENT - this would be done before the user creates a recipe
        // create a component and add it to the database
        componentEntity = new ComponentEntity();
        componentEntity.setName("Cascade");
        componentEntity.setComponentType(componentTypeDao.getComponentTypeEntity(1));
        componentEntity.setUpdateDate(ts);
        componentEntity.setCreateDate(ts);

        componentHopEntity = new ComponentHopEntity(ts, ts);
        // ... set some other hop attributes here

        // create some other component<Type> entities (grain, yeast, water, other) for testing
        componentGrainEntity = new ComponentGrainEntity(ts, ts);
        componentYeastEntity = new ComponentYeastEntity(ts, ts);
        componentWaterEntity = new ComponentWaterEntity(ts, ts);
        componentOtherEntity = new ComponentOtherEntity(ts, ts);

        // associate the ComponentEntity object with the ComponentHopEntity object
        // and associate the ComponentHopEntity object with the ComponentEntity object
        // this will allow Hibernate to correctly insert the ID from 'component'
        // into 'component_hop'
        componentEntity.setComponentHop(componentHopEntity);
        componentHopEntity.setComponentEntity(componentEntity);

        // do the same for the other Component<Type>Entity objects
        componentEntity.setComponentGrain(componentGrainEntity);
        componentGrainEntity.setComponentEntity(componentEntity);

        componentEntity.setComponentYeast(componentYeastEntity);
        componentYeastEntity.setComponentEntity(componentEntity);

        componentEntity.setComponentWater(componentWaterEntity);
        componentWaterEntity.setComponentEntity(componentEntity);

        componentEntity.setComponentOther(componentOtherEntity);
        componentOtherEntity.setComponentEntity(componentEntity);

        // Add the component to the database. Hibernate will create the ComponentEntity first and then
        // will use the primary key from that entity to create the associated Component<Type>Entity object
        // and populate the foreign key value with the primary key of the associated ComponentEntity object
        componentId = componentDao.addComponentEntity(componentEntity);

        // CREATE A RECIPE - now that we have supporting components let's build a recipe
        // create a test recipe and add it to the database
        recipeEntity = new RecipeEntity();
        recipeEntity.setRecipeName("Recipe 1");
        recipeEntity.setBrewerName("Brewer 1");
        recipeEntity.setRecipeType(recipeType);
        recipeEntity.setBatchSize(new BigDecimal("1.0"));
        recipeEntity.setBatchSizeUom(uom);
        recipeEntity.setProfileEquipment(profileEquipment);
        recipeEntity.setUpdateDate(ts);
        recipeEntity.setCreateDate(ts);

        /* TODO: if lazy=true on these entities I get failures.  Fix?
        recipeType.getRecipes().add(recipeEntity);
        recipeTypeDao.updateRecipeTypeEntity(recipeType);
        uom.getRecipeBatchSizes().add(recipeEntity);
        uomTypeDao.updateUomTypeEntity(uom);
        profileEquipment.getRecipes().add(recipeEntity);
        profileEquipmentDao.updateProfileEquipmentEntity(profileEquipment);
        */

        // add the recipe - in the web app workflow you create the recipe first and then add recipe components
        // later.  Add the recipeId to the ArrayList of recipes so we can clean up at the end.
        recipeId = recipeDao.addRecipeEntity(recipeEntity);
        recipeIds.add(recipeId);

        // create a recipe line (a RecipeComponentEntity object)
        recipeComponentEntity = new RecipeComponentEntity(ts, ts);
        recipeComponentEntity.setAmount(new BigDecimal("1.0"));
        //recipeComponentEntity.setAmountUom();

        // add a RecipeEntity > RecipeComponentEntity
        recipeComponentEntity.setRecipeEntity(recipeEntity);
        recipeEntity.getRecipeComponents().add(recipeComponentEntity);

        // add a RecipeComponentEntity <> ComponentEntity relationship
        recipeComponentEntity.setComponent(componentEntity);
        //componentEntity.getRecipeComponents().add(recipeComponentEntity);

        //recipeComponentDao.addRecipeComponentEntity(recipeComponentEntity);
        recipeDao.updateRecipeEntity(recipeEntity);

/*
        // associate the component with the recipe-component relationship
        recipeComponentEntity.setComponent(componentEntity);
        recipeComponentDao.updateRecipeComponentEntity(recipeComponentEntity);

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

        Thread.sleep(5000);

        // delete some types and make sure that the recipe record doesn't get deleted
        uomTypeDao.deleteUomTypeEntityById(uomId);
        recipeTypeDao.deleteRecipeTypeEntityById(recipeTypeId);
        profileEquipmentDao.deleteProfileEquipmentEntityById(equipmentProfileId);
        assertNotNull("Expected recipe to exist but it's gone", recipeDao.getRecipeEntity(recipeId));

        Thread.sleep(5000);

        // delete the ComponentEntity object which should cascade delete the associated ComponentHopEntity object
        // and the associated RecipeComponentEntity object
        componentDao.deleteComponentEntity(componentEntity);
        assertNotNull("Expected recipe to exist but it's gone", recipeDao.getRecipeEntity(recipeId));
        //assertNull(recipeComponentDao.getRecipeComponentEntity(recipeComponentId));
        //assertNull(componentHopEntity.getComponentEntity(componentHopId));

        Thread.sleep(5000);

        // clean up
        for (int thisId : recipeIds) {
            recipeDao.deleteRecipeEntityById(thisId);
        }

    }
}

