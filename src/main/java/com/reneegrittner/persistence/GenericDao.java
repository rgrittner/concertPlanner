package com.reneegrittner.persistence;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.Instrument;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }


    /**
     * Insert a new entity.
     *
     * @param entity the entity to be created
     * @return the newly created id
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        logger.debug("id from DAO: " + id);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public <T>T getById(int id){
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }


    /**
     * Get by property equal list when a String is the value.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the list
     */
    public List<T> getByPropertyEqual(String propertyName, Object value){    /// Try replacing String with Object
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createQuery(query).getResultList();
        return list;
    }



    /**
     * Working on joins --- Starting point
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the list
     */

    /**
     * Currently this method is not really accepting parameters. I'm thinking that eventually it will
     * need one or more objects and the search string(s) for the passed in object(s).
     */
//    public List<T> getByTwoPropertyEqual(String compositionTitle, Integer playerNumber){
//        Session session = getSession();
//        Composition composition = new Composition();
//        composition.getId();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Tuple> query = builder.createQuery(type);
//        Root<T> root = query.from(type);
//        //Root<Instrument> instrument = query.from();
//        //Join<Composition, Object> join =
//
////        query.select(root).where(builder.equal(root.get(""), 1)).where(builder.equal(root.get("playerNumber"), 1));
//        List<T> list = session.createQuery(query).getResultList();
//        return list;
//    }

    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for " + type + " {} = {}", propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }







    /**
     * Save or update.
     *
     * @param entityToUpdate the entity to update
     */
    @SuppressWarnings("Duplicates")
    public void saveOrUpdate(T entityToUpdate) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entityToUpdate);
        transaction.commit();
        session.close();
    }


    /**
     * Delete the entity
     *
     * @param entity the entity to delete
     */
    @SuppressWarnings("Duplicates")
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    private Session getSession(){
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
