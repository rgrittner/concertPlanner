package persistence;


import entity.Musician;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * CRUD for Musician class.
 * @author Renee Grittner
 */
public class MusicianDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get by id musician.
     *
     * @param id the id
     * @return the musician
     */
    public Musician getById(int id){
        Session session = sessionFactory.openSession();
        Musician nationality = session.get(Musician.class, id);
        session.close();
        return nationality;

    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Musician> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Musician> query = builder.createQuery(Musician.class);
        Root<Musician> root = query.from(Musician.class);
        List<Musician> nationalities = session.createQuery(query).getResultList();
        session.close();
        return nationalities;
    }

    /**
     * Get by property equal list.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the list
     */
    public List<Musician> getByPropertyEqual(String propertyName, String value){
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Musician> query = builder.createQuery(Musician.class);
        Root<Musician> root = query.from(Musician.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Musician> musicians = session.createQuery(query).getResultList();
        return musicians;
    }

    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<Musician> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for musician with {} = {}", propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Musician> query = builder.createQuery(Musician.class);
        Root<Musician> root = query.from(Musician.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Musician> musicians = session.createQuery(query).getResultList();
        session.close();
        return musicians;
    }

    /**
     * Save or update.
     *
     * @param musicianToUpdate the musician to update
     */
    @SuppressWarnings("Duplicates")
    public void saveOrUpdate(Musician musicianToUpdate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(musicianToUpdate);
        transaction.commit();
        session.close();
    }


    /**
     * Delete.
     *
     * @param musicianToDelete the musician to delete
     */
    @SuppressWarnings("Duplicates")
    public void delete(Musician musicianToDelete) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(musicianToDelete);
        transaction.commit();
        session.close();
    }
}
