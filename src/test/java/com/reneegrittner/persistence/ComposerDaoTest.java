package com.reneegrittner.persistence;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComposerDaoTest {
    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Set up.
     * Reset the Composer table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
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

        Composer newComposer = new Composer("New", "Musician", 1912, 1983, nationality);
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

        List<Composer> composerList = genericDao.getAll("lastName");
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
        List<Composer> composers = genericDao.getByPropertyEqual("lastName", "Cage");
        assertEquals(1, composers.size());

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


    @Test
    void deleteExceptionTesting() {
        Throwable exception = assertThrows(PersistenceException.class, () -> {
            genericDao.delete(genericDao.getById(1));
        });
        assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", exception.getMessage());
    }
}
