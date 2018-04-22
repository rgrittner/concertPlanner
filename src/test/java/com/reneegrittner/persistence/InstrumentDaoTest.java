package com.reneegrittner.persistence;


import com.reneegrittner.util.DatabaseTwo;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.entity.Instrument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InstrumentDaoTest {
    private GenericDao<Instrument> genericDao;
    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = new DatabaseTwo();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao<>(Instrument.class);
    }

    /**
     *  Verify successful insert of an instrument.
     */
    @Test
    void insertSuccess() {

        GenericDao<InstrumentCategory> localDao = new GenericDao<>(InstrumentCategory.class);
        InstrumentCategory instrumentCategory =  localDao.getById(2);

        Instrument anotherInstrument = new Instrument("Instrument", instrumentCategory, 1);

        instrumentCategory.addInstrument(anotherInstrument);

        int id = genericDao.insert(anotherInstrument);
        assertNotEquals(0, id);
        Instrument insertedInstrument =  genericDao.getById(id);
        assertEquals(anotherInstrument, insertedInstrument);

    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Instrument> instrumentList = genericDao.getAll(1);
        assertEquals(20, instrumentList.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        Instrument retrievedComposer = (Instrument) genericDao.getById(3);
        assertEquals("Marimba - Quarter Tone", retrievedComposer.getName());


    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {

        List<Instrument> instruments = genericDao.getByPropertyEqual("name", "Marimba", 1);
        assertEquals(1, instruments.size());
        assertEquals(1, instruments.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Instrument> instruments = genericDao.getByPropertyLike("name", "marimba", 1);
        assertEquals(2, instruments.size());
    }



    /**
     * Verify successful save or update of Instrument
     */
    @Test
    void saveOrUpdateSuccess(){
        String newInstrumentName = "TaDa!";
        Instrument instrumentToUpdate =  genericDao.getById(4);
        instrumentToUpdate.setName(newInstrumentName);
        genericDao.saveOrUpdate(instrumentToUpdate);
        Instrument retrievedInstrument =  genericDao.getById(4);
        assertEquals(instrumentToUpdate, retrievedInstrument);
    }

    @Test
    void saveOrUpdateCategorySuccess(){
        GenericDao<InstrumentCategory> categoryGenericDao = new GenericDao<>(InstrumentCategory.class);
        InstrumentCategory newInstrumentCategory = categoryGenericDao.getById(2);
        Instrument instrumentToUpdate =  genericDao.getById(4);
        instrumentToUpdate.setInstrumentCategory(newInstrumentCategory);
        genericDao.saveOrUpdate(instrumentToUpdate);
        Instrument retrievedInstrument =  genericDao.getById(4);
        assertEquals(instrumentToUpdate, retrievedInstrument);
    }

//    /**
//     * Verify unable to delete an Instrument with a dependency.
//     */
//    @Test
//    void deleteExceptionTesting() {
//        Throwable exception = assertThrows(PersistenceException.class, () -> {
//            genericDao.delete(genericDao.getById(1));
//        });
//        assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", exception.getMessage());
//    }
}
