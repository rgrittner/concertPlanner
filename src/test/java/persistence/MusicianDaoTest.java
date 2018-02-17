package persistence;

import entity.Musician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Musician dao test.
 */
public class MusicianDaoTest {
    /**
     * The Dao.
     */

    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanMusicianTable.sql");


        genericDao = new GenericDao(Musician.class);
    }

    /**
     * Verify successful retrieval of musician by id.
     */
    @Test
    void getByIdSuccess(){
        Musician retrievedMusician = (Musician)genericDao.getById(1);
        assertEquals("Sean", retrievedMusician.getFirstName());
        assertEquals("Kleve", retrievedMusician.getLastName());
        assertEquals("440-123-1234", retrievedMusician.getPhoneNumber());
    }

    /**
     * Verify successful retrieval of all musicians.
     */
    @Test
    void getAllSuccess(){
        List<Musician> nationalityList = genericDao.getAll();
        assertEquals(4, nationalityList.size());
    }

    /**
     * Verify successful retrieval of musician searching by property (equal match)
     */
    @Test
    void getByPropertyEqualOnLastNameSuccess(){
        List<Musician> musicians = genericDao.getByPropertyEqual("lastName", "Kleve");
        assertEquals(1, musicians.size());
        assertEquals(1, musicians.get(0).getId());

    }

    /**
     * Verify successful retrieval of musician searching by property (like match)
     */
    @Test
    void getByPropertyLikeOnLastNameSuccess(){
        List<Musician> musicians = genericDao.getByPropertyLike("lastName", "e");
        assertEquals(4, musicians.size());
    }

    /**
     * Verify successful save or update of musician last name
     */
    @Test
    void saveOrUpdateSuccess(){
        String newLastName = "testing";
        Musician musicianToUpdate = (Musician) genericDao.getById(2);
        musicianToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(musicianToUpdate);
        Musician retrievedMusician = (Musician) genericDao.getById(2);
        assertEquals(newLastName, retrievedMusician.getLastName());
    }

    /**
     * Verify successful delete of musician
     */
    @Test
    void deleteSuccess(){
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }
}
