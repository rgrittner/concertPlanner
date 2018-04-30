package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.persistence.GenericDao;

public class CompositionInstrumentLogic {
    private GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);

    public void deleteInstrumentFromCompositionById(Integer id){
        CompositionInstrument itemToDelete = getItemFromLinkingTable(id);
        compositionInstrumentGenericDao.delete(itemToDelete);

    }

    private CompositionInstrument getItemFromLinkingTable(Integer id) {
        return compositionInstrumentGenericDao.getById(id);
    }
}
