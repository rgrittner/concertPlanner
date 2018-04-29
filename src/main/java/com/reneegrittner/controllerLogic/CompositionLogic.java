package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.persistence.GenericDao;

import java.util.List;

public class CompositionLogic {
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
    private GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);

    public Composition createComposition(String compositionIdString, String title, String arranger,
                                         String composerId, String durationString,
                                         String yearString, String commissionString,
                                         String numberOfPlayersString, String notes, int userId){


        Composition composition;

        if(compositionIdString == null){
            composition = new Composition();
        } else {
            composition = getCompositionFromDB(Integer.parseInt(compositionIdString));
        }

        // Get composer object
        Composer composer = getComposer(Integer.parseInt(composerId));


        // Assemble the composition
        composition.setTitle(title);
        composition.setArranger(arranger);
        composition.setComposer(composer);
        composition.setDuration(Integer.parseInt(durationString));
        composition.setYearComposed(Integer.parseInt(yearString));
        composition.setClocksCommission(Boolean.parseBoolean(commissionString));
        composition.setNumberOfPlayers(Integer.parseInt(numberOfPlayersString));
        composition.setNotes(notes);
        composition.setUserId(userId);

        //send back completed composition object
        return composition;
    }

    private Composition getCompositionFromDB(int id) {
        Composition composition = compositionGenericDao.getById(id);
        return composition;
    }

    private Composer getComposer(Integer composerId) {
        GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);
        Composer composer = composerGenericDao.getById(composerId);

        return composer;

    }

    public boolean canThisCompositionBeDeleted(Integer id, int userId){
        List<CompositionInstrument> instrumentsAssignedToThisComposition = listOfInstrumentsForThisComposition(id, userId);
        boolean okToDelete;
        if(instrumentsAssignedToThisComposition.size() > 0){
            okToDelete = false;
        } else {
            okToDelete = true;
        }

        return okToDelete;
    }

    public List<CompositionInstrument> listOfInstrumentsForThisComposition(Integer id, int userId) {
        List<CompositionInstrument> instrumentsAssignedToThisComposition = compositionInstrumentGenericDao.getByPropertyEqual("composition", id, userId);
        return instrumentsAssignedToThisComposition;
    }

    public String deleteComposition(Integer compositionId, int userId){
        String message;
        boolean okToDelete = canThisCompositionBeDeleted(compositionId, userId);
        if(okToDelete){
            Composition compositionToBeDeleted = getCompositionFromDB(compositionId);
            compositionGenericDao.delete(compositionToBeDeleted);
            message = "Deleted";
        } else {
            message = "Not Deleted";
        }

        return message;
    }


}
