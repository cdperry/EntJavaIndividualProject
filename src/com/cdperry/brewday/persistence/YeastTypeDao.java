package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class YeastTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all YeastTypeEntity objects
     * @return List<YeastTypeEntity> a list of YeastTypeEntity objects
     */
    public List<YeastTypeEntity> getAllYeastTypes() {

        List<YeastTypeEntity> yeastTypes = new ArrayList<YeastTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            yeastTypes = session.createQuery("FROM YeastTypeEntity ORDER BY yeastTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return yeastTypes;

    }

    /**
     * This method returns a yeastTypeEntity from the database when passed an appropriate yeastTypeEntity ID
     * @param yeastTypeEntityId the yeastTypeEntity to be retrieved from the database
     * @return YeastTypeEntity an YeastTypeEntity object representing the yeastTypeEntity retrieved from the database
     */
    public YeastTypeEntity getYeastTypeEntity(int yeastTypeEntityId) {

        YeastTypeEntity yeastTypeEntity = new YeastTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            yeastTypeEntity = (YeastTypeEntity)session.get(YeastTypeEntity.class, yeastTypeEntityId);
            tx.commit();
            if (yeastTypeEntity != null) {
                log.warn("Retrieved yeast type: " + yeastTypeEntity + " with id of: " + yeastTypeEntity.getYeastTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return yeastTypeEntity;

    }

    /**
     * This method commits an updated YeastTypeEntity object to the database
     * @param yeastTypeEntity the yeastTypeEntity object that should be updated in the databse
     */
    public void updateYeastTypeEntity(YeastTypeEntity yeastTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(yeastTypeEntity);
            tx.commit();
            log.warn("Updated yeast type: " + yeastTypeEntity + " with id of: " + yeastTypeEntity.getYeastTypeId());

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
     * This method deletes the YeastTypeEntity object from the database
     * @param yeastTypeEntity the yeastTypeEntity to be deleted from the database
     */
    public void deleteYeastTypeEntity(YeastTypeEntity yeastTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(yeastTypeEntity);
            tx.commit();
            log.warn("Deleted yeast type: " + yeastTypeEntity + " with id of: " + yeastTypeEntity.getYeastTypeId());

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
     * This method adds an yeastTypeEntity to the database and returns the ID associated with the new record
     * @param yeastTypeEntity the yeastTypeEntity to be added to the database
     * @return int the yeastTypeEntity ID of the added record
     */
    public int addYeastTypeEntity(YeastTypeEntity yeastTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer yeastTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            yeastTypeEntityId = (Integer) session.save(yeastTypeEntity);
            tx.commit();
            log.warn("Added yeast type: " + yeastTypeEntity + " with id of: " + yeastTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return yeastTypeEntityId;

    }

}
