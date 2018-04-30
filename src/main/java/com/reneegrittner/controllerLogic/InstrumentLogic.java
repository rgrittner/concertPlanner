package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.persistence.GenericDao;

import java.util.List;

public class InstrumentLogic {
    private GenericDao<InstrumentCategory> instrumentCategoryGenericDao = new GenericDao<>(InstrumentCategory.class);

    public Instrument createOrUpdateInstrument(String instrumentName, String categoryIdString, int userId, String instrumentIdString){
        Instrument instrument;

        if (instrumentIdString.length() > 0) {
            instrument = getInstrument(instrumentIdString);
        } else {
            instrument = new Instrument();
        }

        instrument.setName(instrumentName);
        instrument.setInstrumentCategory(getInstrumentCategory(categoryIdString));
        instrument.setUserId(userId);

        return instrument;

    }


    private Instrument getInstrument(String idString){
        GenericDao<Instrument> instrumentGenericDao = new GenericDao<>(Instrument.class);
        Instrument instrument = instrumentGenericDao.getById(Integer.parseInt(idString));

        return instrument;
    }

    private InstrumentCategory getInstrumentCategory(String categoryIdString){
        GenericDao<InstrumentCategory> instrumentCategoryGenericDao = new GenericDao<>(InstrumentCategory.class);
        InstrumentCategory instrumentCategory = instrumentCategoryGenericDao.getById(Integer.parseInt(categoryIdString));

        return instrumentCategory;
    }

    public boolean checkIfCategoryAlreadyExists(String categoryNameToCheck, int userId) {
        boolean okToInsert = false;

        List<InstrumentCategory> instrumentCategory = instrumentCategoryGenericDao.getByPropertyEqual("category", categoryNameToCheck, userId);
        if (instrumentCategory.isEmpty()) {
            okToInsert = true;
        }

        return okToInsert;
    }

    public int addNewInstrumentCategory(String category, int userId){
        int id;
        InstrumentCategory categoryToBeAdded = new InstrumentCategory();
        categoryToBeAdded.setUserId(userId);
        categoryToBeAdded.setCategory(category);

        id = instrumentCategoryGenericDao.insert(categoryToBeAdded);
        return id;
    }

}

