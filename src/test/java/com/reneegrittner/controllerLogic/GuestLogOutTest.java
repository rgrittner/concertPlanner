package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.persistence.GenericDao;
import com.reneegrittner.util.DatabaseTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestLogOutTest {
private GuestLogOut guestLogOut = new GuestLogOut();
private GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);
    @BeforeEach
    void setUp() {
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");


    }

    @Test
    void deleteAllGuestEntries() {
        List<CompositionInstrument> itemsToDelete = compositionInstrumentGenericDao.getAll(100);
        List<CompositionInstrument> itemsNotToDelete = compositionInstrumentGenericDao.getAll(1);
        assertNotNull(itemsToDelete);
        assertNotNull(itemsNotToDelete);
        guestLogOut.deleteAllGuestEntries();
        List<CompositionInstrument> areTheyAllGone = compositionInstrumentGenericDao.getAll(100);
        List<CompositionInstrument> itemsNotToDeleteStillThere = compositionInstrumentGenericDao.getAll(1);
        assertEquals(0, areTheyAllGone.size());
        assertNotNull(itemsNotToDeleteStillThere);

    }
}