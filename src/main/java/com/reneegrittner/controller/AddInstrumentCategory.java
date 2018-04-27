package com.reneegrittner.controller;

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

/**
 * This servlet handles adding instrument categories.
 * This servlet is accessed from TODO fill this out
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addInstrumentCategory"}
)
public class AddInstrumentCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/instruments.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        InstrumentCategory categoryToBeAdded = new InstrumentCategory();
        categoryToBeAdded.setCategory(req.getParameter("category"));
        categoryToBeAdded.setUserId(userIdFromSignIn);

        GenericDao<InstrumentCategory> genericDao = new GenericDao<>(InstrumentCategory.class);

        genericDao.insert(categoryToBeAdded);

        String url = "/concertPlanner/ensemble/instruments";

        resp.sendRedirect(url);

        //TODO Data verifications
    }
}

//TODO finish up comments for methods in here