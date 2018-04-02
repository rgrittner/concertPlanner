package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.persistence.GenericDao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/addComposition"}
)
public class AddComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao<>(Composer.class);
        req.setAttribute("composers", dao.getAll("lastName"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addComposition.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get data from form

        String titleFromForm = req.getParameter("title");
        String composerIdFromForm = req.getParameter("composer");
        logger.debug("composer as string" + composerIdFromForm);
        String arrangerFromForm = req.getParameter("arranger");
        String durationFromForm = req.getParameter("duration");
        String yearFromForm = req.getParameter("year");
        String clocksCommissionFromForm = req.getParameter("clocksCommission");
        String numberOfPlayersFromForm = req.getParameter("numberOfPlayers");
        String notesFromform = "notes";

        // Convert String data to correct data type for variable in entity
        Integer composerIdAsInteger = Integer.parseInt(composerIdFromForm);
        logger.debug("composer id as integer" + composerIdAsInteger);
        Integer durationAsInteger = Integer.parseInt(durationFromForm);
        Integer yearAsInteger = Integer.parseInt(yearFromForm);
        Boolean clocksCommissionAsBool = Boolean.parseBoolean(clocksCommissionFromForm);
        Integer numberOfPlayersAsInteger = Integer.parseInt(numberOfPlayersFromForm);

        // Get Composer as an object
        GenericDao composerDao = new GenericDao<>(Composer.class);
        Composer composerToBeAdded = (Composer) composerDao.getById(composerIdAsInteger);

        //Create new Composition object and set it's properties
        Composition compositionToBeAdded = new Composition();

        compositionToBeAdded.setYearComposed(yearAsInteger);
        compositionToBeAdded.setNumberOfPlayers(numberOfPlayersAsInteger);
        compositionToBeAdded.setDuration(durationAsInteger);
        compositionToBeAdded.setComposer(composerToBeAdded);
        compositionToBeAdded.setClocksCommission(clocksCommissionAsBool);
        compositionToBeAdded.setTitle(titleFromForm);

        //Check nullable fields for data
        if (arrangerFromForm.length() > 0) {
            compositionToBeAdded.setArranger(arrangerFromForm);
        }
        if (notesFromform.length() > 0){
            compositionToBeAdded.setNotes(notesFromform);
        }

        //TODO Some sort of validation?

        GenericDao genericDao = new GenericDao<>(Composition.class);
        genericDao.insert(compositionToBeAdded);


        String url = "/protected/compositions";

        resp.sendRedirect(url);


    }
}
