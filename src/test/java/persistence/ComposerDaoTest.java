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
     * Reset the Composer table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao(Composer.class);
    }

    /**
     *  Verify successful insert of composer.
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

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Composer> composers = genericDao.getByPropertyEqual("firstName", "John");
        assertEquals(3, composers.size());
        assertEquals(2, composers.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Composer> composers = genericDao.getByPropertyLike("lastName", "b");
        assertEquals(1, composers.size());
    }


    /**
     * Verify successful save or update of Composer
     */
    @Test
    void saveOrUpdateSuccess(){
        Integer newBirthYear = 1976;
        Composer composerToUpdate = (Composer) genericDao.getById(4);
        composerToUpdate.setBirthYear(newBirthYear);
        genericDao.saveOrUpdate(composerToUpdate);
        Composer retrievedComposer = (Composer) genericDao.getById(4);
        assertEquals(composerToUpdate, retrievedComposer);
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
