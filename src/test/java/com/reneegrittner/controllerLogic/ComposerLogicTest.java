package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;
import com.reneegrittner.util.DatabaseTwo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComposerLogicTest {
    private GenericDao<Composer> genericDao;
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
        GenericDao<Nationality> nationalityGenericDao = new GenericDao<>(Nationality.class);
        Nationality nationality = nationalityGenericDao.getById(1);
        int id = composerLogic.addComposer("firstName", "lastName", 123, 123, nationality);
        assertEquals(1, id);

    }
}