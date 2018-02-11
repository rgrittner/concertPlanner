package persistence;


import entity.Musician;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class MusicianDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Musician getById(int id){
        Session session = sessionFactory.openSession();
        Musician nationality = session.get(Musician.class, id);
        session.close();
        return nationality;

    }

    public List<Musician> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Musician> query = builder.createQuery(Musician.class);
        Root<Musician> root = query.from(Musician.class);
        List<Musician> nationalities = session.createQuery(query).getResultList();
        session.close();
        return nationalities;
    }

    public List<Musician> getByPropertyEqual(String propertyName, String value){
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Musician> query = builder.createQuery(Musician.class);
        Root<Musician> root = query.from(Musician.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Musician> musicians = session.createQuery(query).getResultList();
        return musicians;
    }

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
}
