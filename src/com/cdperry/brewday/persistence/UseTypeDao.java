package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.UseTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class UseTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all UseTypeEntity objects
     * @return List<UseTypeEntity> a list of UseTypeEntity objects
     */
    public List<UseTypeEntity> getAllUseTypes() {

        List<UseTypeEntity> useTypes = new ArrayList<UseTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            useTypes = session.createQuery("FROM UseTypeEntity ORDER BY useTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return useTypes;

    }

    /**
     * This method returns a useTypeEntity from the database when passed an appropriate useTypeEntity ID
     * @param useTypeEntityId the useTypeEntity to be retrieved from the database
     * @return UseTypeEntity an UseTypeEntity object representing the useTypeEntity retrieved from the database
     */
    public UseTypeEntity getUseTypeEntity(int useTypeEntityId) {

        UseTypeEntity useTypeEntity = new UseTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            useTypeEntity = (UseTypeEntity)session.get(UseTypeEntity.class, useTypeEntityId);
            tx.commit();
            if (useTypeEntity != null) {
                log.warn("Retrieved use type: " + useTypeEntity + " with id of: " + useTypeEntity.getUseTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return useTypeEntity;

    }

    /**
     * This method commits an updated UseTypeEntity object to the database
     * @param useTypeEntity the useTypeEntity object that should be updated in the databse
     */
    public void updateUseTypeEntity(UseTypeEntity useTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(useTypeEntity);
            tx.commit();
            log.warn("Updated use type: " + useTypeEntity + " with id of: " + useTypeEntity.getUseTypeId());

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
     * This method deletes the UseTypeEntity object from the database
     * @param useTypeEntity the useTypeEntity to be deleted from the database
     */
    public void deleteUseTypeEntity(UseTypeEntity useTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(useTypeEntity);
            tx.commit();
            log.warn("Deleted use type: " + useTypeEntity + " with id of: " + useTypeEntity.getUseTypeId());

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
     * This method adds an useTypeEntity to the database and returns the ID associated with the new record
     * @param useTypeEntity the useTypeEntity to be added to the database
     * @return int the useTypeEntity ID of the added record
     */
    public int addUseTypeEntity(UseTypeEntity useTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer useTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            useTypeEntityId = (Integer) session.save(useTypeEntity);
            tx.commit();
            log.warn("Added use type: " + useTypeEntity + " with id of: " + useTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return useTypeEntityId;

    }

}
