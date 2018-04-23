package com.reneegrittner.persistence;

import com.reneegrittner.entity.User;
import com.reneegrittner.util.DatabaseTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private GenericDao<User> genericDao;

    /**
     * Set up.
     * Reset the Nationality table to a known state.
     */
    @BeforeEach
    void setUp(){
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");
        genericDao = new GenericDao<>(User.class);

    }

    /**
     * Verify successful retrieval of all users.
     */
    @Test
    void getAllSuccess(){
        List<User> userList = genericDao.getAllUsers();
        assertEquals(3, userList.size());
    }

    /**
     *  Verify successful insert of nationality.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("newUser", "newPassword", "newEnsemble");
        int id = genericDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser =  genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }


}