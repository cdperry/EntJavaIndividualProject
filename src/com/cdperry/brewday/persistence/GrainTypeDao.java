package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.GrainTypeEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class GrainTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all GrainTypeEntity objects
     * @return List<GrainTypeEntity> a list of GrainTypeEntity objects
     */
    public List<GrainTypeEntity> getAllGrainTypes() {

        List<GrainTypeEntity> grainTypes = new ArrayList<GrainTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            grainTypes = session.createQuery("FROM GrainTypeEntity ORDER BY grainTypeId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return grainTypes;

    }

    /**
     * This method returns a grainTypeEntity from the database when passed an appropriate grainTypeEntity ID
     * @param grainTypeEntityId the grainTypeEntity to be retrieved from the database
     * @return GrainTypeEntity an GrainTypeEntity object representing the grainTypeEntity retrieved from the database
     */
    public GrainTypeEntity getGrainTypeEntity(int grainTypeEntityId) {

        GrainTypeEntity grainTypeEntity = new GrainTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            grainTypeEntity = (GrainTypeEntity)session.get(GrainTypeEntity.class, grainTypeEntityId);
            tx.commit();
            if (grainTypeEntity != null) {
                log.warn("Retrieved grain type: " + grainTypeEntity + " with id of: " + grainTypeEntity.getGrainTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return grainTypeEntity;

    }

    /**
     * This method commits an updated GrainTypeEntity object to the database
     * @param grainTypeEntity the grainTypeEntity object that should be updated in the databse
     */
    public void updateGrainTypeEntity(GrainTypeEntity grainTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(grainTypeEntity);
            tx.commit();
            log.warn("Updated grain type: " + grainTypeEntity + " with id of: " + grainTypeEntity.getGrainTypeId());

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
     * This method deletes the GrainTypeEntity object from the database
     * @param grainTypeEntity the grainTypeEntity to be deleted from the database
     */
    public void deleteGrainTypeEntity(GrainTypeEntity grainTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(grainTypeEntity);
            tx.commit();
            log.warn("Deleted grain type: " + grainTypeEntity + " with id of: " + grainTypeEntity.getGrainTypeId());

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
     * This method adds an grainTypeEntity to the database and returns the ID associated with the new record
     * @param grainTypeEntity the grainTypeEntity to be added to the database
     * @return int the grainTypeEntity ID of the added record
     */
    public int addGrainTypeEntity(GrainTypeEntity grainTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer grainTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            grainTypeEntityId = (Integer) session.save(grainTypeEntity);
            tx.commit();
            log.warn("Added grain type: " + grainTypeEntity + " with id of: " + grainTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return grainTypeEntityId;

    }
    
}
