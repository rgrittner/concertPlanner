package persistence;

import entity.Composer;
import entity.Nationality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ComposerDaoTest {
    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanAll.sql");

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
        Composer insertedComposer = (Composer) genericDao.getById(id);
        assertEquals(newComposer, insertedComposer);
        //assertEquals("Musician", insertedMusician.getLastName());

    }



    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Composer> composerList = genericDao.getAll();
        assertEquals(6, composerList.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        Composer retrievedComposer = (Composer) genericDao.getById(3);
        assertEquals("John", retrievedComposer.getFirstName());
        assertEquals("Cage", retrievedComposer.getLastName());
        //assertEquals(1, retrievedComposer.getNationality());
    }

    /**
     * Verify successful save or update of Composer
     */
    @Test
    void saveOrUpdateBirthYearSuccess(){
        Integer newBirthYear = 1976;
        Composer composerToUpdate = (Composer) genericDao.getById(4);
        composerToUpdate.setBirthYear(newBirthYear);
        genericDao.saveOrUpdate(composerToUpdate);
        Composer retrievedComposer = (Composer) genericDao.getById(4);
        assertEquals(newBirthYear, retrievedComposer.getBirthYear());
    }


    /**
     * Verify successful delete of nationality
     */
    @Test
    void deleteSuccess(){
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }
}
