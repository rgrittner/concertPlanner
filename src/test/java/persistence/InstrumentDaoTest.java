package persistence;

import entity.Instrument;
import entity.InstrumentCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Instrument> instrumentList = genericDao.getAll();
        assertEquals(20, instrumentList.size());
    }

    /**
     * Verify successful retrieval of composer by id.
     */
    @Test
    void getByIdSuccess(){
        Instrument retrievedComposer = (Instrument) genericDao.getById(3);
        assertEquals("Marimba - Quarter Tone", retrievedComposer.getName());


    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Instrument> instruments = genericDao.getByPropertyEqual("name", "Marimba");
        assertEquals(1, instruments.size());
        assertEquals(1, instruments.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Instrument> instruments = genericDao.getByPropertyLike("name", "marimba");
        assertEquals(2, instruments.size());
    }



    /**
     * Verify successful save or update of Instrument
     */
    @Test
    void saveOrUpdateSuccess(){
        String newInstrumentName = "TaDa!";
        Instrument instrumentToUpdate = (Instrument) genericDao.getById(4);
        instrumentToUpdate.setName(newInstrumentName);
        genericDao.saveOrUpdate(instrumentToUpdate);
        Instrument retrievedInstrument = (Instrument) genericDao.getById(4);
        assertEquals(instrumentToUpdate, retrievedInstrument);
    }

    /**
     * Verify successful delete of nationality
     */
    @Test
    void deleteSuccess(){
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }
}
