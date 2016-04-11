package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ProfileEquipmentEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ProfileEquipmentDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ProfileEquipmentEntity objects
     * @return List<ProfileEquipmentEntity> a list of ProfileEquipmentEntity objects
     */
    public List<ProfileEquipmentEntity> getAllProfileEquipment() {

        List<ProfileEquipmentEntity> profileEquipment = new ArrayList<ProfileEquipmentEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            profileEquipment = session.createQuery("FROM ProfileEquipmentEntity ORDER BY profileEquipmentId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return profileEquipment;

    }

    /**
     * This method returns a profileEquipmentEntity from the database when passed an appropriate profileEquipmentEntity ID
     * @param profileEquipmentEntityId the profileEquipmentEntity to be retrieved from the database
     * @return ProfileEquipmentEntity an ProfileEquipmentEntity object representing the profileEquipmentEntity retrieved from the database
     */
    public ProfileEquipmentEntity getProfileEquipmentEntity(int profileEquipmentEntityId) {

        ProfileEquipmentEntity profileEquipmentEntity = new ProfileEquipmentEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            profileEquipmentEntity = (ProfileEquipmentEntity)session.get(ProfileEquipmentEntity.class, profileEquipmentEntityId);
            tx.commit();
            if (profileEquipmentEntity != null) {
                log.warn("Retrieved equipment profile: " + profileEquipmentEntity + " with id of: " + profileEquipmentEntity.getProfileEquipmentId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return profileEquipmentEntity;

    }

    /**
     * This method commits an updated ProfileEquipmentEntity object to the database
     * @param profileEquipmentEntity the profileEquipmentEntity object that should be updated in the databse
     */
    public void updateProfileEquipmentEntity(ProfileEquipmentEntity profileEquipmentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(profileEquipmentEntity);
            tx.commit();
            log.warn("Updated equipment profile: " + profileEquipmentEntity + " with id of: " + profileEquipmentEntity.getProfileEquipmentId());

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
     * This method deletes the ProfileEquipmentEntity object from the database
     * @param profileEquipmentEntity the profileEquipmentEntity to be deleted from the database
     */
    public void deleteProfileEquipmentEntity(ProfileEquipmentEntity profileEquipmentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(profileEquipmentEntity);
            tx.commit();
            log.warn("Deleted equipment profile: " + profileEquipmentEntity + " with id of: " + profileEquipmentEntity.getProfileEquipmentId());

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
     * This method adds an profileEquipmentEntity to the database and returns the ID associated with the new record
     * @param profileEquipmentEntity the profileEquipmentEntity to be added to the database
     * @return int the profileEquipmentEntity ID of the added record
     */
    public int addProfileEquipmentEntity(ProfileEquipmentEntity profileEquipmentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer profileEquipmentEntityId = null;

        try {
            tx = session.beginTransaction();
            profileEquipmentEntityId = (Integer) session.save(profileEquipmentEntity);
            tx.commit();
            log.warn("Added equipment profile: " + profileEquipmentEntity + " with id of: " + profileEquipmentEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return profileEquipmentEntityId;

    }
    
}
