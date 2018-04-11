package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet sets attributes for use by the addInstrumentStart.jsp.
 * This is the first step in the add instrumentation process. See DisplayAddPlayerInstCategoty for step 2.
 * This servlet is accessed from: singleComposition.jsp when a user clicks "Add Instrumentation" for a
 * player that has no instrumentation for the viewed composition.
 * Sets the attributes for: Instrument Category, player number, and composition Id.
 * Instrument Category is a DB query
 * player number and composition id come as parameter from
 * /concertPlanner/ensemble/addPlayerInstrumentation?player=1&compositionId=${compositionInformation.id}
 */
@WebServlet(
        urlPatterns = {"/ensemble/addPlayerInstrumentation"}
)
public class AddInstrumentationStart extends HttpServlet {

    /**
     * doGet Sets the attributes for: Instrument Category, player number, and composition Id.
     * this method gets the player number and composition id as query params in the get request
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer playerFromParam = Integer.parseInt(req.getParameter("player"));

        GenericDao<InstrumentCategory> dao = new GenericDao<>(InstrumentCategory.class);
        GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);

        Composition currentComposition = compositionGenericDao.getById(Integer.parseInt(req.getParameter("compositionId")));
        int maxNumberOfPlayers = currentComposition.getNumberOfPlayers();
        int nextPlayer = 0;

        if(playerFromParam <= maxNumberOfPlayers){
            nextPlayer = playerFromParam + 1;
        }


        req.setAttribute("instrumentCat", dao.getAll("category"));
        req.setAttribute("playerNumber", playerFromParam);
        req.setAttribute("compositionId", req.getParameter("compositionId"));
        req.setAttribute("composition", currentComposition);
        req.setAttribute("nextPlayer", nextPlayer);
        req.setAttribute("maxPlayer", maxNumberOfPlayers);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addInstrumentationStart.jsp");
        dispatcher.forward(req, resp);
    }
}
