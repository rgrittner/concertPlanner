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

/**
 * Servlet for handling adding a Composition.
 * This servlet is accessed from:
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addComposition"}
)
public class AddComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method populates composer select items with current list of composers
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao<>(Composer.class);
        req.setAttribute("composers", dao.getAll("lastName"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addComposition.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * doPost method handles adding a composition to the database
     * This method is accessed from addComposition.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get data from form

        String titleFromForm = req.getParameter("title");
        String composerIdFromForm = req.getParameter("composer");
        String arrangerFromForm = req.getParameter("arranger");
        String durationFromForm = req.getParameter("duration");
        String yearFromForm = req.getParameter("year");
        String clocksCommissionFromForm = req.getParameter("clocksCommission");
        String numberOfPlayersFromForm = req.getParameter("numberOfPlayers");
        String notesFromform = "notes";
        //TODO notes? This should be nullable

        // Convert String data to correct data type for variable in entity
        Integer composerIdAsInteger = Integer.parseInt(composerIdFromForm);
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

        // Return user to list of all compositions
        String url = "/concertPlanner/ensemble/compositions ";

        resp.sendRedirect(url);


    }
}
