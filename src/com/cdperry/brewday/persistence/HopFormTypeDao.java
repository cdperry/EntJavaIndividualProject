package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.HopFormTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class HopFormTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all HopFormTypeEntity objects
     * @return List<HopFormTypeEntity> a list of HopFormTypeEntity objects
     */
    public List<HopFormTypeEntity> getAllHopFormTypes() {

        List<HopFormTypeEntity> hopForms = new ArrayList<HopFormTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            hopForms = session.createQuery("FROM HopFormTypeEntity ORDER BY hopFormId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return hopForms;

    }

    /**
     * This method returns a hopFormTypeEntity from the database when passed an appropriate hopFormTypeEntity ID
     * @param hopFormTypeEntityId the hopFormTypeEntity to be retrieved from the database
     * @return HopFormTypeEntity an HopFormTypeEntity object representing the hopFormTypeEntity retrieved from the database
     */
    public HopFormTypeEntity getHopFormTypeEntity(int hopFormTypeEntityId) {

        HopFormTypeEntity hopFormTypeEntity = new HopFormTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            hopFormTypeEntity = (HopFormTypeEntity)session.get(HopFormTypeEntity.class, hopFormTypeEntityId);
            tx.commit();
            if (hopFormTypeEntity != null) {
                log.warn("Retrieved hop form: " + hopFormTypeEntity + " with id of: " + hopFormTypeEntity.getHopFormId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return hopFormTypeEntity;

    }

    /**
     * This method commits an updated HopFormTypeEntity object to the database
     * @param hopFormTypeEntity the hopFormTypeEntity object that should be updated in the databse
     */
    public void updateHopFormTypeEntity(HopFormTypeEntity hopFormTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(hopFormTypeEntity);
            tx.commit();
            log.warn("Updated hop form: " + hopFormTypeEntity + " with id of: " + hopFormTypeEntity.getHopFormId());

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
     * This method deletes the HopFormTypeEntity object from the database
     * @param hopFormTypeEntity the hopFormTypeEntity to be deleted from the database
     */
    public void deleteHopFormTypeEntity(HopFormTypeEntity hopFormTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(hopFormTypeEntity);
            tx.commit();
            log.warn("Deleted hop form: " + hopFormTypeEntity + " with id of: " + hopFormTypeEntity.getHopFormId());

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
     * This method adds an hopFormTypeEntity to the database and returns the ID associated with the new record
     * @param hopFormTypeEntity the hopFormTypeEntity to be added to the database
     * @return int the hopFormTypeEntity ID of the added record
     */
    public int addHopFormTypeEntity(HopFormTypeEntity hopFormTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer hopFormTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            hopFormTypeEntityId = (Integer) session.save(hopFormTypeEntity);
            tx.commit();
            log.warn("Added hop form: " + hopFormTypeEntity + " with id of: " + hopFormTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return hopFormTypeEntityId;

    }
    
}
