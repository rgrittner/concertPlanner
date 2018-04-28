package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Musician;
import com.reneegrittner.util.DatabaseTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicianLogicTest {
    MusicianLogic musicianLogic = new MusicianLogic();
    @BeforeEach
    void setUp() {
        DatabaseTwo database = DatabaseTwo.getInstance();
        database.runSQL("cleanAll.sql");
    }

    @Test
    void createMusician() {
        Musician musician = musicianLogic.createOrUpdateMusician(null,"firstName", "lastName", "2", "email", "Active", 1);
        assertEquals("firstName", musician.getFirstName());
    }

    @Test
    void updateMusician() {

        Musician musician = musicianLogic.createOrUpdateMusician("1","firstName", "lastName", "2", "email", "Active", 1);
        assertEquals("lastName", musician.getLastName());
        assertEquals("Active", musician.getStatus());
    }

    @Test
    void musicianTesting(){
        Musician musician = new Musician();
        musician.setStatus("Active");
        musician.setUserId(1);
        int id = musician.getUserId();
        String status = musician.getStatus();
        assertEquals("Active", status);
        assertEquals(1, id);
    }


}