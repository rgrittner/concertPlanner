package persistence;

import entity.Composer;
import entity.Nationality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ComposerDaoTest {
    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanComposerTable.sql");

        genericDao = new GenericDao(Composer.class);
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {

        GenericDao localDao = new GenericDao(Nationality.class);
        Nationality nationality = (Nationality) localDao.getById(2);

        Composer newComposer = new Composer("New", "Musician", nationality);
        nationality.addComposer(newComposer);

        int id = genericDao.insert(newComposer);
        assertNotEquals(0, id);
        Composer insertedMusician = (Composer) genericDao.getById(id);
        assertEquals("New", insertedMusician.getFirstName());
        assertEquals("Musician", insertedMusician.getLastName());

    }



    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Composer> nationalityList = genericDao.getAll();
        assertEquals(3, nationalityList.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        Composer retrievedComposer = (Composer) genericDao.getById(1);
        assertEquals("John", retrievedComposer.getFirstName());
        assertEquals("Cage", retrievedComposer.getLastName());
        //assertEquals(1, retrievedComposer.getNationality());
    }
}
