package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.ProgramComposition;
import com.reneegrittner.entity.User;
import com.reneegrittner.persistence.GenericDao;

import java.util.List;

public class GuestLogOut {
    private GenericDao<ProgramComposition> programCompositionGenericDao = new GenericDao<>(ProgramComposition.class);
    private GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);
    private GenericDao<User> userGenericDao = new GenericDao<>(User.class);
    public void deleteAllGuestEntries(){
        deleteCompositionInstrument();
    }

    private void deleteCompositionInstrument(){
        Integer userId = 100;
        User user = userGenericDao.getById(userId);
        List<CompositionInstrument> itemsToDelete = compositionInstrumentGenericDao.getAll(userId);
        for (CompositionInstrument curent: itemsToDelete) {
            compositionInstrumentGenericDao.delete(curent);
        }
    }
}
