package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.SupplierEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 *
 * TODO: Create GetAllSuppliersByCriteria to diff between labs or suppliers
 */
public class SupplierDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all SupplierEntity objects
     * @return List<SupplierEntity> a list of SupplierEntity objects
     */
    public List<SupplierEntity> getAllSuppliers() {

        List<SupplierEntity> suppliers = new ArrayList<SupplierEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            suppliers = session.createQuery("FROM SupplierEntity ORDER BY supplierId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return suppliers;

    }

    /**
     * This method returns a originEntity from the database when passed an appropriate originEntity ID
     * @param supplierId the originEntity to be retrieved from the database
     * @return SupplierEntity an SupplierEntity object representing the originEntity retrieved from the database
     */
    public SupplierEntity getSupplierEntity(int supplierId) {

        SupplierEntity originEntity = new SupplierEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            originEntity = (SupplierEntity)session.get(SupplierEntity.class, supplierId);
            tx.commit();
            if (originEntity != null) {
                log.warn("Retrieved supplier: " + originEntity + " with id of: " + originEntity.getSupplierId());
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
     * This method commits an updated SupplierEntity object to the database
     * @param originEntity the originEntity object that should be updated in the databse
     */
    public void updateSupplierEntity(SupplierEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(originEntity);
            tx.commit();
            log.warn("Updated supplier: " + originEntity + " with id of: " + originEntity.getSupplierId());

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
     * This method deletes the SupplierEntity object from the database
     * @param originEntity the originEntity to be deleted from the database
     */
    public void deleteSupplierEntity(SupplierEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(originEntity);
            tx.commit();
            log.warn("Deleted supplier: " + originEntity + " with id of: " + originEntity.getSupplierId());

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
    public int addSupplierEntity(SupplierEntity originEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer supplierId = null;

        try {
            tx = session.beginTransaction();
            supplierId = (Integer) session.save(originEntity);
            tx.commit();
            log.warn("Added supplier: " + originEntity + " with id of: " + supplierId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return supplierId;

    }

}
