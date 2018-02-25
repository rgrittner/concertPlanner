package persistence;

import entity.Composer;
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
        List<Composition> compositionList = genericDao.getAll();
        assertEquals(5, compositionList.size());
    }

    /**
     *  Verify successful insert of category.
     */
    @Test
    void insertSuccess() {

        GenericDao localDao = new GenericDao(Composer.class);
        Composer composer = (Composer) localDao.getById(2);

        Composition newComposition = new Composition("Prelude", null, 10, 2010, 4, null, true, composer);
        composer.addComposition(newComposition);

        int id = genericDao.insert(newComposition);
        assertNotEquals(0, id);
        Composition insertedCompositon = (Composition) genericDao.getById(id);
        assertEquals(newComposition, insertedCompositon);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Composition> compositions = genericDao.getByPropertyEqual("title", "Gravity");
        assertEquals(1, compositions.size());
        assertEquals(1, compositions.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyEqualIntegerSuccess() {
        Integer value = 4;
        List<Composition> compositions = genericDao.getByPropertyEqual("numberOfPlayers", value);
        assertEquals(4, compositions.size());
    }
}
