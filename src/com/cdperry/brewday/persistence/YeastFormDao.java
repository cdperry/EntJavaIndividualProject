package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.YeastFormEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class YeastFormDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all YeastFormEntity objects
     * @return List<YeastFormEntity> a list of YeastFormEntity objects
     */
    public List<YeastFormEntity> getAllYeastForms() {

        List<YeastFormEntity> yeastForms = new ArrayList<YeastFormEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            yeastForms = session.createQuery("FROM YeastFormEntity ORDER BY yeastFormId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return yeastForms;

    }

    /**
     * This method returns a yeastFormEntity from the database when passed an appropriate yeastFormEntity ID
     * @param yeastFormEntityId the yeastFormEntity to be retrieved from the database
     * @return YeastFormEntity an YeastFormEntity object representing the yeastFormEntity retrieved from the database
     */
    public YeastFormEntity getYeastFormEntity(int yeastFormEntityId) {

        YeastFormEntity yeastFormEntity = new YeastFormEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            yeastFormEntity = (YeastFormEntity)session.get(YeastFormEntity.class, yeastFormEntityId);
            tx.commit();
            if (yeastFormEntity != null) {
                log.warn("Retrieved yeast form: " + yeastFormEntity + " with id of: " + yeastFormEntity.getYeastFormId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return yeastFormEntity;

    }

    /**
     * This method commits an updated YeastFormEntity object to the database
     * @param yeastFormEntity the yeastFormEntity object that should be updated in the databse
     */
    public void updateYeastFormEntity(YeastFormEntity yeastFormEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(yeastFormEntity);
            tx.commit();
            log.warn("Updated yeast form: " + yeastFormEntity + " with id of: " + yeastFormEntity.getYeastFormId());

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
     * This method deletes the YeastFormEntity object from the database
     * @param yeastFormEntity the yeastFormEntity to be deleted from the database
     */
    public void deleteYeastFormEntity(YeastFormEntity yeastFormEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(yeastFormEntity);
            tx.commit();
            log.warn("Deleted yeast form: " + yeastFormEntity + " with id of: " + yeastFormEntity.getYeastFormId());

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
     * This method adds an yeastFormEntity to the database and returns the ID associated with the new record
     * @param yeastFormEntity the yeastFormEntity to be added to the database
     * @return int the yeastFormEntity ID of the added record
     */
    public int addYeastFormEntity(YeastFormEntity yeastFormEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer yeastFormEntityId = null;

        try {
            tx = session.beginTransaction();
            yeastFormEntityId = (Integer) session.save(yeastFormEntity);
            tx.commit();
            log.warn("Added yeast form: " + yeastFormEntity + " with id of: " + yeastFormEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return yeastFormEntityId;

    }

}
