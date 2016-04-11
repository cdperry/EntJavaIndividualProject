package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.SupplierTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class SupplierTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all SupplierTypeEntity objects
     * @return List<SupplierTypeEntity> a list of SupplierTypeEntity objects
     */
    public List<SupplierTypeEntity> getAllSupplierTypes() {

        List<SupplierTypeEntity> supplierTypes = new ArrayList<SupplierTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            supplierTypes = session.createQuery("FROM SupplierTypeEntity ORDER BY supplierTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return supplierTypes;

    }

    /**
     * This method returns a supplierTypeEntity from the database when passed an appropriate supplierTypeEntity ID
     * @param supplierTypeEntityId the supplierTypeEntity to be retrieved from the database
     * @return SupplierTypeEntity an SupplierTypeEntity object representing the supplierTypeEntity retrieved from the database
     */
    public SupplierTypeEntity getSupplierTypeEntity(int supplierTypeEntityId) {

        SupplierTypeEntity supplierTypeEntity = new SupplierTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            supplierTypeEntity = (SupplierTypeEntity)session.get(SupplierTypeEntity.class, supplierTypeEntityId);
            tx.commit();
            if (supplierTypeEntity != null) {
                log.warn("Retrieved supplier type: " + supplierTypeEntity + " with id of: " + supplierTypeEntity.getSupplierTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return supplierTypeEntity;

    }

    /**
     * This method commits an updated SupplierTypeEntity object to the database
     * @param supplierTypeEntity the supplierTypeEntity object that should be updated in the databse
     */
    public void updateSupplierTypeEntity(SupplierTypeEntity supplierTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(supplierTypeEntity);
            tx.commit();
            log.warn("Updated supplier type: " + supplierTypeEntity + " with id of: " + supplierTypeEntity.getSupplierTypeId());

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
     * This method deletes the SupplierTypeEntity object from the database
     * @param supplierTypeEntity the supplierTypeEntity to be deleted from the database
     */
    public void deleteSupplierTypeEntity(SupplierTypeEntity supplierTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(supplierTypeEntity);
            tx.commit();
            log.warn("Deleted supplier type: " + supplierTypeEntity + " with id of: " + supplierTypeEntity.getSupplierTypeId());

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
     * This method adds an supplierTypeEntity to the database and returns the ID associated with the new record
     * @param supplierTypeEntity the supplierTypeEntity to be added to the database
     * @return int the supplierTypeEntity ID of the added record
     */
    public int addSupplierTypeEntity(SupplierTypeEntity supplierTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer supplierTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            supplierTypeEntityId = (Integer) session.save(supplierTypeEntity);
            tx.commit();
            log.warn("Added supplier type: " + supplierTypeEntity + " with id of: " + supplierTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return supplierTypeEntityId;

    }

}
