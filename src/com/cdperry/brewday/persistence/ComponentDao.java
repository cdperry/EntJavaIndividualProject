package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentEntity;
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
public class ComponentDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentEntity objects
     * @return List<ComponentEntity> a list of ComponentEntity objects
     */
    public List<ComponentEntity> getAllComponentGrains() {

        List<ComponentEntity> componentGrains = new ArrayList<ComponentEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentGrains = session.createQuery("FROM ComponentEntity ORDER BY componentId").list();
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
     * This method returns a componentEntity from the database when passed an appropriate componentEntity ID
     * @param componentEntityId the componentEntity to be retrieved from the database
     * @return ComponentEntity an ComponentEntity object representing the componentEntity retrieved from the database
     */
    public ComponentEntity getComponentEntity(int componentEntityId) {

        ComponentEntity componentEntity = new ComponentEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentEntity = (ComponentEntity)session.get(ComponentEntity.class, componentEntityId);
            tx.commit();
            if (componentEntity != null) {
                log.warn("Retrieved component: " + componentEntity + " with id of: " + componentEntity.getComponentId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentEntity;

    }

    /**
     * This method commits an updated ComponentEntity object to the database
     * @param componentEntity the componentEntity object that should be updated in the databse
     */
    public void updateComponentEntity(ComponentEntity componentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentEntity);
            tx.commit();
            log.warn("Updated component: " + componentEntity + " with id of: " + componentEntity.getComponentId());

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
     * This method deletes the ComponentEntity object from the database
     * @param componentEntity the componentEntity to be deleted from the database
     */
    public void deleteComponentEntity(ComponentEntity componentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentEntity);
            tx.commit();
            log.warn("Deleted component: " + componentEntity + " with id of: " + componentEntity.getComponentId());

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
     * This method adds an componentEntity to the database and returns the ID associated with the new record
     * @param componentEntity the componentEntity to be added to the database
     * @return int the componentEntity ID of the added record
     */
    public int addComponentEntity(ComponentEntity componentEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentEntityId = null;

        try {
            tx = session.beginTransaction();
            componentEntityId = (Integer) session.save(componentEntity);
            tx.commit();
            log.warn("Added component: " + componentEntity + " with id of: " + componentEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentEntityId;

    }
    
}
