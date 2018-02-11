package persistence;

import entity.InstrumentCategory;
import org.junit.jupiter.api.BeforeEach;
import util.Database;

/**
 * CRUD test class for Instrument_Category table
 * @author Renee Grittner
 */
public class InstrumentCategoryDaoTest {
    InstrumentCategoryDao dao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanInstrumentCategory.sql");

        dao = new InstrumentCategoryDao();
    }
}
