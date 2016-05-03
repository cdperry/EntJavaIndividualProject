package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentOtherEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentOtherDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentOtherEntity objects
     * @return List<ComponentOtherEntity> a list of ComponentOtherEntity objects
     */
    public List<ComponentOtherEntity> getAllComponentOthers() {

        List<ComponentOtherEntity> componentOthers = new ArrayList<ComponentOtherEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentOthers = session.createQuery("FROM ComponentOtherEntity ORDER BY compOtherId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentOthers;

    }

    /**
     * This method returns a componentOtherEntity from the database when passed an appropriate componentOtherEntity ID
     * @param componentOtherEntityId the componentOtherEntity to be retrieved from the database
     * @return ComponentOtherEntity an ComponentOtherEntity object representing the componentOtherEntity retrieved from the database
     */
    public ComponentOtherEntity getComponentOtherEntity(int componentOtherEntityId) {

        ComponentOtherEntity componentOtherEntity = new ComponentOtherEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentOtherEntity = (ComponentOtherEntity)session.get(ComponentOtherEntity.class, componentOtherEntityId);
            tx.commit();
            if (componentOtherEntity != null) {
                log.warn("Retrieved other component: " + componentOtherEntity + " with id of: " + componentOtherEntity.getCompOtherId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentOtherEntity;

    }

    /**
     * This method commits an updated ComponentOtherEntity object to the database
     * @param componentOtherEntity the componentOtherEntity object that should be updated in the databse
     */
    public void updateComponentOtherEntity(ComponentOtherEntity componentOtherEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentOtherEntity);
            tx.commit();
            log.warn("Updated other component: " + componentOtherEntity + " with id of: " + componentOtherEntity.getCompOtherId());

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
     * This method deletes the ComponentOtherEntity object from the database
     * @param componentOtherEntity the componentOtherEntity to be deleted from the database
     */
    public void deleteComponentOtherEntity(ComponentOtherEntity componentOtherEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentOtherEntity);
            tx.commit();
            log.warn("Deleted other component: " + componentOtherEntity + " with id of: " + componentOtherEntity.getCompOtherId());

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
     * This method deletes the ComponentOtherEntity object from the database
     * @param componentOtherId the ID of the componentOtherEntity to be deleted from the database
     */
    public void deleteComponentOtherEntityById(int componentOtherId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            ComponentOtherEntity entityToDelete = (ComponentOtherEntity)session.get(ComponentOtherEntity.class, componentOtherId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted other type: " + entityToDelete + " with id of: " + componentOtherId);

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
     * This method adds an componentOtherEntity to the database and returns the ID associated with the new record
     * @param componentOtherEntity the componentOtherEntity to be added to the database
     * @return int the componentOtherEntity ID of the added record
     */
    public int addComponentOtherEntity(ComponentOtherEntity componentOtherEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentOtherEntityId = null;

        try {
            tx = session.beginTransaction();
            componentOtherEntityId = (Integer) session.save(componentOtherEntity);
            tx.commit();
            log.warn("Added other component: " + componentOtherEntity + " with id of: " + componentOtherEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentOtherEntityId;

    }

}
