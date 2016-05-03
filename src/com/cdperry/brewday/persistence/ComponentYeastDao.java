package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentYeastEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentYeastDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentYeastEntity objects
     * @return List<ComponentYeastEntity> a list of ComponentYeastEntity objects
     */
    public List<ComponentYeastEntity> getAllComponentYeasts() {

        List<ComponentYeastEntity> componentYeasts = new ArrayList<ComponentYeastEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentYeasts = session.createQuery("FROM ComponentYeastEntity ORDER BY compYeastId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentYeasts;

    }

    /**
     * This method returns a componentYeastEntity from the database when passed an appropriate componentYeastEntity ID
     * @param componentYeastEntityId the componentYeastEntity to be retrieved from the database
     * @return ComponentYeastEntity an ComponentYeastEntity object representing the componentYeastEntity retrieved from the database
     */
    public ComponentYeastEntity getComponentYeastEntity(int componentYeastEntityId) {

        ComponentYeastEntity componentYeastEntity = new ComponentYeastEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentYeastEntity = (ComponentYeastEntity)session.get(ComponentYeastEntity.class, componentYeastEntityId);
            tx.commit();
            if (componentYeastEntity != null) {
                log.warn("Retrieved yeast component: " + componentYeastEntity + " with id of: " + componentYeastEntity.getCompYeastId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentYeastEntity;

    }

    /**
     * This method commits an updated ComponentYeastEntity object to the database
     * @param componentYeastEntity the componentYeastEntity object that should be updated in the databse
     */
    public void updateComponentYeastEntity(ComponentYeastEntity componentYeastEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentYeastEntity);
            tx.commit();
            log.warn("Updated yeast component: " + componentYeastEntity + " with id of: " + componentYeastEntity.getCompYeastId());

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
     * This method deletes the ComponentYeastEntity object from the database
     * @param componentYeastEntity the componentYeastEntity to be deleted from the database
     */
    public void deleteComponentYeastEntity(ComponentYeastEntity componentYeastEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentYeastEntity);
            tx.commit();
            log.warn("Deleted yeast component: " + componentYeastEntity + " with id of: " + componentYeastEntity.getCompYeastId());

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
     * This method deletes the ComponentYeastEntity object from the database
     * @param componentYeastId the ID of the componentYeastEntity to be deleted from the database
     */
    public void deleteComponentYeastEntityById(int componentYeastId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            ComponentYeastEntity entityToDelete = (ComponentYeastEntity)session.get(ComponentYeastEntity.class, componentYeastId);
            session.delete(entityToDelete);
            tx.commit();
            log.warn("Deleted yeast type: " + entityToDelete + " with id of: " + componentYeastId);

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
     * This method adds an componentYeastEntity to the database and returns the ID associated with the new record
     * @param componentYeastEntity the componentYeastEntity to be added to the database
     * @return int the componentYeastEntity ID of the added record
     */
    public int addComponentYeastEntity(ComponentYeastEntity componentYeastEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentYeastEntityId = null;

        try {
            tx = session.beginTransaction();
            componentYeastEntityId = (Integer) session.save(componentYeastEntity);
            tx.commit();
            log.warn("Added yeast component: " + componentYeastEntity + " with id of: " + componentYeastEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentYeastEntityId;

    }

}
