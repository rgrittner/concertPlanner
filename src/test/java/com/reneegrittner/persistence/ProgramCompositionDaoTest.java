package com.reneegrittner.persistence;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.Musician;
import com.reneegrittner.entity.Program;
import com.reneegrittner.entity.ProgramComposition;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramCompositionDaoTest {
    private GenericDao<ProgramComposition> genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Set up.
     * Reset the Composer table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao<>(ProgramComposition.class);
    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){

        List<ProgramComposition> programCompositions = genericDao.getAll(1);
        assertEquals(4, programCompositions.size());
    }

    @Test
    void insertNewProgramCompositionMusician() {
        GenericDao<Musician> musicianGenericDao = new GenericDao<>(Musician.class);
        GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
        GenericDao<Program> programGenericDao = new GenericDao<>(Program.class);

        Musician musicianToInsert =  musicianGenericDao.getById(1);
        Composition compositionToInsert =  compositionGenericDao.getById(1);
        Program programToInsert =  programGenericDao.getById(1);

        ProgramComposition toInsertIntoLinkingTable = new ProgramComposition(1, musicianToInsert, programToInsert, compositionToInsert, 1);

        genericDao.insert(toInsertIntoLinkingTable);

        assertEquals(5, genericDao.getAll(1).size());

    }
}
