package persistence;

import entity.Musician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicianDaoTest {
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

    @Test
    void getByPropertyEqualOnLastNameSuccess(){
        List<Musician> musicians = dao.getByPropertyEqual("lastName", "Kleve");
        assertEquals(1, musicians.size());
        assertEquals(1, musicians.get(0).getId());

    }

    @Test
    void getByPropertyLikeOnLastNameSuccess(){
        List<Musician> musicians = dao.getByPropertyLike("lastName", "e");
        assertEquals(4, musicians.size());
    }
}
