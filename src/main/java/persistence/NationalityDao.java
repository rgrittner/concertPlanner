package persistence;

import entity.Nationality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *  CRUD controller for the Nationality entity
 *  @author Renee Grittner
 */
public class NationalityDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Nationality getById(int id){
        Session session = sessionFactory.openSession();
        Nationality nationality = session.get(Nationality.class, id);
        session.close();
        return nationality;

    }

    public int insert(Nationality nationality) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(nationality);
        logger.debug("id from DAO: " + id);
        transaction.commit();
        session.close();
        return id;
    }

    public void saveOrUpdate(Nationality nationality) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(nationality);
        transaction.commit();
        session.close();

    }

    public void delete(Nationality nationality) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(nationality);
        transaction.commit();
        session.close();
    }

    public List<Nationality> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Nationality> query = builder.createQuery(Nationality.class);
        Root<Nationality> root = query.from(Nationality.class);
        List<Nationality> nationalities = session.createQuery(query).getResultList();
        session.close();
        return nationalities;
    }
}
