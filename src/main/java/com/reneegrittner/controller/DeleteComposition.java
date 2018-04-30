package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.CompositionLogic;
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
        urlPatterns = {"/ensemble/deleteComposition"}
)
public class DeleteComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private CompositionLogic compositionLogic = new CompositionLogic();
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userId = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        Integer id = Integer.parseInt(req.getParameter("idOfCompositionToBeDeleted"));

        boolean okToDelete = compositionLogic.canThisCompositionBeDeleted(id, userId);

        if(okToDelete){
            req.setAttribute("okToDelete", true);
        } else {
            req.setAttribute("okToDelete", false);
            req.setAttribute("instruments", compositionLogic.listOfInstrumentsForThisComposition(id, userId));
        }

        req.setAttribute("composition", compositionGenericDao.getById(id));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/deleteComposition.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get id from the form, this is a hidden input field
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userId = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        compositionLogic.deleteComposition(Integer.parseInt(req.getParameter("idOfCompositionToBeDeleted")), userId);


        // Redirect back to list of musicians
        String url = "/concertPlanner/ensemble/compositions";
        resp.sendRedirect(url);


    }

}
