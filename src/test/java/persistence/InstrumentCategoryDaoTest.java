//package persistence;
//
//import entity.InstrumentCategory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import util.Database;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
///**
// * CRUD test class for Instrument_Category table
// * @author Renee Grittner
// */
//public class InstrumentCategoryDaoTest {
//
//
//    GenericDao genericDao;
//
//    /**
//     * Set up.
//     * Reset the Instrument_Category table to a known state.
//     */
//    @BeforeEach
//    void setUp(){
//        Database database = Database.getInstance();
//        database.runSQL("cleanInstrumentCategoryTable.sql");
//
//
//        genericDao = new GenericDao(InstrumentCategory.class);
//    }
//
//    /**
//     * Verify successful retrieval of all categories.
//     */
//    @Test
//    void getAllSuccess(){
//        List<InstrumentCategory> nationalityList = genericDao.getAll();
//        assertEquals(6, nationalityList.size());
//    }
//
//    /**
//     * Verify successful retrieval by id.
//     */
//    @Test
//    void getByIdSuccess(){
//        InstrumentCategory retrievedCategory = (InstrumentCategory) genericDao.getById(4);
//        assertEquals("Woods", retrievedCategory.getCategory());
//    }
//
//    /**
//     *  Verify successful insert of category.
//     */
//    @Test
//    void insertSuccess() {
//        InstrumentCategory newCategory = new InstrumentCategory("Test");
//        int id = genericDao.insert(newCategory);
//        assertNotEquals(0, id);
//        InstrumentCategory insertedCategory = (InstrumentCategory) genericDao.getById(id);
//        assertEquals("Test", insertedCategory.getCategory());
//    }
//
//    /**
//     * Verify successful save or update of category
//     */
//    @Test
//    void saveOrUpdateSuccess(){
//        String newCategory = "testing";
//        InstrumentCategory categoryToUpdate = (InstrumentCategory) genericDao.getById(6);
//        categoryToUpdate.setCategory(newCategory);
//        genericDao.saveOrUpdate(categoryToUpdate);
//        InstrumentCategory retrievedNationality = (InstrumentCategory) genericDao.getById(6);
//        assertEquals(newCategory, retrievedNationality.getCategory());
//    }
//
//    /**
//     * Verify successful delete of category
//     */
//    @Test
//    void deleteSuccess(){
//        genericDao.delete(genericDao.getById(1));
//        assertNull(genericDao.getById(1));
//    }
//
//
//}
