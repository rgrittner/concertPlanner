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
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll(String columnToOrderOn, int userId) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.where(builder
                .equal(root.get("userId"), userId))
                .orderBy(builder.asc(root.get(columnToOrderOn)));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public List<T> getAll(int userId) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.where(builder.equal(root.get("userId"), userId));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public List<T> getAllUsers() {
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
    public List<T> getByPropertyEqual(String propertyName, Object value, int userId){
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.and(builder.equal(root.get(propertyName), value)), builder.equal(root.get("userId"), userId));
        List<T> list = session.createQuery(query).getResultList();

        return list;
    }

    public List<T> getUser(String propertyName, Object value){
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> listOfUsers = session.createQuery(query).getResultList();

        return listOfUsers;
    }

//    public List<T> getByPropertyEqualComposition(Object value){
//        Session session = getSession();
//
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<T> query = builder.createQuery(type);
//        Root<T> root = query.from(type);
//        query.select(root).where(builder.equal(root.get("composer"), value));
//
//        List<T> list = session.createQuery(query).getResultList();
//        return list;
//    }

    public List<T> getByPropertyEqualCompositionInstrument(Object playerNumber, Object compositionId, int userId){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get("composition"), compositionId)
                        , builder.equal(root.get("playerNumber"), playerNumber)
                        , builder.equal(root.get("userId"), userId)));
        //https://stackoverflow.com/questions/46449407/how-to-use-and-in-hibernate-5-2-criteria
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
    public List<T> getByPropertyLike(String propertyName, String value, int userId) {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(
                builder.and(
                    builder.equal(root.get("userId"), userId),
                    builder.like(propertyPath, "%" + value + "%")));
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
