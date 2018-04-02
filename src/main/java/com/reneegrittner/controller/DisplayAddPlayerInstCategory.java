package com.reneegrittner.controller;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryFromForm = req.getParameter("category");
        int playerNumber = Integer.parseInt(req.getParameter("playerNumber"));
        logger.debug("what is the categoru " + categoryFromForm);
        GenericDao<InstrumentCategory> categoryDao = new GenericDao<>(InstrumentCategory.class);
        List<InstrumentCategory> category = categoryDao.getByPropertyEqual("category", categoryFromForm);
        logger.debug("Id? " + category);
        int categoryId = category.get(0).getId();
        logger.debug("category id as int? " + categoryId);


        GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);

        logger.debug("what came back from the dao? " + dao.getByPropertyEqual("instrumentCategory", categoryId));


        req.setAttribute("instruments", dao.getByPropertyEqual("instrumentCategory", categoryId));
        req.setAttribute("playerNumber", playerNumber);
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
}

//TODO -- figure this shit out!
// string valie from form
// name = the instrument id, so we can find out how many instruments of a category there are.
// in a while loop keep getting the next id up and then add it to the linking table?