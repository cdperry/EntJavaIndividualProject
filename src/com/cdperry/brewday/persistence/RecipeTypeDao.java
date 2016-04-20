package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.RecipeTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class RecipeTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all RecipeTypeEntity objects
     * @return List<RecipeTypeEntity> a list of RecipeTypeEntity objects
     */
    public List<RecipeTypeEntity> getAllRecipeTypes() {

        List<RecipeTypeEntity> recipeTypes = new ArrayList<RecipeTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            recipeTypes = session.createQuery("FROM RecipeTypeEntity ORDER BY recipeTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return recipeTypes;

    }

    /**
     * This method returns a recipeTypeEntity from the database when passed an appropriate recipeTypeEntity ID
     * @param recipeTypeEntityId the recipeTypeEntity to be retrieved from the database
     * @return RecipeTypeEntity an RecipeTypeEntity object representing the recipeTypeEntity retrieved from the database
     */
    public RecipeTypeEntity getRecipeTypeEntity(int recipeTypeEntityId) {

        RecipeTypeEntity recipeTypeEntity = new RecipeTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            recipeTypeEntity = (RecipeTypeEntity)session.get(RecipeTypeEntity.class, recipeTypeEntityId);
            tx.commit();
            if (recipeTypeEntity != null) {
                log.warn("Retrieved recipe type: " + recipeTypeEntity + " with id of: " + recipeTypeEntity.getRecipeTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return recipeTypeEntity;

    }

    /**
     * This method commits an updated RecipeTypeEntity object to the database
     * @param recipeTypeEntity the recipeTypeEntity object that should be updated in the databse
     */
    public void updateRecipeTypeEntity(RecipeTypeEntity recipeTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(recipeTypeEntity);
            tx.commit();
            log.warn("Updated recipe type: " + recipeTypeEntity + " with id of: " + recipeTypeEntity.getRecipeTypeId());

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
     * This method deletes the RecipeTypeEntity object from the database
     * @param recipeTypeEntity the recipeTypeEntity to be deleted from the database
     */
    public void deleteRecipeTypeEntity(RecipeTypeEntity recipeTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(recipeTypeEntity);
            tx.commit();
            log.warn("Deleted recipe type: " + recipeTypeEntity + " with id of: " + recipeTypeEntity.getRecipeTypeId());

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
     * This method deletes the RecipeTypeEntity object from the database
     * @param recipeTypeId the ID of the recipeTypeEntity to be deleted from the database
     */
    public void deleteRecipeTypeEntityById(int recipeTypeId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            RecipeTypeEntity entityToDelete = (RecipeTypeEntity)session.get(RecipeTypeEntity.class, recipeTypeId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted recipe type: " + entityToDelete + " with id of: " + recipeTypeId);

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
     * This method adds an recipeTypeEntity to the database and returns the ID associated with the new record
     * @param recipeTypeEntity the recipeTypeEntity to be added to the database
     * @return int the recipeTypeEntity ID of the added record
     */
    public int addRecipeTypeEntity(RecipeTypeEntity recipeTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer recipeTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            recipeTypeEntityId = (Integer) session.save(recipeTypeEntity);
            tx.commit();
            log.warn("Added recipe type: " + recipeTypeEntity + " with id of: " + recipeTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return recipeTypeEntityId;

    }

}
