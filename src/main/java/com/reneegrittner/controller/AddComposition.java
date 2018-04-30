package com.reneegrittner.controller;

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

/**
 * Servlet for handling adding a Composition.
 * This servlet is accessed from:
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addComposition"}
)
public class AddComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Composition> compositionGenericDao = new GenericDao<>(Composition.class);



    /**
     * doGet method populates composer select items with current list of composers
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
        GenericDao dao = new GenericDao<>(Composer.class);
        req.setAttribute("composers", dao.getAll("lastName", userIdFromSignIn));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addComposition.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * doPost method handles adding a composition to the database
     * This method is accessed from addComposition.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        CompositionLogic compositionLogic = new CompositionLogic();


        Composition compositionToBeAddedOrUpdated = compositionLogic.createComposition(
                req.getParameter("compositionId")
                ,req.getParameter("title")
                ,req.getParameter("arranger")
                ,req.getParameter("composer")
                ,req.getParameter("duration")
                ,req.getParameter("year")
                ,req.getParameter("clocksCommission")
                ,req.getParameter("numberOfPlayers")
                ,req.getParameter("notes")
                , userIdFromSignIn
        );

        int isCompositionNewOrUpdate = Integer.parseInt(req.getParameter("CompositionAddOrUpdate"));
        switch(isCompositionNewOrUpdate){
            case 1:

                compositionGenericDao.insert(compositionToBeAddedOrUpdated);
                break;
            case 2:

                compositionGenericDao.saveOrUpdate(compositionToBeAddedOrUpdated);
                break;
        }

        GenericDao genericDao = new GenericDao<>(Composition.class);
        //genericDao.insert(compositionToBeAddedOrUpdated);

        String url = "";
        if(req.getParameter("returnToComposition") == null){
            url = "/concertPlanner/ensemble/compositions";
        } else {
            String compositionId = req.getParameter("returnToComposition");
            url = "/concertPlanner/ensemble/singleComposition?param=" + compositionId;
        }


        resp.sendRedirect(url);


    }
}
