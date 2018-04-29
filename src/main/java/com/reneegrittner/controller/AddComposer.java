package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.ComposerLogic;
import com.reneegrittner.entity.Composer;

import com.reneegrittner.entity.Nationality;
import com.reneegrittner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to handle adding a new Composer, contains a doGet and doPost method.
 */
@WebServlet(
        urlPatterns = {"/ensemble/addComposer"}
)

public class AddComposer extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * doGet method handles populating the Nationality select options with currently available nationalities
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

        GenericDao<Nationality> dao = new GenericDao<>(Nationality.class);
        req.setAttribute("nationality", dao.getAll("nationality", userIdFromSignIn));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addComposer.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * doPost method handles adding the composer to the database
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        // For data validation
//        Map<String, String> messages = new HashMap<>();
//        req.setAttribute("messages", messages);

        GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);


        // Is request a new composer or update to existing composer? 1 = new composer; 2 = update
        Integer isComposerNewOrUpdate = Integer.parseInt(req.getParameter("ComposerAddOrUpdate"));

        ComposerLogic composerLogic = new ComposerLogic();
        Composer composer = composerLogic.createComposer(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("birthYear"),
                req.getParameter("deathYear"),
                req.getParameter("nationality"),
                req.getParameter("composerId"),
                userIdFromSignIn);

        switch(isComposerNewOrUpdate){
            case 1:

                composerGenericDao.insert(composer);
                break;
            case 2:

                composerGenericDao.saveOrUpdate(composer);
                break;
        }

        //TODO add data verification
        //TODO check for exisiting composer

        String url = "/concertPlanner/ensemble/composers";

        resp.sendRedirect(url);


    }

}
