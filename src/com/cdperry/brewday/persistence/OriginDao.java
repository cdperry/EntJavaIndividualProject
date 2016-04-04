package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.OriginEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class OriginDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all OriginEntity objects
     * @return List<OriginEntity> a list of OriginEntity objects
     */
    public List<OriginEntity> getAllOrigins() {

        List<OriginEntity> origins = new ArrayList<OriginEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            origins = session.createQuery("FROM OriginEntity ORDER BY originId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return origins;

    }

    /**
     * This method returns a originEntity from the database when passed an appropriate originEntity ID
     * @param originEntityId the originEntity to be retrieved from the database
     * @return OriginEntity an OriginEntity object representing the originEntity retrieved from the database
     */
    public OriginEntity getOriginEntity(int originEntityId) {

        OriginEntity originEntity = new OriginEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            originEntity = (OriginEntity)session.get(OriginEntity.class, originEntityId);
            tx.commit();
            if (originEntity != null) {
                log.warn("Retrieved hop type: " + originEntity + " with id of: " + originEntity.getOriginId());
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
     * This method commits an updated OriginEntity object to the database
     * @param originEntity the originEntity object that should be updated in the databse
     */
    public void updateOriginEntity(OriginEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(originEntity);
            tx.commit();
            log.warn("Updated hop type: " + originEntity + " with id of: " + originEntity.getOriginId());

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
     * This method deletes the OriginEntity object from the database
     * @param originEntity the originEntity to be deleted from the database
     */
    public void deleteOriginEntity(OriginEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(originEntity);
            tx.commit();
            log.warn("Deleted hop type: " + originEntity + " with id of: " + originEntity.getOriginId());

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
    public int addOriginEntity(OriginEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer originEntityId = null;

        try {
            tx = session.beginTransaction();
            originEntityId = (Integer) session.save(originEntity);
            tx.commit();
            log.warn("Added hop type: " + originEntity + " with id of: " + originEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return originEntityId;

    }
    
}
