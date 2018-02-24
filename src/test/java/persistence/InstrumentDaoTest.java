package persistence;

import entity.Instrument;
import entity.InstrumentCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InstrumentDaoTest {
    GenericDao genericDao;
    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao(Instrument.class);
    }

    /**
     *  Verify successful insert of an instrument.
     */
    @Test
    void insertSuccess() {

        GenericDao localDao = new GenericDao(InstrumentCategory.class);
        InstrumentCategory instrumentCategory = (InstrumentCategory) localDao.getById(2);

        Instrument newInstrument = new Instrument( "Instrument", instrumentCategory);
        instrumentCategory.addInstrument(newInstrument);

        int id = genericDao.insert(newInstrument);
        assertNotEquals(0, id);
        Instrument insertedInstrument = (Instrument) genericDao.getById(id);
        assertEquals(newInstrument, insertedInstrument);
        //assertEquals("Musician", insertedMusician.getLastName());

    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Instrument> instrumentList = genericDao.getAll();
        assertEquals(20, instrumentList.size());
    }
}
