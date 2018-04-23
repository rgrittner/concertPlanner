package com.reneegrittner.controller;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.entity.User;
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
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);
        GenericDao<InstrumentCategory> dao2 = new GenericDao<>(InstrumentCategory.class);

        req.setAttribute("instruments", dao.getAll("name", userIdFromSignIn));

        // Make categories available to the add category modal
        req.setAttribute("categories", dao2.getAll("category", userIdFromSignIn));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/instruments.jsp");
        dispatcher.forward(req, resp);
    }
}
