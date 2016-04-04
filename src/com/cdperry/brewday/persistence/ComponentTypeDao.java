package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentTypeEntity;
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
public class ComponentTypeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentTypeEntity objects
     * @return List<ComponentTypeEntity> a list of ComponentTypeEntity objects
     */
    public List<ComponentTypeEntity> getAllComponentGrains() {

        List<ComponentTypeEntity> componentGrains = new ArrayList<ComponentTypeEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentGrains = session.createQuery("FROM ComponentTypeEntity ORDER BY componentTypeId").list();
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
     * This method returns a componentTypeEntity from the database when passed an appropriate componentTypeEntity ID
     * @param componentTypeEntityId the componentTypeEntity to be retrieved from the database
     * @return ComponentTypeEntity an ComponentTypeEntity object representing the componentTypeEntity retrieved from the database
     */
    public ComponentTypeEntity getComponentTypeEntity(int componentTypeEntityId) {

        ComponentTypeEntity componentTypeEntity = new ComponentTypeEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentTypeEntity = (ComponentTypeEntity)session.get(ComponentTypeEntity.class, componentTypeEntityId);
            tx.commit();
            if (componentTypeEntity != null) {
                log.warn("Retrieved component: " + componentTypeEntity + " with id of: " + componentTypeEntity.getComponentTypeId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentTypeEntity;

    }

    /**
     * This method commits an updated ComponentTypeEntity object to the database
     * @param componentTypeEntity the componentTypeEntity object that should be updated in the databse
     */
    public void updateComponentTypeEntity(ComponentTypeEntity componentTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentTypeEntity);
            tx.commit();
            log.warn("Updated component: " + componentTypeEntity + " with id of: " + componentTypeEntity.getComponentTypeId());

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
     * This method deletes the ComponentTypeEntity object from the database
     * @param componentTypeEntity the componentTypeEntity to be deleted from the database
     */
    public void deleteComponentTypeEntity(ComponentTypeEntity componentTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentTypeEntity);
            tx.commit();
            log.warn("Deleted component: " + componentTypeEntity + " with id of: " + componentTypeEntity.getComponentTypeId());

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
     * This method adds an componentTypeEntity to the database and returns the ID associated with the new record
     * @param componentTypeEntity the componentTypeEntity to be added to the database
     * @return int the componentTypeEntity ID of the added record
     */
    public int addComponentTypeEntity(ComponentTypeEntity componentTypeEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentTypeEntityId = null;

        try {
            tx = session.beginTransaction();
            componentTypeEntityId = (Integer) session.save(componentTypeEntity);
            tx.commit();
            log.warn("Added component: " + componentTypeEntity + " with id of: " + componentTypeEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentTypeEntityId;

    }
    
}
