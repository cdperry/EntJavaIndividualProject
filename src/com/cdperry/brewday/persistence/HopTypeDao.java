package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.HopTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class HopTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all HopTypeEntity objects
     * @return List<HopTypeEntity> a list of HopTypeEntity objects
     */
    public List<HopTypeEntity> getAllHopTypes() {

        List<HopTypeEntity> hopTypes = new ArrayList<HopTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            hopTypes = session.createQuery("FROM HopTypeEntity ORDER BY hopTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return hopTypes;

    }

    /**
     * This method returns a hopTypeEntity from the database when passed an appropriate hopTypeEntity ID
     * @param hopTypeEntityId the hopTypeEntity to be retrieved from the database
     * @return HopTypeEntity an HopTypeEntity object representing the hopTypeEntity retrieved from the database
     */
    public HopTypeEntity getHopTypeEntity(int hopTypeEntityId) {

        HopTypeEntity hopTypeEntity = new HopTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            hopTypeEntity = (HopTypeEntity)session.get(HopTypeEntity.class, hopTypeEntityId);
            tx.commit();
            if (hopTypeEntity != null) {
                log.warn("Retrieved hop type: " + hopTypeEntity + " with id of: " + hopTypeEntity.getHopTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return hopTypeEntity;

    }

    /**
     * This method commits an updated HopTypeEntity object to the database
     * @param hopTypeEntity the hopTypeEntity object that should be updated in the databse
     */
    public void updateHopTypeEntity(HopTypeEntity hopTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(hopTypeEntity);
            tx.commit();
            log.warn("Updated hop type: " + hopTypeEntity + " with id of: " + hopTypeEntity.getHopTypeId());

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
     * This method deletes the HopTypeEntity object from the database
     * @param hopTypeEntity the hopTypeEntity to be deleted from the database
     */
    public void deleteHopTypeEntity(HopTypeEntity hopTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(hopTypeEntity);
            tx.commit();
            log.warn("Deleted hop type: " + hopTypeEntity + " with id of: " + hopTypeEntity.getHopTypeId());

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
     * This method deletes the HopTypeEntity object from the database
     * @param hopTypeId the ID of the hopTypeEntity to be deleted from the database
     */
    public void deleteHopTypeEntityById(int hopTypeId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            HopTypeEntity entityToDelete = (HopTypeEntity)session.get(HopTypeEntity.class, hopTypeId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted hop type: " + entityToDelete + " with id of: " + hopTypeId);

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
     * This method adds an hopTypeEntity to the database and returns the ID associated with the new record
     * @param hopTypeEntity the hopTypeEntity to be added to the database
     * @return int the hopTypeEntity ID of the added record
     */
    public int addHopTypeEntity(HopTypeEntity hopTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer hopTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            hopTypeEntityId = (Integer) session.save(hopTypeEntity);
            tx.commit();
            log.warn("Added hop type: " + hopTypeEntity + " with id of: " + hopTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return hopTypeEntityId;

    }
    
}
