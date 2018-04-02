package com.reneegrittner.controller;

import com.reneegrittner.entity.Composition;
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


        // Redirect depending on which type... may be able to reduce this to a single page.
        String url = "";
        switch (categoryFromForm) {
            case "Keyboards": url = "/protected/addKeyboards.jsp";
                    break;
            case "Skins": url = "/protected/addSkins.jsp";
                    break;
            case "Woods": url = "/protected/addWoods.jsp";
                    break;
            case "Metals": url = "/protected/addMetals.jsp";
                    break;
            case "Other": url = "/protected/addOther.jsp";
                    break;
            case "Timpani": url = "/protected/addTimpani.jsp";
                    break;
            case "Accessory": url = "/protected/addAccessory.jsp";
                    break;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // get player number

        // get composition id


        // Find out how many instruments there currently are in current category
        int numberOfInstrumentsOfCategory = dao.getByPropertyEqual("category", 7).size();
        int current = 0;
        while(current <= numberOfInstrumentsOfCategory){
            int idOfCurrentInstrument = Integer.parseInt(req.getParameter("current"));
            //check if this instrument exists for this player for this composition
                // if yes
                    // saveOrUpdate
                // if no
                    // insert

        }

    }
}

//TODO -- figure this shit out!
// string valie from form
// name = the instrument id, so we can find out how many instruments of a category there are.
// in a while loop keep getting the next id up and then add it to the linking table?