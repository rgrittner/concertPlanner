package persistence;

import entity.Composition;
import org.junit.jupiter.api.BeforeEach;
import util.Database;

public class CompositionDaoTest {
    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao(Composition.class);
    }
}
