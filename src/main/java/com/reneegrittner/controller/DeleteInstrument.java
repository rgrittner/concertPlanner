package com.reneegrittner.controller;

import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.Musician;
import com.reneegrittner.entity.User;
import com.reneegrittner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This servlet handles deleting of Musicians.
 * Only musicians who are not in use in a Program can be deleted
 *
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/deleteInstrument"}
)

public class DeleteInstrument extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);

    /**
     * The doGet retrieves the information about the musician to be deleted, making it available to the delete jsp.
     * This method is accessed from TODO fill this out
     * @param req access to items in the request
     * @param resp send the response
     * @throws ServletException when there is an error
     * @throws IOException when there is an error
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        Integer id = Integer.parseInt(req.getParameter("idOfInstrumentToBeDeleted"));

        GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);
        List<CompositionInstrument> compositionList = compositionInstrumentGenericDao.getByPropertyEqual("instrument", id, userIdFromSignIn);

        if(compositionList.size() > 0){
            req.setAttribute("okToDelete", false);
            req.setAttribute("compositions", compositionList);
        } else {

            req.setAttribute("okToDelete", true);

        }

        req.setAttribute("instrument", dao.getById(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/deleteInstrument.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Handles the actual deleting.
     * This method is accessed from: deleteMusician.jsp.
     * @param req the id of the musician to be deleted.
     * @param resp redirect to the list of musicians.
     * @throws IOException when there is an error.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get id from the form, this is a hidden input field
        Integer idFromForm = Integer.parseInt(req.getParameter("idOfInstrumentToBeDeleted"));

        // Get the Musician as an object by the id
        Instrument instrumentToBeDeleted = dao.getById(idFromForm);

        // Delete the musician
        dao.delete(instrumentToBeDeleted);

        // Redirect back to list of musicians
        String url = "/concertPlanner/ensemble/instruments";
        resp.sendRedirect(url);

        //TODO add error handling for when a musician cannot be deleted

    }
}

