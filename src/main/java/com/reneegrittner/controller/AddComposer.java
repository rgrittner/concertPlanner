package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;

import com.reneegrittner.entity.Nationality;
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
        GenericDao dao = new GenericDao(Nationality.class);
        req.setAttribute("nationality", dao.getAll("nationality"));
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
        Composer composerToBeAdded = new Composer();
        Nationality nationalityToInsert = new Nationality();
        GenericDao nationalityDao = new GenericDao(Nationality.class);

        // Get Id of selected Nationality from from, convert to Integer
        Integer nationalityIdFromForm = Integer.parseInt(req.getParameter("nationality"));

        // Get the correct Nationality object from the DAO
        nationalityToInsert = (Nationality)nationalityDao.getById(nationalityIdFromForm);

        // Get Birth & Death year fields, check if they are null. If not convert to Integer, otherwise set to null
        String checkBirthYear = req.getParameter("birthYear");
        String checkDeathYear = req.getParameter("deathYear");
        Integer birthYear;
        Integer deathYear;

        if(checkBirthYear.length() > 0){
            birthYear = Integer.parseInt(checkBirthYear);
        } else {
            birthYear = null;
        }

        if(checkDeathYear.length() > 0){
            deathYear = Integer.parseInt(checkDeathYear);
        } else {
            deathYear = null;
        }


        composerToBeAdded.setFirstName(req.getParameter("firstName"));
        composerToBeAdded.setLastName(req.getParameter("lastName"));
        composerToBeAdded.setNationality(nationalityToInsert);
        composerToBeAdded.setBirthYear(birthYear);
        composerToBeAdded.setDeathYear(deathYear);

        //TODO add data verification
        //TODO check for exisiting composer

        GenericDao genericDao = new GenericDao(Composer.class);

        genericDao.insert(composerToBeAdded);


        String url = "/concertPlanner/ensemble/composers";

        resp.sendRedirect(url);


    }

}
