package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentGrainEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentGrainDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentGrainEntity objects
     * @return List<ComponentGrainEntity> a list of ComponentGrainEntity objects
     */
    public List<ComponentGrainEntity> getAllComponentGrains() {

        List<ComponentGrainEntity> componentGrains = new ArrayList<ComponentGrainEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentGrains = session.createQuery("FROM ComponentGrainEntity ORDER BY compGrainId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentGrains;

    }

    /**
     * This method returns a componentGrainEntity from the database when passed an appropriate componentGrainEntity ID
     * @param componentGrainEntityId the componentGrainEntity to be retrieved from the database
     * @return ComponentGrainEntity an ComponentGrainEntity object representing the componentGrainEntity retrieved from the database
     */
    public ComponentGrainEntity getComponentGrainEntity(int componentGrainEntityId) {

        ComponentGrainEntity componentGrainEntity = new ComponentGrainEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentGrainEntity = (ComponentGrainEntity)session.get(ComponentGrainEntity.class, componentGrainEntityId);
            tx.commit();
            if (componentGrainEntity != null) {
                log.warn("Retrieved component: " + componentGrainEntity + " with id of: " + componentGrainEntity.getCompGrainId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentGrainEntity;

    }

    /**
     * This method commits an updated ComponentGrainEntity object to the database
     * @param componentGrainEntity the componentGrainEntity object that should be updated in the databse
     */
    public void updateComponentGrainEntity(ComponentGrainEntity componentGrainEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentGrainEntity);
            tx.commit();
            log.warn("Updated component: " + componentGrainEntity + " with id of: " + componentGrainEntity.getCompGrainId());

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
     * This method deletes the ComponentGrainEntity object from the database
     * @param componentGrainEntity the componentGrainEntity to be deleted from the database
     */
    public void deleteComponentGrainEntity(ComponentGrainEntity componentGrainEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentGrainEntity);
            tx.commit();
            log.warn("Deleted component: " + componentGrainEntity + " with id of: " + componentGrainEntity.getCompGrainId());

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
     * This method adds an componentGrainEntity to the database and returns the ID associated with the new record
     * @param componentGrainEntity the componentGrainEntity to be added to the database
     * @return int the componentGrainEntity ID of the added record
     */
    public int addComponentGrainEntity(ComponentGrainEntity componentGrainEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentGrainEntityId = null;

        try {
            tx = session.beginTransaction();
            componentGrainEntityId = (Integer) session.save(componentGrainEntity);
            tx.commit();
            log.warn("Added component: " + componentGrainEntity + " with id of: " + componentGrainEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentGrainEntityId;

    }

}
