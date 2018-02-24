package persistence;

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
        assertEquals("Metals", retrievedCategory.getCategoryDescription());
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
        assertEquals("Test", insertedCategory.getCategoryDescription());
    }

    /**
     * Verify successful save or update of category
     */
    @Test
    void saveOrUpdateSuccess(){
        String newCategory = "testing";
        InstrumentCategory categoryToUpdate = (InstrumentCategory) genericDao.getById(6);
        categoryToUpdate.setCategoryDescription(newCategory);
        genericDao.saveOrUpdate(categoryToUpdate);
        InstrumentCategory retrievedCategory = (InstrumentCategory) genericDao.getById(6);
        assertEquals(newCategory, retrievedCategory.getCategoryDescription());
    }

    /**
     * Verify successful delete of category
     */
    @Test
    void deleteSuccess(){
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }


}
