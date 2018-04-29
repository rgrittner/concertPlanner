package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.ComposerLogic;
import com.reneegrittner.controllerLogic.CompositionLogic;
import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
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
        urlPatterns = {"/ensemble/compositions"}
)

/*
  This servlet queries the DB for all compositions, makes result set available to the jsp.
  Accessed from: nav.jsp.
  @author Renee Grittner
 */
public class DisplayCompositions extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);
    private GenericDao<User> userGenericDao = new GenericDao<>(User.class);
    private  GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user's Information
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userId = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        // Query the database for all compositions for a given user Id. Order on title. Set request attribute
        req.setAttribute("compositions", compositionGenericDao.getAll("title", userId));

        //Query for Composers to populate add modal select options
        req.setAttribute("composers", composerGenericDao.getAll("lastName", userId));

        //Redirect the user
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/allCompositions.jsp");
        dispatcher.forward(req, resp);
    }

}
