package com.reneegrittner.persistence;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.reneegrittner.util.DatabaseTwo;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CRUD implementation for the Nationality class.
 */
public class NationalityDaoTest {
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
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");


        genericDao = new GenericDao(Nationality.class);
    }

    /**
     * Verify successful retrieval by id.
     */
    @Test
    void getByIdSuccess(){
        Nationality retrievedNationality = (Nationality) genericDao.getById(1);
        assertEquals("American", retrievedNationality.getNationality());
    }

    /**
     * Verify successful retrieval of all nationalities.
     */
    @Test
    void getAllSuccess(){
        List<Nationality> nationalityList = genericDao.getAll();
        assertEquals(3, nationalityList.size());
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {
        Nationality newNationality = new Nationality("English");
        int id = genericDao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality = (Nationality) genericDao.getById(id);
        assertEquals(newNationality, insertedNationality);
    }


    /**
     *  Verify successful insert of nationality with Composer.
     */
    @Test
    void insertWithComposerSuccess() {
        Nationality newNationality = new Nationality("English");

        Composer composer = new Composer("New", "Musician", 1912, 1983, newNationality);

        newNationality.addComposer(composer);

        int id = genericDao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality = (Nationality) genericDao.getById(id);
        assertEquals(newNationality, insertedNationality);
        assertEquals(1, insertedNationality.getComposers().size());
    }

    /**
     * Verify successful save or update of nationality
     */
    @Test
    void saveOrUpdateSuccess(){
        String newNationality = "testing";
        Nationality nationalityToUpdate = (Nationality) genericDao.getById(2);
        nationalityToUpdate.setNationality(newNationality);
        genericDao.saveOrUpdate(nationalityToUpdate);
        Nationality retrievedNationality = (Nationality) genericDao.getById(2);
        assertEquals(nationalityToUpdate, retrievedNationality);
    }


    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(PersistenceException.class, () -> {
            genericDao.delete(genericDao.getById(1));
        });
        assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", exception.getMessage());
    }
}
