package com.reneegrittner.controller;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
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
 * The main player instrumentation addition servlet.
 * This is the second step in adding instrumentation
 * The doGet method populates the available instruments for the chosen category in step 1.
 * The doPost handles adding to the Composition_Instrument table.
 * After adding instruments of one category the user is redirected to AddInstrumentStart.
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/PlayerInstrumentationCategory"}
)
public class DisplayAddPlayerInstCategory extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Dao.
     */
    GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);

    /**
     * Retrieves information sent along in the request (player number, composition id, instrument category id)
     * Queries DB for composition information
     * Queries DB for list of instruments of chosen category
     * Makes composition, list of instruments, and player number available to the jsp
     * @param req the request
     * @param resp the response
     * @throws ServletException when there is an error
     * @throws IOException when there is an error
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get compositionId, category and playerNumber from request
        String categoryFromForm = req.getParameter("category");
        Integer compositionIdFromForm = Integer.parseInt(req.getParameter("compositionId"));
        int playerNumber = Integer.parseInt(req.getParameter("playerNumber"));
        Integer categoryIdFromForm = Integer.parseInt(req.getParameter("categoryId"));

        // Get the composition information to send along to jsp
        GenericDao<Composition> compositionDao = new GenericDao<>(Composition.class);
        Composition composition = (Composition) compositionDao.getById(compositionIdFromForm);
        req.setAttribute("composition", composition);

        // Get all instruments of given category and send along to the jsp
        GenericDao<InstrumentCategory> categoryDao = new GenericDao<>(InstrumentCategory.class);
        List<InstrumentCategory> category = categoryDao.getByPropertyEqual("category", categoryFromForm);
        int categoryId = category.get(0).getId();
        req.setAttribute("instruments", dao.getByPropertyEqual("instrumentCategory", categoryId));

        // Send the playerNumber and category id as well
        req.setAttribute("playerNumber", playerNumber);
        req.setAttribute("categoryId", categoryIdFromForm);

        //redirect back to add page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addAccessory.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Collects instrument category id, player number and composition id from hidden input fields,
     * Generates a list of instruments of the chosen category,
     * for every instrument in the list, checks the request to see what data came over.
     * TODO check if this instrument currently exists for this player/composition combo
     * TODO if so, save/update, else insert
     * then adds to the Composition_Instrument table
     * @param req the request
     * @param resp the response
     * @throws IOException when there is an error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // get category id
        Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
        // get player number
        Integer playerNumber = Integer.parseInt(req.getParameter("playerNumber"));

        // get composition id
        Integer compositionId = Integer.parseInt(req.getParameter("idOfComposition"));

        // get composition object
        GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);
        Composition composition = compositionGenericDao.getById(compositionId);

        GenericDao<CompositionInstrument> compositionInstrumentGenericDao = new GenericDao<>(CompositionInstrument.class);
        // Find out how many instruments there currently are in current category
       // GenericDao<InstrumentCategory> categoryGenericDao = new GenericDao<>(InstrumentCategory.class);
        List<Instrument> listOfInstrumentsOfCategory = dao.getByPropertyEqual("instrumentCategory", categoryId);
        for(Instrument currentInstrument: listOfInstrumentsOfCategory) {
            Integer currentId = currentInstrument.getId();
            // get quantity from form
            CompositionInstrument compositionInstrument = new CompositionInstrument();
            compositionInstrument.setInstrument(currentInstrument);
            compositionInstrument.setPlayerNumber(playerNumber);
            compositionInstrument.setComposition(composition);
            compositionInstrument.setInstrumentQuantity(Integer.parseInt(req.getParameter("instrumentId" + currentId)));
            compositionInstrumentGenericDao.insert(compositionInstrument);
        }


        String url = "/concertPlanner/ensemble/addPlayerInstrumentation?player="+playerNumber+"&compositionId="+compositionId;


        resp.sendRedirect(url);

    }
}

