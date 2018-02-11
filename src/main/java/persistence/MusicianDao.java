package persistence;


import entity.Musician;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MusicianDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Musician getById(int id){
        Session session = sessionFactory.openSession();
        Musician nationality = session.get(Musician.class, id);
        session.close();
        return nationality;

    }
}
