package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class RecipeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all RecipeEntity objects
     * @return List<RecipeEntity> a list of RecipeEntity objects
     */
    public List<RecipeEntity> getAllRecipes() {

        List<RecipeEntity> recipes = new ArrayList<RecipeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            recipes = session.createQuery("FROM RecipeEntity ORDER BY recipeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return recipes;

    }

    /**
     * This method returns a originEntity from the database when passed an appropriate originEntity ID
     * @param recipeId the originEntity to be retrieved from the database
     * @return RecipeEntity an RecipeEntity object representing the originEntity retrieved from the database
     */
    public RecipeEntity getRecipeEntity(int recipeId) {

        RecipeEntity recipeEntity = new RecipeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            recipeEntity = (RecipeEntity)session.get(RecipeEntity.class, recipeId);
            tx.commit();
            if (recipeEntity != null) {
                log.warn("Retrieved recipe: " + recipeEntity + " with id of: " + recipeEntity.getRecipeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return recipeEntity;

    }

    /**
     * This method commits an updated RecipeEntity object to the database
     * @param recipeEntity the originEntity object that should be updated in the databse
     */
    public void updateRecipeEntity(RecipeEntity recipeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(recipeEntity);
            tx.commit();
            log.warn("Updated recipe: " + recipeEntity + " with id of: " + recipeEntity.getRecipeId());

        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

    }

    /**
     * This method deletes the RecipeEntity object from the database
     * @param recipeEntity the originEntity to be deleted from the database
     */
    public void deleteRecipeEntity(RecipeEntity recipeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(recipeEntity);
            tx.commit();
            log.warn("Deleted recipe: " + recipeEntity + " with id of: " + recipeEntity.getRecipeId());

        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

    }

    /**
     * This method deletes the RecipeEntity object from the database
     * @param recipeId the ID of the RecipeEntity to be deleted from the database
     */
    public void deleteRecipeEntityById(int recipeId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            RecipeEntity entityToDelete = (RecipeEntity)session.get(RecipeEntity.class, recipeId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted recipe: " + entityToDelete + " with id of: " + recipeId);

        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

    }

    /**
     * This method adds an originEntity to the database and returns the ID associated with the new record
     * @param recipeEntity the originEntity to be added to the database
     * @return int the originEntity ID of the added record
     */
    public int addRecipeEntity(RecipeEntity recipeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer recipeId = null;

        try {
            tx = session.beginTransaction();
            recipeId = (Integer) session.save(recipeEntity);
            tx.commit();
            log.warn("Added recipe: " + recipeEntity + " with id of: " + recipeId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return recipeId;

    }

}
