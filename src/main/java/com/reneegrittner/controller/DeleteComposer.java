package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.ComposerLogic;
import com.reneegrittner.entity.Composer;
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
        urlPatterns = {"/ensemble/deleteComposer"}
)
public class DeleteComposer extends HttpServlet{
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ComposerLogic composerLogic = new ComposerLogic();
    private GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        Integer id = Integer.parseInt(req.getParameter("idOfComposerToBeDeleted"));

        boolean okToDelete = composerLogic.canThisComposerBeDeleted(id, userIdFromSignIn);

        if(okToDelete){
            req.setAttribute("okToDelete", true);
        } else {
            req.setAttribute("okToDelete", false);
            req.setAttribute("compositions", composerLogic.listOfCompositionsForThisComposer(id, userIdFromSignIn));
        }

        req.setAttribute("composer", composerGenericDao.getById(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/deleteComposer.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get id from the form, this is a hidden input field
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userId = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        composerLogic.deleteComposer(Integer.parseInt(req.getParameter("idOfComposerToBeDeleted")), userId);


        // Redirect back to list of musicians
        String url = "/concertPlanner/ensemble/composers";
        resp.sendRedirect(url);


    }
}
