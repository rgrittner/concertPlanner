package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.persistence.GenericDao;

public class InstrumentLogic {

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
}
