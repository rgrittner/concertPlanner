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

@WebServlet(
        urlPatterns = {"/ensemble/PlayerInstrumentationCategory"}
)
public class DisplayAddPlayerInstCategory extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get compositionId, category and playerNumber
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

        // Send the playerNumber as well
        req.setAttribute("playerNumber", playerNumber);
        req.setAttribute("categoryId", categoryIdFromForm);


        // Redirect depending on which type... may be able to reduce this to a single page.
//        String url = "";
//        switch (categoryFromForm) {
//            case "Keyboards": url = "/protected/addKeyboards.jsp";
//                    break;
//            case "Skins": url = "/protected/addSkins.jsp";
//                    break;
//            case "Woods": url = "/protected/addWoods.jsp";
//                    break;
//            case "Metals": url = "/protected/addMetals.jsp";
//                    break;
//            case "Other": url = "/protected/addOther.jsp";
//                    break;
//            case "Timpani": url = "/protected/addTimpani.jsp";
//                    break;
//            case "Accessory": url = "/protected/addAccessory.jsp";
//                    break;
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addAccessory.jsp");
        dispatcher.forward(req, resp);
    }

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

//TODO -- figure this shit out!
// string valie from form
// name = the instrument id, so we can find out how many instruments of a category there are.
// in a while loop keep getting the next id up and then add it to the linking table?