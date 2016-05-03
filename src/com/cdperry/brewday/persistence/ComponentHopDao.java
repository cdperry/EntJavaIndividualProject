package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentHopEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentHopDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentHopEntity objects
     * @return List<ComponentHopEntity> a list of ComponentHopEntity objects
     */
    public List<ComponentHopEntity> getAllComponentHops() {

        List<ComponentHopEntity> componentHops = new ArrayList<ComponentHopEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentHops = session.createQuery("FROM ComponentHopEntity ORDER BY compHopId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentHops;

    }

    /**
     * This method returns a componentHopEntity from the database when passed an appropriate componentHopEntity ID
     * @param componentHopEntityId the componentHopEntity to be retrieved from the database
     * @return ComponentHopEntity an ComponentHopEntity object representing the componentHopEntity retrieved from the database
     */
    public ComponentHopEntity getComponentHopEntity(int componentHopEntityId) {

        ComponentHopEntity componentHopEntity = new ComponentHopEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentHopEntity = (ComponentHopEntity)session.get(ComponentHopEntity.class, componentHopEntityId);
            tx.commit();
            if (componentHopEntity != null) {
                log.warn("Retrieved hop component: " + componentHopEntity + " with id of: " + componentHopEntity.getCompHopId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentHopEntity;

    }

    /**
     * This method commits an updated ComponentHopEntity object to the database
     * @param componentHopEntity the componentHopEntity object that should be updated in the databse
     */
    public void updateComponentHopEntity(ComponentHopEntity componentHopEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentHopEntity);
            tx.commit();
            log.warn("Updated hop component: " + componentHopEntity + " with id of: " + componentHopEntity.getCompHopId());

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
     * This method deletes the ComponentHopEntity object from the database
     * @param componentHopEntity the componentHopEntity to be deleted from the database
     */
    public void deleteComponentHopEntity(ComponentHopEntity componentHopEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentHopEntity);
            tx.commit();
            log.warn("Deleted hop component: " + componentHopEntity + " with id of: " + componentHopEntity.getCompHopId());

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
     * This method deletes the ComponentHopEntity object from the database
     * @param componentHopId the ID of the componentHopEntity to be deleted from the database
     */
    public void deleteComponentHopEntityById(int componentHopId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            ComponentHopEntity entityToDelete = (ComponentHopEntity)session.get(ComponentHopEntity.class, componentHopId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted hop type: " + entityToDelete + " with id of: " + componentHopId);

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
     * This method adds an componentHopEntity to the database and returns the ID associated with the new record
     * @param componentHopEntity the componentHopEntity to be added to the database
     * @return int the componentHopEntity ID of the added record
     */
    public int addComponentHopEntity(ComponentHopEntity componentHopEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentHopEntityId = null;

        try {
            tx = session.beginTransaction();
            componentHopEntityId = (Integer) session.save(componentHopEntity);
            tx.commit();
            log.warn("Added hop component: " + componentHopEntity + " with id of: " + componentHopEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentHopEntityId;

    }
    
}
