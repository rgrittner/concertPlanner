package com.reneegrittner.controller;

import com.reneegrittner.entity.*;
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

@WebServlet(
        urlPatterns = {"/ensemble/singleComposition"}
)

/* Generates all information needed to display a single composition.
  Queries DB for Composer information, makes available to the jsp.
  Queries DB for Composition information, makes available to the jsp.
  Queries for instrumentation by player, if instrumentation is found makes available to the jsp,
  otherwise provides a link to add instrumentation.
  Accessed from: TODO fill this out
  @author Renee Grittner
 */
public class SingleComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();


        //TODO use something more descriptive than param
        Integer idFromParam = Integer.parseInt(req.getParameter("param"));


        // Create all needed dao's
        GenericDao<Composer> dao2 = new GenericDao<>(Composer.class);
        GenericDao<Composition> compositionDao = new GenericDao<>(Composition.class);
        GenericDao<ProgramComposition> programCompositionGenericDao = new GenericDao<>(ProgramComposition.class);
        GenericDao<CompositionInstrument> linkingDao = new GenericDao<>(CompositionInstrument.class);

        // Retrieve requested composition & get it's id
        Composition composition =  compositionDao.getById(idFromParam);
        Integer composerId = composition.getComposer().getId();

        // Retrieve composer of requested composition & get their id
        Composer composer =  dao2.getById(composerId);
        Integer compositionId = composition.getId();

        // Retrieve all performances of requested composition
        List<ProgramComposition> listOfProgramsOfThisComposition = programCompositionGenericDao.getByPropertyEqual("composition", compositionId, userIdFromSignIn);
        logger.debug("List of lots of shit: " + listOfProgramsOfThisComposition);

        req.setAttribute("compositionInformation", composition);
        req.setAttribute("composerInformation", composer);
        req.setAttribute("playerOneInstruments", linkingDao.getByPropertyEqualCompositionInstrument(1, compositionId, userIdFromSignIn));
        req.setAttribute("playerTwoInstruments", linkingDao.getByPropertyEqualCompositionInstrument(2, compositionId, userIdFromSignIn));
        req.setAttribute("playerThreeInstruments", linkingDao.getByPropertyEqualCompositionInstrument(3, compositionId, userIdFromSignIn));
        req.setAttribute("playerFourInstruments", linkingDao.getByPropertyEqualCompositionInstrument(4, compositionId, userIdFromSignIn));
        req.setAttribute("listOfPerformances", listOfProgramsOfThisComposition);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/singleComposition.jsp");
        dispatcher.forward(req, resp);
    }
}
