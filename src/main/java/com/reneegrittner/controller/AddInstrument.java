package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.InstrumentLogic;
import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
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

/**
 * Servlet to handle adding new Instruments.
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addInstrument"}
)
public class AddInstrument extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<InstrumentCategory> categoryDao = new GenericDao<>(InstrumentCategory.class);


    /**
     * doGet method handles populating the instrument category select item
     * This method is accessed from instruments.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        req.setAttribute("category", categoryDao.getAll("category", userIdFromSignIn));

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
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        // New up required objects
        InstrumentLogic instrumentLogic = new InstrumentLogic();
        GenericDao<Instrument> genericDao = new GenericDao<>(Instrument.class);
        Instrument instrument;

        // Retrieve edit or addition value to switch on
        Integer editOrAddition = Integer.parseInt(req.getParameter("addOrEdit"));

        /*
            Switch based on hidden input field in modal forms
            1 = new Instrument
            2 = edit of Instrument
         */
        switch(editOrAddition){
            case 1:
                instrument = instrumentLogic.createOrUpdateInstrument(
                        req.getParameter("instrument")
                        ,req.getParameter("newInstrumentCategory")
                        , userIdFromSignIn
                        , "");

                genericDao.insert(instrument);
                break;

            case 2:
                 instrument = instrumentLogic.createOrUpdateInstrument(
                        req.getParameter("instrumentEdit")
                        ,req.getParameter("editInstrumentCategory")
                        , userIdFromSignIn
                        , req.getParameter("instrumentId"));

                genericDao.saveOrUpdate(instrument);
                break;

        }

        String url = "/concertPlanner/ensemble/instruments";

        resp.sendRedirect(url);
        //TODO data verification

    }

}
