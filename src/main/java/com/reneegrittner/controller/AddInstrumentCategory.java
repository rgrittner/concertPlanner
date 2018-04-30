package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.InstrumentLogic;
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
 * This servlet handles adding instrument categories.
 * This servlet is accessed from TODO fill this out
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addInstrumentCategory"}
)
public class AddInstrumentCategory extends HttpServlet {
    private InstrumentLogic instrumentLogic = new InstrumentLogic();
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/instruments.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userId = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();
        String errorMessage = "";
        String categoryToAdd = req.getParameter("category");
        boolean okToInsert = instrumentLogic.checkIfCategoryAlreadyExists(categoryToAdd, userId);

        if(okToInsert){
            instrumentLogic.addNewInstrumentCategory(categoryToAdd, userId);
        } else {
            errorMessage = categoryToAdd + " already Exists";

            logger.debug(errorMessage);
        }

        req.setAttribute("categoryAddError", errorMessage);
        String url = "/concertPlanner/ensemble/instruments";


        resp.sendRedirect(url);

        //TODO Data verifications
    }
}

//TODO finish up comments for methods in here