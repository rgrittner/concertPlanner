package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
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
        urlPatterns = {"/ensemble/composers"}
)
/**
 * This servlet queries the DB for all composers and makes the result set available to the jsp.
 * Accessed from: nav.jsp
 * @author Renee Grittner
 */
public class DisplayComposers extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        //Query for all composers for given user id, order on last Name. Set into request attribute
        GenericDao<Composer> dao = new GenericDao<>(Composer.class);
        req.setAttribute("composers", dao.getAll("lastName", userIdFromSignIn));

        // redirect user to composer list
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/composer.jsp");
        dispatcher.forward(req, resp);
    }

}
