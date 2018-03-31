package com.reneegrittner.persistence;

import com.reneegrittner.util.DatabaseTwo;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompositionDaoTest {
    GenericDao genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");

        genericDao = new GenericDao(Composition.class);
    }

    /**
     * Verify successful retrieval of all composers.
     */
    @Test
    void getAllSuccess(){
        List<Composition> compositionList = genericDao.getAll();
        assertEquals(5, compositionList.size());
    }

    /**
     *  Verify successful insert of category.
     */
    @Test
    void insertSuccess() {

        GenericDao localDao = new GenericDao(Composer.class);
        Composer composer = (Composer) localDao.getById(2);

        Composition newComposition = new Composition("Prelude", null, 10, 2010, 4, null, true, composer);
        composer.addComposition(newComposition);

        int id = genericDao.insert(newComposition);
        assertNotEquals(0, id);
        Composition insertedCompositon = (Composition) genericDao.getById(id);
        assertEquals(newComposition, insertedCompositon);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Composition> compositions = genericDao.getByPropertyEqual("title", "Gravity");
        assertEquals(1, compositions.size());
        assertEquals(1, compositions.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyEqualIntegerSuccess() {
        Integer value = 1;
        List<Composition> compositions = genericDao.getByPropertyEqual("Composer_id", value);
        assertEquals(1, compositions.size());
    }

    @Test
    void getBySomething() {
        GenericDao localDao = new GenericDao<>(Composition.class);
        localDao.getCompositionsByComposer();
    }
    @Test
    void takeTwo() {
        GenericDao localDao = new GenericDao<>(Composition.class);
        Integer id = 1;
        localDao.getByPropertyEqualComposition(id);
    }

    @Test
    void tryingAgain(){
        GenericDao localDao = new GenericDao<>(Composer.class);
        Composer composer = (Composer) localDao.getById(1);

        genericDao.tryingAgain("Mellits");
    }

    @Test
    void fridayAgernoon(){
        genericDao.fridayAfternoon();
    }

    @Test
    void attemptFromYoutube(){
        genericDao.attemptFromYoutube();
    }



// Remove comment when there is a dependency to Composition.
//    @Test
//    void deleteExceptionTesting() {
//        Throwable exception = assertThrows(PersistenceException.class, () -> {
//            genericDao.delete(genericDao.getById(1));
//        });
//        assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", exception.getMessage());
//    }
}
