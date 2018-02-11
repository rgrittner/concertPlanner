package persistence;

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
    NationalityDao dao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanNationalityTable.sql");

        dao = new NationalityDao();
    }

    /**
     * Verify successful retrieval by id.
     */
    @Test
    void getByIdSuccess(){
        Nationality retrievedNationality = dao.getById(1);
        assertEquals("American", retrievedNationality.getNationality());
    }

    /**
     * Verify successful retrieval of all nationalities.
     */
    @Test
    void getAllSuccess(){
        List<Nationality> nationalityList = dao.getAll();
        assertEquals(3, nationalityList.size());
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {
        Nationality newNationality = new Nationality("English");
        int id = dao.insert(newNationality);
        assertNotEquals(0, id);
        Nationality insertedNationality = dao.getById(id);
        assertEquals("English", insertedNationality.getNationality());
    }

    /**
     * Verify successful save or update of nationality
     */
    @Test
    void saveOrUpdateSuccess(){
        String newNationality = "testing";
        Nationality nationalityToUpdate = dao.getById(2);
        nationalityToUpdate.setNationality(newNationality);
        dao.saveOrUpdate(nationalityToUpdate);
        Nationality retrievedNationality = dao.getById(2);
        assertEquals(newNationality, retrievedNationality.getNationality());
    }

    /**
     * Verify successful delete of nationality
     */
    @Test
    void deleteSuccess(){
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
}
