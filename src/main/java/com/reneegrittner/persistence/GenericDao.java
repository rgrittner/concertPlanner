package com.reneegrittner.persistence;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    public List<T> getByPropertyEqual(String propertyName, Object value){
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createQuery(query).getResultList();

        logger.debug("list from get By proerty equal after adding join annotation: " + list);
        return list;
    }

    public List<T> getByPropertyEqualComposition(Object value){
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get("composer"), value));
        List<T> list = session.createQuery(query).getResultList();
        return list;
    }

    public List<T> getByPropertyEqualCompositionInstrument(Object playerNumber, Object compositionId){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get("playerNumber"), playerNumber)).having(builder.equal(root.get("composition"), compositionId));
        List<T> list = session.createQuery(query).getResultList();
        return list;
    }




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
