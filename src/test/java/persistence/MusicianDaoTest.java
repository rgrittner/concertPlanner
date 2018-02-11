package persistence;

import entity.Musician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

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
}
