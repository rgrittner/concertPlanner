package persistence;

import entity.Composition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Composition> instrumentList = genericDao.getAll();
        assertEquals(5, instrumentList.size());
    }

    /**
     *  Verify successful insert of category.
     */
    @Test
    void insertSuccess() {

        Composition newCategory = new Composition("title", "arranger", 10, 2019, 4, "notes", true, 1);
        int id = genericDao.insert(newCategory);
        assertNotEquals(0, id);
        Composition insertedCategory = (Composition) genericDao.getById(id);
        assertEquals(newCategory, insertedCategory);
    }
}
