package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeComponentEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class RecipeComponentDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all RecipeComponentEntity objects
     * @return List<RecipeComponentEntity> a list of RecipeComponentEntity objects
     */
    public List<RecipeComponentEntity> getAllRecipeComponents() {

        List<RecipeComponentEntity> recipeComponents = new ArrayList<RecipeComponentEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            recipeComponents = session.createQuery("FROM RecipeComponentEntity ORDER BY recipeComponentId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return recipeComponents;

    }

    /**
     * This method returns a recipeComponentEntity from the database when passed an appropriate recipeComponentEntity ID
     * @param recipeComponentEntityId the recipeComponentEntity to be retrieved from the database
     * @return RecipeComponentEntity an RecipeComponentEntity object representing the recipeComponentEntity retrieved from the database
     */
    public RecipeComponentEntity getRecipeComponentEntity(int recipeComponentEntityId) {

        RecipeComponentEntity recipeComponentEntity = new RecipeComponentEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            recipeComponentEntity = (RecipeComponentEntity)session.get(RecipeComponentEntity.class, recipeComponentEntityId);
            tx.commit();
            if (recipeComponentEntity != null) {
                log.warn("Retrieved recipe component: " + recipeComponentEntity + " with id of: " + recipeComponentEntity.getRecipeComponentId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return recipeComponentEntity;

    }

    /**
     * This method commits an updated RecipeComponentEntity object to the database
     * @param recipeComponentEntity the recipeComponentEntity object that should be updated in the databse
     */
    public void updateRecipeComponentEntity(RecipeComponentEntity recipeComponentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(recipeComponentEntity);
            tx.commit();
            log.warn("Updated recipe component: " + recipeComponentEntity + " with id of: " + recipeComponentEntity.getRecipeComponentId());

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
     * This method deletes the RecipeComponentEntity object from the database
     * @param recipeComponentEntity the recipeComponentEntity to be deleted from the database
     */
    public void deleteRecipeComponentEntity(RecipeComponentEntity recipeComponentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(recipeComponentEntity);
            tx.commit();
            log.warn("Deleted recipe component: " + recipeComponentEntity + " with id of: " + recipeComponentEntity.getRecipeComponentId());

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
     * This method adds an recipeComponentEntity to the database and returns the ID associated with the new record
     * @param recipeComponentEntity the recipeComponentEntity to be added to the database
     * @return int the recipeComponentEntity ID of the added record
     */
    public int addRecipeComponentEntity(RecipeComponentEntity recipeComponentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer recipeComponentEntityId = null;

        try {
            tx = session.beginTransaction();
            recipeComponentEntityId = (Integer) session.save(recipeComponentEntity);
            tx.commit();
            log.warn("Added recipe component type: " + recipeComponentEntity + " with id of: " + recipeComponentEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return recipeComponentEntityId;

    }

}
