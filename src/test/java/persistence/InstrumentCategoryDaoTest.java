package persistence;

import entity.InstrumentCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

/**
 * CRUD test class for Instrument_Category table
 * @author Renee Grittner
 */
public class InstrumentCategoryDaoTest {
    InstrumentCategoryDao dao;

    /**
     * Set up.
     * Reset the Instrument_Category table to a known state.
     */
    @BeforeEach
    void setUp(){
        Database database = Database.getInstance();
        database.runSQL("cleanInstrumentCategory.sql");

        dao = new InstrumentCategoryDao();
    }


}
