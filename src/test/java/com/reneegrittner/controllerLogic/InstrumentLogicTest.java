package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.persistence.GenericDao;
import com.reneegrittner.util.DatabaseTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentLogicTest {
    private GenericDao<Instrument> instrumentGenericDao = new GenericDao<>(Instrument.class);
    private InstrumentLogic instrumentLogic = new InstrumentLogic();

    @BeforeEach
    void setUp() {
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");
    }

    @Test
    void createNewInstrument() {
        Instrument instrument = instrumentLogic.createOrUpdateInstrument("test Instrument", "2", 1, "");
        assertEquals(2, instrument.getInstrumentCategory().getId());
        assertEquals("test Instrument", instrument.getName());
    }

    @Test
    void updateExistingInstrument(){
        Instrument instrument = instrumentLogic.createOrUpdateInstrument("test Instrument", "2", 1, "1");
        assertEquals(2, instrument.getInstrumentCategory().getId());
        assertEquals("test Instrument", instrument.getName());
    }
}