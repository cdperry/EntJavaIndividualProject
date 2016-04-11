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

        RecipeEntity originEntity = new RecipeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            originEntity = (RecipeEntity)session.get(RecipeEntity.class, recipeId);
            tx.commit();
            if (originEntity != null) {
                log.warn("Retrieved recipe: " + originEntity + " with id of: " + originEntity.getRecipeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return originEntity;

    }

    /**
     * This method commits an updated RecipeEntity object to the database
     * @param originEntity the originEntity object that should be updated in the databse
     */
    public void updateRecipeEntity(RecipeEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(originEntity);
            tx.commit();
            log.warn("Updated recipe: " + originEntity + " with id of: " + originEntity.getRecipeId());

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
     * @param originEntity the originEntity to be deleted from the database
     */
    public void deleteRecipeEntity(RecipeEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(originEntity);
            tx.commit();
            log.warn("Deleted recipe: " + originEntity + " with id of: " + originEntity.getRecipeId());

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
     * @param originEntity the originEntity to be added to the database
     * @return int the originEntity ID of the added record
     */
    public int addRecipeEntity(RecipeEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer recipeId = null;

        try {
            tx = session.beginTransaction();
            recipeId = (Integer) session.save(originEntity);
            tx.commit();
            log.warn("Added recipe: " + originEntity + " with id of: " + recipeId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return recipeId;

    }

}
