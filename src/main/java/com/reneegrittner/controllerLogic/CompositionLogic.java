package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.persistence.GenericDao;

public class CompositionLogic {
    
    public Composition createComposition(String title, String arranger,
                                         String composerId, String durationString,
                                         String yearString, String commissionString,
                                         String numberOfPlayersString, String notes, int userId){
        Composition composition = new Composition();

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
        
        return composition;
    }

    private Composer getComposer(Integer composerId) {
        GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);
        Composer composer = composerGenericDao.getById(composerId);

        return composer;

    }
}
