package com.reneegrittner.persistence;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CompositionInstrumentDaoTest {
    private GenericDao<CompositionInstrument> genericDao;
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
    private GenericDao<Instrument> instrumentGenericDao = new GenericDao<>(Instrument.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Set up.
     * Reset the Composer table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao<>(CompositionInstrument.class);
    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){

        List<CompositionInstrument> compositionInstruments = genericDao.getAll(1);
        assertEquals(4, compositionInstruments.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        CompositionInstrument retrievedCompositionInstrument =  genericDao.getById(3);
        assertEquals("Mellits", retrievedCompositionInstrument.getComposition().getComposer().getLastName());
        assertEquals(3, retrievedCompositionInstrument.getPlayerNumber());
        assertEquals(1, retrievedCompositionInstrument.getInstrumentQuantity());

    }

    @Test
    void getInstrumentsOfCompositionByPlayer(){
       List<CompositionInstrument> instruments = genericDao.getByPropertyEqualCompositionInstrument(1, 1, 1);
       assertEquals(1, instruments.size());

    }

    @Test
    void deleteInstrumentFromLinkingTableDoesNotDeleteCompositionOrInstrument(){
        Instrument instrument =  instrumentGenericDao.getById(2);
        Composition composition = compositionGenericDao.getById(1);

        CompositionInstrument newInstrumentForComposition = new CompositionInstrument(2, 1, instrument, composition, 1);

        int id = genericDao.insert(newInstrumentForComposition);
        assertEquals(5, id);

        genericDao.delete(newInstrumentForComposition);

        assertNull(genericDao.getById(id));

        assertEquals(instrument, instrumentGenericDao.getById(2));
        assertEquals(composition, compositionGenericDao.getById(1));
    }



}
