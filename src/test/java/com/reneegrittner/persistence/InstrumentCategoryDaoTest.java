package com.reneegrittner.persistence;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.util.DatabaseTwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CRUD test class for Instrument_Category table
 * @author Renee Grittner
 */
public class InstrumentCategoryDaoTest {


    private GenericDao<InstrumentCategory> genericDao;

    /**
     * Set up.
     * Reset the Instrument_Category table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");


        genericDao = new GenericDao<>(InstrumentCategory.class);
    }

    /**
     * Verify successful retrieval of all categories.
     */
    @Test
    void getAllSuccess(){
        List<InstrumentCategory> instrumentCategoryList = genericDao.getAll(1);
        assertEquals(6, instrumentCategoryList.size());
    }

    /**
     * Verify successful retrieval by id.
     */
    @Test
    void getByIdSuccess(){
        InstrumentCategory retrievedCategory =  genericDao.getById(4);
        assertEquals("Metals", retrievedCategory.getCategory());
    }

    /**
     *  Verify successful insert of category.
     */
    @Test
    void insertSuccess() {
        InstrumentCategory newCategory = new InstrumentCategory("Test");
        int id = genericDao.insert(newCategory);
        assertNotEquals(0, id);
        InstrumentCategory insertedCategory = genericDao.getById(id);
        assertEquals(newCategory, insertedCategory);
    }


    /**
     *  Verify successful insert of instrument category with Instrument.
     */
    @Test
    void insertWithInstrumentSuccess() {
        InstrumentCategory newInstrumentCategory = new InstrumentCategory("Bananas");

        Instrument instrument = new Instrument("New Instrument", newInstrumentCategory, 1);

        newInstrumentCategory.addInstrument(instrument);

        int id = genericDao.insert(newInstrumentCategory);
        assertNotEquals(0, id);
        InstrumentCategory insertedInstrumentCategory =  genericDao.getById(id);
        assertEquals(newInstrumentCategory, insertedInstrumentCategory);

    }


    /**
     * Verify successful save or update of instrument category
     */
    @Test
    void saveOrUpdateSuccess(){
        String newCategory = "testing";
        InstrumentCategory categoryToUpdate =  genericDao.getById(6);
        categoryToUpdate.setCategory(newCategory);
        genericDao.saveOrUpdate(categoryToUpdate);
        InstrumentCategory retrievedInstrumentCategory =  genericDao.getById(6);
        assertEquals(categoryToUpdate, retrievedInstrumentCategory);
    }

    /**
     * Verify successful delete of category
     */
    @Test
    void deleteItemWithNoFKConstraintSuccess(){
        InstrumentCategory newCategory = new InstrumentCategory("Test");
        int id = genericDao.insert(newCategory);
        genericDao.delete(genericDao.getById(id));
        assertNull(genericDao.getById(id));
    }

    @Test
    void deleteExceptionTesting() {
        Throwable exception = assertThrows(PersistenceException.class, () -> {
            genericDao.delete(genericDao.getById(1));
        });
        assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", exception.getMessage());
    }


}
