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

/**
 * CRUD test class for Instrument_Category table
 * @author Renee Grittner
 */
public class InstrumentCategoryDaoTest {


    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Instrument_Category table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanAll.sql");


        genericDao = new GenericDao(InstrumentCategory.class);
    }

    /**
     * Verify successful retrieval of all categories.
     */
    @Test
    void getAllSuccess(){
        List<InstrumentCategory> instrumentCategoryList = genericDao.getAll();
        assertEquals(6, instrumentCategoryList.size());
    }

    /**
     * Verify successful retrieval by id.
     */
    @Test
    void getByIdSuccess(){
        InstrumentCategory retrievedCategory = (InstrumentCategory) genericDao.getById(4);
        assertEquals("Metals", retrievedCategory.getCategory());
    }

    /**
     *  Verify successful insert of category.
     */
    @Test
    void insertSuccess() {
        InstrumentCategory newCategory = new InstrumentCategory("Test");
        int id = genericDao.insert(newCategory);
        assertNotEquals(0, id);
        InstrumentCategory insertedCategory = (InstrumentCategory) genericDao.getById(id);
        assertEquals(newCategory, insertedCategory);
    }


    /**
     *  Verify successful insert of instrument category with Instrument.
     */
    @Test
    void insertWithInstrumentSuccess() {
        InstrumentCategory newInstrumentCategory = new InstrumentCategory("Bananas");

        Instrument instrument = new Instrument("New Instrument", newInstrumentCategory);

        newInstrumentCategory.addInstrument(instrument);

        int id = genericDao.insert(newInstrumentCategory);
        assertNotEquals(0, id);
        InstrumentCategory insertedInstrumentCategory = (InstrumentCategory) genericDao.getById(id);
        assertEquals(newInstrumentCategory, insertedInstrumentCategory);
        //assertEquals(1, insertedInstrumentCategory.get);
    }


    /**
     * Verify successful save or update of instrument category
     */
    @Test
    void saveOrUpdateSuccess(){
        String newCategory = "testing";
        InstrumentCategory categoryToUpdate = (InstrumentCategory) genericDao.getById(6);
        categoryToUpdate.setCategory(newCategory);
        genericDao.saveOrUpdate(categoryToUpdate);
        InstrumentCategory retrievedInstrumentCategory = (InstrumentCategory) genericDao.getById(6);
        assertEquals(categoryToUpdate, retrievedInstrumentCategory);
    }

    /**
     * Verify successful delete of category
     */
    @Test
    void deleteItemWithNoFKConstraintSuccess(){
        InstrumentCategory newCategory = new InstrumentCategory("Test");
        int id = genericDao.insert(newCategory);
        genericDao.delete(genericDao.getById(id));
        assertNull(genericDao.getById(id));
    }


}
