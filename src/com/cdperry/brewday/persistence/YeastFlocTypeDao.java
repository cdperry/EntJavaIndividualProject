package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastFlocTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class YeastFlocTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all YeastFlocTypeEntity objects
     * @return List<YeastFlocTypeEntity> a list of YeastFlocTypeEntity objects
     */
    public List<YeastFlocTypeEntity> getAllYeastFlocTypes() {

        List<YeastFlocTypeEntity> yeastFlocTypes = new ArrayList<YeastFlocTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            yeastFlocTypes = session.createQuery("FROM YeastFlocTypeEntity ORDER BY yeastFlocTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return yeastFlocTypes;

    }

    /**
     * This method returns a yeastFlocTypeEntity from the database when passed an appropriate yeastFlocTypeEntity ID
     * @param yeastFlocTypeEntityId the yeastFlocTypeEntity to be retrieved from the database
     * @return YeastFlocTypeEntity an YeastFlocTypeEntity object representing the yeastFlocTypeEntity retrieved from the database
     */
    public YeastFlocTypeEntity getYeastFlocTypeEntity(int yeastFlocTypeEntityId) {

        YeastFlocTypeEntity yeastFlocTypeEntity = new YeastFlocTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            yeastFlocTypeEntity = (YeastFlocTypeEntity)session.get(YeastFlocTypeEntity.class, yeastFlocTypeEntityId);
            tx.commit();
            if (yeastFlocTypeEntity != null) {
                log.warn("Retrieved yeast flocculation type: " + yeastFlocTypeEntity + " with id of: " + yeastFlocTypeEntity.getYeastFlocTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return yeastFlocTypeEntity;

    }

    /**
     * This method commits an updated YeastFlocTypeEntity object to the database
     * @param yeastFlocTypeEntity the yeastFlocTypeEntity object that should be updated in the databse
     */
    public void updateYeastFlocTypeEntity(YeastFlocTypeEntity yeastFlocTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(yeastFlocTypeEntity);
            tx.commit();
            log.warn("Updated yeast flocculation type: " + yeastFlocTypeEntity + " with id of: " + yeastFlocTypeEntity.getYeastFlocTypeId());

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
     * This method deletes the YeastFlocTypeEntity object from the database
     * @param yeastFlocTypeEntity the yeastFlocTypeEntity to be deleted from the database
     */
    public void deleteYeastFlocTypeEntity(YeastFlocTypeEntity yeastFlocTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(yeastFlocTypeEntity);
            tx.commit();
            log.warn("Deleted yeast flocculation type: " + yeastFlocTypeEntity + " with id of: " + yeastFlocTypeEntity.getYeastFlocTypeId());

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
     * This method deletes the YeastFlocTypeEntity object from the database
     * @param yeastFlocTypeId the ID of the yeastFlocTypeEntity to be deleted from the database
     */
    public void deleteYeastFlocTypeEntityById(int yeastFlocTypeId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            YeastFlocTypeEntity entityToDelete = (YeastFlocTypeEntity)session.get(YeastFlocTypeEntity.class, yeastFlocTypeId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted yeast flocculation type: " + entityToDelete + " with id of: " + yeastFlocTypeId);

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
     * This method adds an yeastFlocTypeEntity to the database and returns the ID associated with the new record
     * @param yeastFlocTypeEntity the yeastFlocTypeEntity to be added to the database
     * @return int the yeastFlocTypeEntity ID of the added record
     */
    public int addYeastFlocTypeEntity(YeastFlocTypeEntity yeastFlocTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer yeastFlocTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            yeastFlocTypeEntityId = (Integer) session.save(yeastFlocTypeEntity);
            tx.commit();
            log.warn("Added yeast flocculation type: " + yeastFlocTypeEntity + " with id of: " + yeastFlocTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return yeastFlocTypeEntityId;

    }

}
