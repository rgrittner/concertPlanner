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
    MusicianDao dao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanMusicianTable.sql");

        dao = new MusicianDao();
    }

    /**
     * Verify successful retrieval of musician by id.
     */
    @Test
    void getByIdSuccess(){
        Musician retrievedMusician = dao.getById(1);
        assertEquals("Sean", retrievedMusician.getFirstName());
        assertEquals("Kleve", retrievedMusician.getLastName());
        assertEquals("440-123-1234", retrievedMusician.getPhoneNumber());
    }

    /**
     * Verify successful retrieval of all musicians.
     */
    @Test
    void getAllSuccess(){
        List<Musician> nationalityList = dao.getAll();
        assertEquals(4, nationalityList.size());
    }

    /**
     * Verify successful retrieval of musician searching by property (equal match)
     */
    @Test
    void getByPropertyEqualOnLastNameSuccess(){
        List<Musician> musicians = dao.getByPropertyEqual("lastName", "Kleve");
        assertEquals(1, musicians.size());
        assertEquals(1, musicians.get(0).getId());

    }

    /**
     * Verify successful retrieval of musician searching by property (like match)
     */
    @Test
    void getByPropertyLikeOnLastNameSuccess(){
        List<Musician> musicians = dao.getByPropertyLike("lastName", "e");
        assertEquals(4, musicians.size());
    }

    /**
     * Verify successful save or update of musician
     */
    @Test
    void saveOrUpdateSuccess(){
        String newLastName = "testing";
        Musician musicianToUpdate = dao.getById(2);
        musicianToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(musicianToUpdate);
        Musician retrievedMusician = dao.getById(2);
        assertEquals(newLastName, retrievedMusician.getLastName());
    }

    /**
     * Verify successful delete of musician
     */
    @Test
    void deleteSuccess(){
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
}
