package com.reneegrittner.persistence;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComposerDaoTest {
    private GenericDao<Composer> genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Set up.
     * Reset the Composer table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao<>(Composer.class);
    }

    /**
     *  Verify successful insert of composer.
     */
    @Test
    void insertSuccess() {

        GenericDao<Nationality> localDao = new GenericDao<>(Nationality.class);
        Nationality nationality =  localDao.getById(2);

        Composer newComposer = new Composer("New", "Musician", 1912, 1983, 1, nationality);
        nationality.addComposer(newComposer);

        int id = genericDao.insert(newComposer);
        assertNotEquals(0, id);
        Composer insertedComposer =  genericDao.getById(id);
        assertEquals(newComposer, insertedComposer);

    }


    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){

        List<Composer> composerList = genericDao.getAll("lastName", 1);
        assertEquals(6, composerList.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        Composer retrievedComposer =  genericDao.getById(3);
        assertEquals("John", retrievedComposer.getFirstName());
        assertEquals("Cage", retrievedComposer.getLastName());

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Composer> composers = genericDao.getByPropertyEqual("lastName", "Cage", 1);
        assertEquals(1, composers.size());

    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Composer> composers = genericDao.getByPropertyLike("lastName", "b", 1);
        assertEquals(1, composers.size());
    }


    /**
     * Verify successful save or update of Composer
     */
    @Test
    void saveOrUpdateSuccess(){
        Integer newBirthYear = 1976;
        Composer composerToUpdate =  genericDao.getById(4);
        composerToUpdate.setBirthYear(newBirthYear);
        genericDao.saveOrUpdate(composerToUpdate);
        Composer retrievedComposer =  genericDao.getById(4);
        assertEquals(composerToUpdate, retrievedComposer);
    }


    static class UserTest {

    }
}
