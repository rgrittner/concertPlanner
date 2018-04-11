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

/**
 * Servlet to handle adding new Instruments.
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addInstrument"}
)
public class AddInstrument extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method handles populating the instrument category select item
     * This method is accessed from //TODO fill this out
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao<>(InstrumentCategory.class);
        req.setAttribute("category", dao.getAll("category"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addInstrument.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * doPost method to add Instruments to the database
     * This method is accessed from TODO fill this out
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Instrument instrument = new Instrument();
        GenericDao categoryDao = new GenericDao<>(InstrumentCategory.class);

        // Get Id of selected Category from from, convert to Integer
        Integer categoryIdFromForm = Integer.parseInt(req.getParameter("newInstrumentCategory"));


        // Get the correct Category object from the DAO
        InstrumentCategory categoryToInsert = (InstrumentCategory) categoryDao.getById(categoryIdFromForm);


        instrument.setName(req.getParameter("instrument"));
        instrument.setInstrumentCategory(categoryToInsert);

        GenericDao<Instrument> genericDao = new GenericDao<>(Instrument.class);

        genericDao.insert(instrument);

        String url = "/concertPlanner/ensemble/instruments";

        resp.sendRedirect(url);
        //TODO data verification

    }

}
