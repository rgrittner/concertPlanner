package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Musician;
import com.reneegrittner.persistence.GenericDao;

public class MusicianLogic {
    private GenericDao<Musician> musicianGenericDao = new GenericDao<>(Musician.class);
    public Musician createOrUpdateMusician(String idString, String firstName, String lastName, String phoneNumber, String email, String status, int userId){
        Musician musician;
        Integer id = null;

        if (idString == null){
            musician = new Musician();

        } else {
            id = Integer.parseInt(idString);
            musician = musicianGenericDao.getById(id);
        }

        musician.setFirstName(firstName);
        musician.setLastName(lastName);
        musician.setPhoneNumber(phoneNumber);
        musician.setEmail(email);
        musician.setStatus(status);
        musician.setUserId(userId);



        return musician;
    }

}
