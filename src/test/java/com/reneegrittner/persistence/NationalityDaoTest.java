package com.reneegrittner.persistence;


import com.reneegrittner.entity.Composition;
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

    private GenericDao<Nationality> genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");
        genericDao = new GenericDao<>(Nationality.class);

    }

    /**
     * Verify successful retrieval by id.
     */
    @Test
    void getByIdSuccess(){
        Nationality retrievedNationality = genericDao.getById(1);
        assertEquals("American", retrievedNationality.getNationality());
    }

    /**
     * Verify successful retrieval of all nationalities.
     */
    @Test
    void getAllSuccess(){
        List<Nationality> nationalityList = genericDao.getAll(1);
        assertEquals(3, nationalityList.size());
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {
        Nationality newNationality = new Nationality("English", 1);
        int id = genericDao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality =  genericDao.getById(id);
        assertEquals(newNationality, insertedNationality);
    }


    /**
     *  Verify successful insert of nationality with Composer.
     */
    @Test
    void insertWithComposerSuccess() {
        Nationality newNationality = new Nationality("English", 1);

        Composer composer = new Composer("New", "Musician", 1912, 1983, 1, newNationality);

        newNationality.addComposer(composer);

        int id = genericDao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality =  genericDao.getById(id);
        assertEquals(newNationality, insertedNationality);
        assertEquals(1, insertedNationality.getComposers().size());
    }

    /**
     * Verify successful save or update of nationality
     */
    @Test
    void saveOrUpdateSuccess(){
        String newNationality = "testing";
        Nationality nationalityToUpdate =  genericDao.getById(2);
        nationalityToUpdate.setNationality(newNationality);
        genericDao.saveOrUpdate(nationalityToUpdate);
        Nationality retrievedNationality =  genericDao.getById(2);
        assertEquals(nationalityToUpdate, retrievedNationality);
    }





}
