package com.reneegrittner.persistence;

import com.reneegrittner.entity.Program;
import com.reneegrittner.util.DatabaseTwo;
import com.reneegrittner.entity.Musician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Program dao test.
 */
public class ProgramDaoTest
{
    /**
     * The Dao.
     */

    private GenericDao<Program> genericDao;

    /**
     * Set up.
     * Reset the Program table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");


        genericDao = new GenericDao<>(Program.class);
    }

    /**
     *  Verify successful insert of program.
     */
    @Test
    void insertSuccess() {

        Program newProgram = new Program(LocalDate.of(2018, 07, 15), "House Show", "Living Room", "123 Sessame St", "Rainbow", "AZ", 53716, "TBD");
        int id = genericDao.insert(newProgram);
        assertNotEquals(0, id);
        Program insertedMusician = genericDao.getById(id);
        assertEquals(newProgram, insertedMusician);
    }

    /**
     * Verify successful retrieval of program by id.
     */
    @Test
    void getByIdSuccess(){
        Program retrievedProgram = genericDao.getById(1);
        assertEquals("123 Sessame St", retrievedProgram.getAddress());

    }

    /**
     * Verify successful retrieval of all programs.
     */
    @Test
    void getAllSuccess(){
        List<Program> ProgramList = genericDao.getAll();
        assertEquals(4, ProgramList.size());
    }

    /**
     * Verify successful retrieval of program searching by property (equal match)
     */
    @Test
    void getByPropertyEqualOnLastNameSuccess(){
        List<Program> programs = genericDao.getByPropertyEqual("location", "CSU");
        assertEquals(1, programs.size());
        assertEquals(3, programs.get(0).getId());

    }
//
    /**
     * Verify successful retrieval of musician searching by property (like match)
     */
    @Test
    void getByPropertyLikeOnLastNameSuccess(){
        List<Program> programs = genericDao.getByPropertyLike("state", "a");
        assertEquals(1, programs.size());
    }

    /**
     * Verify successful save or update of program title
     */
    @Test
    void saveOrUpdateSuccess(){
        String newtitle = "testing";
        Program programToUpdate = genericDao.getById(1);
        programToUpdate.setConcertTitle(newtitle);
        genericDao.saveOrUpdate(programToUpdate);
        Program retrievedProgram = genericDao.getById(1);
        assertEquals(programToUpdate, retrievedProgram);
    }

//    @Test
//    void deleteSuccess(){
//          genericDao.delete(genericDao.getById(1));
//           assertNull(genericDao.getById(1));
//        }


}
