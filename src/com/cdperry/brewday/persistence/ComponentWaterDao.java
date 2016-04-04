package com.cdperry.brewday.persistence;

import com.cdperry.brewday.entity.ComponentWaterEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdperry on 4/3/16.
 */
public class ComponentWaterDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method returns a List of all ComponentWaterEntity objects
     * @return List<ComponentWaterEntity> a list of ComponentWaterEntity objects
     */
    public List<ComponentWaterEntity> getAllComponentWaters() {

        List<ComponentWaterEntity> componentWaters = new ArrayList<ComponentWaterEntity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentWaters = session.createQuery("FROM ComponentWaterEntity ORDER BY compWaterId").list();
            tx.commit();

        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentWaters;

    }

    /**
     * This method returns a componentWaterEntity from the database when passed an appropriate componentWaterEntity ID
     * @param componentWaterEntityId the componentWaterEntity to be retrieved from the database
     * @return ComponentWaterEntity an ComponentWaterEntity object representing the componentWaterEntity retrieved from the database
     */
    public ComponentWaterEntity getComponentWaterEntity(int componentWaterEntityId) {

        ComponentWaterEntity componentWaterEntity = new ComponentWaterEntity();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            componentWaterEntity = (ComponentWaterEntity)session.get(ComponentWaterEntity.class, componentWaterEntityId);
            tx.commit();
            if (componentWaterEntity != null) {
                log.warn("Retrieved component: " + componentWaterEntity + " with id of: " + componentWaterEntity.getCompWaterId());
            }
        } catch (HibernateException e) {

            if (tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();

        }

        return componentWaterEntity;

    }

    /**
     * This method commits an updated ComponentWaterEntity object to the database
     * @param componentWaterEntity the componentWaterEntity object that should be updated in the databse
     */
    public void updateComponentWaterEntity(ComponentWaterEntity componentWaterEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(componentWaterEntity);
            tx.commit();
            log.warn("Updated component: " + componentWaterEntity + " with id of: " + componentWaterEntity.getCompWaterId());

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
     * This method deletes the ComponentWaterEntity object from the database
     * @param componentWaterEntity the componentWaterEntity to be deleted from the database
     */
    public void deleteComponentWaterEntity(ComponentWaterEntity componentWaterEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.delete(componentWaterEntity);
            tx.commit();
            log.warn("Deleted component: " + componentWaterEntity + " with id of: " + componentWaterEntity.getCompWaterId());

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
     * This method adds an componentWaterEntity to the database and returns the ID associated with the new record
     * @param componentWaterEntity the componentWaterEntity to be added to the database
     * @return int the componentWaterEntity ID of the added record
     */
    public int addComponentWaterEntity(ComponentWaterEntity componentWaterEntity) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer componentWaterEntityId = null;

        try {
            tx = session.beginTransaction();
            componentWaterEntityId = (Integer) session.save(componentWaterEntity);
            tx.commit();
            log.warn("Added component: " + componentWaterEntity + " with id of: " + componentWaterEntityId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return componentWaterEntityId;

    }

}
