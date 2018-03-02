package com.reneegrittner.persistence;

import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositionInstrumentDaoTest {
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

        genericDao = new GenericDao(CompositionInstrument.class);
    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){

        List<CompositionInstrument> compositionInstruments = genericDao.getAll();
        assertEquals(4, compositionInstruments.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        CompositionInstrument retrievedCompositionInstrument = (CompositionInstrument) genericDao.getById(3);
        assertEquals("Mellits", retrievedCompositionInstrument.getComposition().getComposer().getLastName());

    }

    @Test
    void getInstrumentListOfACompositionForPlayer4(){
        List<CompositionInstrument> retrievedCompositionInstrument = genericDao.getByTwoPropertyEqual("dummytext", 1, "dummytext", 2);
        assertEquals("Marimba", retrievedCompositionInstrument.get(0).getInstrument().getName());
    }

}
