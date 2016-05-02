package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.UomTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class UomTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all UomTypeEntity objects
     * @return List<UomTypeEntity> a list of UomTypeEntity objects
     */
    public List<UomTypeEntity> getAllUomTypes() {

        List<UomTypeEntity> uomTypes = new ArrayList<UomTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            uomTypes = session.createQuery("FROM UomTypeEntity ORDER BY uomId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return uomTypes;

    }

    /**
     * This method returns an entity give its name.  If there are multiple entities with the same name all of those
     * entities are returned.
     * @param name The name of the entity that should be returned
     * @return a list of UomTypeEntity objects that match the name parameter
     */
    public List<UomTypeEntity>  getUomTypeEntityByName(String name) {

        List<UomTypeEntity> uomTypes = new ArrayList<>();

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(UomTypeEntity.class);
        criteria.add(Restrictions.eq("name", name));

        // Language lang = (Language)super.findByCriteria(criteria).get(0);

        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            uomTypes = criteria.list();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            log.error(e.getStackTrace());

        } finally {
            session.close();
        }

        return uomTypes;

    }


    /**
     * This method returns a uomTypeEntity from the database when passed an appropriate uomTypeEntity ID
     * @param uomTypeEntityId the uomTypeEntity to be retrieved from the database
     * @return UomTypeEntity an UomTypeEntity object representing the uomTypeEntity retrieved from the database
     */
    public UomTypeEntity getUomTypeEntity(int uomTypeEntityId) {

        UomTypeEntity uomTypeEntity = new UomTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            uomTypeEntity = (UomTypeEntity)session.get(UomTypeEntity.class, uomTypeEntityId);
            tx.commit();
            if (uomTypeEntity != null) {
                log.warn("Retrieved uom type: " + uomTypeEntity + " with id of: " + uomTypeEntity.getUomId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return uomTypeEntity;

    }

    /**
     * This method commits an updated UomTypeEntity object to the database
     * @param uomTypeEntity the uomTypeEntity object that should be updated in the databse
     */
    public void updateUomTypeEntity(UomTypeEntity uomTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(uomTypeEntity);
            tx.commit();
            log.warn("Updated uom type: " + uomTypeEntity + " with id of: " + uomTypeEntity.getUomId());

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
     * This method deletes the UomTypeEntity object from the database
     * @param uomTypeEntity the uomTypeEntity to be deleted from the database
     */
    public void deleteUomTypeEntity(UomTypeEntity uomTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(uomTypeEntity);
            tx.commit();
            log.warn("Deleted uom type: " + uomTypeEntity + " with id of: " + uomTypeEntity.getUomId());

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
     * This method deletes the UomTypeEntity object from the database
     * @param uomTypeId the ID of the uomTypeEntity to be deleted from the database
     */
    public void deleteUomTypeEntityById(int uomTypeId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            UomTypeEntity entityToDelete = (UomTypeEntity)session.get(UomTypeEntity.class, uomTypeId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted uom type: " + entityToDelete + " with id of: " + uomTypeId);

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
     * This method adds an uomTypeEntity to the database and returns the ID associated with the new record
     * @param uomTypeEntity the uomTypeEntity to be added to the database
     * @return int the uomTypeEntity ID of the added record
     */
    public int addUomTypeEntity(UomTypeEntity uomTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer uomTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            uomTypeEntityId = (Integer) session.save(uomTypeEntity);
            tx.commit();
            log.warn("Added uom type: " + uomTypeEntity + " with id of: " + uomTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return uomTypeEntityId;

    }

}
