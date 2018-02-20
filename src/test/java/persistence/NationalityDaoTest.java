package persistence;


import entity.Composer;
import entity.Nationality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CRUD implementation for the Nationality class.
 */
public class NationalityDaoTest {
    /**
     * The Dao.
     */

    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanNationalityTable.sql");


        genericDao = new GenericDao(Nationality.class);
    }

    /**
     * Verify successful retrieval by id.
     */
    @Test
    void getByIdSuccess(){
        Nationality retrievedNationality = (Nationality) genericDao.getById(1);
        assertEquals("American", retrievedNationality.getNationality());
    }

    /**
     * Verify successful retrieval of all nationalities.
     */
    @Test
    void getAllSuccess(){
        List<Nationality> nationalityList = genericDao.getAll();
        assertEquals(3, nationalityList.size());
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {
        Nationality newNationality = new Nationality("English");
        int id = genericDao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality = (Nationality) genericDao.getById(id);
        assertEquals("English", insertedNationality.getNationality());
    }


    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertWithComposerSuccess() {
        Nationality newNationality = new Nationality("English");

        Composer composer = new Composer("New", "Composer", newNationality);

        newNationality.addComposer(composer);

        int id = genericDao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality = (Nationality) genericDao.getById(id);
        assertEquals("English", insertedNationality.getNationality());
        assertEquals(1, insertedNationality.getComposers().size());
    }

    /**
     * Verify successful save or update of nationality
     */
    @Test
    void saveOrUpdateSuccess(){
        String newNationality = "testing";
        Nationality nationalityToUpdate = (Nationality) genericDao.getById(2);
        nationalityToUpdate.setNationality(newNationality);
        genericDao.saveOrUpdate(nationalityToUpdate);
        Nationality retrievedNationality = (Nationality) genericDao.getById(2);
        assertEquals(newNationality, retrievedNationality.getNationality());
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
