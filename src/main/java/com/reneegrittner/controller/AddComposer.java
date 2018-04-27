package com.reneegrittner.controller;

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
import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        // New up a DAO for Nationality, DAO for Composer
        GenericDao<Nationality> nationalityDao = new GenericDao<>(Nationality.class);
        GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);

        // Get Id of selected Nationality from from, convert to Integer, get correct Nationality as an object
        Integer nationalityIdFromForm = Integer.parseInt(req.getParameter("nationality"));
        Nationality nationalityToInsert = nationalityDao.getById(nationalityIdFromForm);

        // Get Birth & Death year fields, check if they are null. If not convert to Integer, otherwise set to null
        // Required task for both add and update
        String checkBirthYear = req.getParameter("birthYear");
        String checkDeathYear = req.getParameter("deathYear");
        logger.debug("Birthyear as string: " + checkBirthYear + " Death year as string: " + checkDeathYear);
        Integer birthYear;
        Integer deathYear;

        if(checkBirthYear.length() > 0){
            birthYear = Integer.parseInt(checkBirthYear);
            logger.debug("birthyear from if >0" + birthYear);
        } else {
            birthYear = null;
            logger.debug("birthyear from else" + birthYear);
        }

        if(checkDeathYear.length() > 0){
            deathYear = Integer.parseInt(checkDeathYear);
            logger.debug("death year from if >0" + deathYear);
        } else {
            deathYear = null;
            logger.debug("deathyear from else" + deathYear);
        }

        // Is request a new composer or update to existing composer? 1 = new composer; 2 = update
        Integer isComposerNewOrUpdate = Integer.parseInt(req.getParameter("ComposerAddOrUpdate"));

        switch(isComposerNewOrUpdate){
            case 1:
                Composer composerToBeAdded = new Composer();
                composerToBeAdded.setNationality(nationalityToInsert);
                composerToBeAdded.setFirstName(req.getParameter("firstName"));
                composerToBeAdded.setLastName(req.getParameter("lastName"));
                composerToBeAdded.setBirthYear(birthYear);
                composerToBeAdded.setDeathYear(birthYear);
                composerToBeAdded.setUserId(userIdFromSignIn);

                composerGenericDao.insert(composerToBeAdded);
                break;
            case 2:
                Composer composerToUpdate = composerGenericDao.getById(Integer.parseInt(req.getParameter("composerId")));
                composerToUpdate.setFirstName(req.getParameter("firstName"));
                composerToUpdate.setLastName(req.getParameter("lastName"));
                logger.debug("deathyear from case: " + deathYear);
                logger.debug("birthyear from case: " + birthYear);

                composerToUpdate.setBirthYear(birthYear);
                composerToUpdate.setDeathYear(deathYear);


                composerGenericDao.saveOrUpdate(composerToUpdate);
                break;
        }




        //TODO add data verification
        //TODO check for exisiting composer





        String url = "/concertPlanner/ensemble/composers";

        resp.sendRedirect(url);


    }

}
