package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.persistence.GenericDao;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComposerLogicTest {
    private GenericDao<Composer> genericDao;
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
    private ComposerLogic composerLogic = new ComposerLogic();
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

    @Test
    void addComposer() {

        Composer composer = composerLogic.createComposer("firstName", "lastName", "123", "123", "1", null,1);
        assertEquals("firstName", composer.getFirstName());
        Integer year = 123;
        assertEquals(year, composer.getBirthYear());
        assertEquals(year, composer.getDeathYear());
        assertEquals("American", composer.getNationality().getNationality());
        assertEquals(1, composer.getUserId());

    }

    @Test
    void listOfCompositionsForThisComposerReturnsWithItems(){
        List<Composition> compositionsForComposer  = compositionGenericDao.getByPropertyEqual("composer", 1, 1);
        assertEquals(2, compositionsForComposer.size());
    }

    @Test
    void listOfCompositionsForThisComposerReturnsWithANoItems(){
        List<Composition> compositionsForComposer  = compositionGenericDao.getByPropertyEqual("composer", 6, 1);
        assertEquals(0, compositionsForComposer.size());
    }

    @Test
    void composerHasDependentCompositions(){
        boolean okToDelete = composerLogic.canThisComposerBeDeleted(1, 1);
        assertEquals(false, okToDelete);
    }

    @Test
    void composerHasNoDependentCompositions(){
        boolean okToDelete = composerLogic.canThisComposerBeDeleted(6, 1);
        assertEquals(true, okToDelete);
    }
}