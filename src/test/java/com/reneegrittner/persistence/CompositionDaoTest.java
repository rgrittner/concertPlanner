package com.reneegrittner.persistence;

import com.reneegrittner.util.DatabaseTwo;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CompositionDaoTest {
    private GenericDao<Composition> genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao<>(Composition.class);
    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Composition> compositionList = genericDao.getAll(1);
        assertEquals(5, compositionList.size());
    }

    /**
     *  Verify successful insert of category.
     */
    @Test
    void insertSuccess() {

        GenericDao<Composer> localDao = new GenericDao<>(Composer.class);
        Composer composer =  localDao.getById(2);

        Composition newComposition = new Composition("Prelude", null, 10, 2010, 4, null, true, composer, 1);
        composer.addComposition(newComposition);

        int id = genericDao.insert(newComposition);
        assertNotEquals(0, id);
        Composition insertedCompositon =  genericDao.getById(id);
        assertEquals(newComposition, insertedCompositon);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Composition> compositions = genericDao.getByPropertyEqual("title", "Gravity", 1);
        assertEquals(1, compositions.size());
        assertEquals(1, compositions.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyEqualIntegerSuccess() {
        Integer value = 1;
        List<Composition> compositions = genericDao.getByPropertyEqual("id", value, 1);
        assertEquals(1, compositions.size());
    }



//    @Test
//    void deleteExceptionTesting() {
//        Throwable exception = assertThrows(PersistenceException.class, () -> {
//            genericDao.delete(genericDao.getById(1));
//        });
//        assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", exception.getMessage());
//    }
}
