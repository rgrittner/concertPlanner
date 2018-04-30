package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.persistence.GenericDao;
import com.reneegrittner.util.DatabaseTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositionInstrumentLogicTest {
    private GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);
    private GenericDao<Instrument> instrumentGenericDao = new GenericDao<>(Instrument.class);
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
    private CompositionInstrumentLogic compositionInstrumentLogic;

    @BeforeEach
    void setUp() {
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");
        compositionInstrumentLogic = new CompositionInstrumentLogic();

    }

    @Test
    void deleteInstrumentFromCompositionById() {
        compositionInstrumentLogic.deleteInstrumentFromCompositionById(1);
        assertNull(compositionInstrumentGenericDao.getById(1));
        assertNotNull(compositionGenericDao.getById(1));
        assertNotNull(instrumentGenericDao.getById(1));



    }
}