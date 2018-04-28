package com.reneegrittner.controller;


import com.reneegrittner.entity.Musician;
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
        urlPatterns = {"/ensemble/musicians"}
)
/*
  This servlet queries the DB for all musicians, making the result set available to the jsp
  @author Renee Grittner
 */
public class DisplayMusicians extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Display Musicians");
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        GenericDao<Musician> dao = new GenericDao<>(Musician.class);
        req.setAttribute("musicians", dao.getAll("lastName", userIdFromSignIn));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/musician.jsp");
        dispatcher.forward(req, resp);
    }




}
