package com.reneegrittner.controller;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/instruments"}
)
/**
 * This servlet queries the DB for all Instruments and their categories, makes the result set available to the jsp.
 * @author Renee Grittner
 */
public class DisplayInstruments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);
        GenericDao<InstrumentCategory> dao2 = new GenericDao<>(InstrumentCategory.class);

        //TODO Does this page really need to set the categories and the instruments?
        //TODO Arent the categtoeis accessable on the instruments themselves?
        req.setAttribute("instruments", dao.getAll("name"));
        req.setAttribute("categories", dao2.getAll("category"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/instruments.jsp");
        dispatcher.forward(req, resp);


    }
}
