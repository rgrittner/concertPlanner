package com.reneegrittner.persistence;

import com.reneegrittner.util.DatabaseTwo;
import com.reneegrittner.entity.Musician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Musician dao test.
 */
public class MusicianDaoTest {
    /**
     * The Dao.
     */

    private GenericDao<Musician> genericDao;

    /**
     * Set up.
     * Reset the Musician table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");


        genericDao = new GenericDao<>(Musician.class);
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {
        Musician newMusician = new Musician("New", "Musician", "123-125-3456", "new@newEmail.com", "Active", 1);
        int id = genericDao.insert(newMusician);
        assertNotEquals(0, id);
        Musician insertedMusician =  genericDao.getById(id);
        assertEquals(newMusician, insertedMusician);
    }

    /**
     * Verify successful retrieval of musician by id.
     */
    @Test
    void getByIdSuccess(){
        Musician retrievedMusician = genericDao.getById(1);
        assertEquals("Sean", retrievedMusician.getFirstName());
        assertEquals("Kleve", retrievedMusician.getLastName());
        assertEquals("123", retrievedMusician.getPhoneNumber());
        assertEquals("sean@clocksinmotionpercussion.com", retrievedMusician.getEmail());
    }

    /**
     * Verify successful retrieval of all musicians.
     */
    @Test
    void getAllSuccess(){
        List<Musician> MusicianList = genericDao.getAll(1);
        assertEquals(5, MusicianList.size());
    }

    /**
     * Verify successful retrieval of musician searching by property (equal match)
     */
    @Test
    void getByPropertyEqualOnLastNameSuccess(){
        List<Musician> musicians = genericDao.getByPropertyEqual("lastName", "Kleve", 1);
        assertEquals(1, musicians.size());
        assertEquals(1, musicians.get(0).getId());

    }

    /**
     * Verify successful retrieval of musician searching by property (like match)
     */
    @Test
    void getByPropertyLikeOnLastNameSuccess(){
        List<Musician> musicians = genericDao.getByPropertyLike("lastName", "e", 1);
        assertEquals(5, musicians.size());
    }

    /**
     * Verify successful save or update of musician last name
     */
    @Test
    void saveOrUpdateSuccess(){
        String newLastName = "testing";
        Musician musicianToUpdate =  genericDao.getById(2);
        musicianToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(musicianToUpdate);
        Musician retrievedMusician =  genericDao.getById(2);
        assertEquals(musicianToUpdate, retrievedMusician);
    }


}
