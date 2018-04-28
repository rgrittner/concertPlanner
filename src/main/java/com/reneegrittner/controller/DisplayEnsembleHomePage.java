package com.reneegrittner.controller;



import com.reneegrittner.entity.Program;
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

@WebServlet(
        urlPatterns = {"/ensemble/home"}
)
/*
  This servlet generates the home page for the ensemble.
  Accessed from: after successful login.
  TODO Add table for upcoming performances
  @author Renee Grittner
 */
public class DisplayEnsembleHomePage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        // Query the db for upcoming concerts
        GenericDao<Program> programGenericDao = new GenericDao<>(Program.class);
        req.setAttribute("programs", programGenericDao.getAll(userIdFromSignIn));
        String url = "/protected/ensembleHome.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }




}
