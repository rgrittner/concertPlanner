package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.persistence.GenericDao;
import com.reneegrittner.util.DatabaseTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositionLogicTest {
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
    private CompositionLogic compositionLogic = new CompositionLogic();

    @BeforeEach
    void setUp() {
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");
    }

    @Test
    void createComposition() {
        Composition composition = compositionLogic.createComposition(null,"title", "arranger","1", "10", "2008", "1", "4", "", 1);
        assertEquals("arranger", composition.getArranger());
        assertEquals(1, composition.getComposer().getId());
        assertEquals("title", composition.getTitle());
        Integer duration = 10;
        Integer year = 2008;
        Integer players = 4;
        assertEquals(duration, composition.getDuration());
        assertEquals(year, composition.getYearComposed());
        assertEquals("", composition.getNotes());
        assertEquals(players, composition.getNumberOfPlayers());
        assertEquals(1, composition.getUserId());

    }
}