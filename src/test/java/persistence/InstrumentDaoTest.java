package persistence;


import entity.Instrument;
import entity.InstrumentCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
     *  Verify successful insert of nationality.
     */
//    @Test
//    void insertSuccess() {

//        GenericDao localDao = new GenericDao(Nationality.class);
//        InstrumentCategory instrumentCategory = (InstrumentCategory) localDao.getById(2);
//
//        Instrument newInstrument = new Instrument("Dog Bone", instrumentCategory);
//        nationality.addInstrument(newInstrument);
//
//        int id = genericDao.insert(newInstrument);
//        assertNotEquals(0, id);
//        Instrument insertedInstrument = (Instrument) genericDao.getById(id);
//        assertEquals(newInstrument, insertedInstrument);
//        //assertEquals("Musician", insertedMusician.getLastName());

  //  }



    /**
     * Verify successful retrieval of all Instruments.
     */
    @Test
    void getAllSuccess(){
        List<Instrument> composerList = genericDao.getAll();
        assertEquals(6, composerList.size());
    }

    /**
     * Verify successful retrieval of instrument by id.
     */
//    @Test
//    void getByIdSuccess(){
//        Instrument retrievedInstrument = (Instrument) genericDao.getById(3);
//        assertEquals("Marimba - Quarter Tone", retrievedInstrument.getInstrumentName();
//
//
//    }

    /**
     * Verify successful save or update of Instrument
     */
//    @Test
//    void saveOrUpdateSuccess(){
//        Integer newBirthYear = 1976;
//        Instrument instrumentToUpdate = (Instrument) genericDao.getById(4);
//        instrumentToUpdate.setBirthYear(newBirthYear);
//        genericDao.saveOrUpdate(instrumentToUpdate);
//        Instrument retrievedInstrument = (Instrument) genericDao.getById(4);
//        assertEquals(instrumentToUpdate, retrievedInstrument);
//    }


//    /**
//     * Verify successful delete of Instrument
//     */
//    @Test
//    void deleteSuccess(){
//        genericDao.delete(genericDao.getById(1));
//        assertNull(genericDao.getById(1));
//    }
}
