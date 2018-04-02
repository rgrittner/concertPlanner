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

@WebServlet(
        urlPatterns = {"/ensemble/addComposer"}
)

public class AddComposer extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Nationality.class);
        req.setAttribute("nationality", dao.getAll("nationality"));
        logger.info("hello?");
        logger.debug("hello?");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addComposer.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Composer composerToBeAdded = new Composer();
        Nationality nationalityToInsert = new Nationality();
        GenericDao nationalityDao = new GenericDao(Nationality.class);

        // Get Id of selected Nationality from from, convert to Integer
        Integer nationalityIdFromForm = Integer.parseInt(req.getParameter("nationality"));
        logger.debug("nationality Id from form: " + nationalityIdFromForm);

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





                // Check for someone that already exists?
        // If not found then add?

        // Search by object? search by two parameters?

        GenericDao genericDao = new GenericDao(Composer.class);

        genericDao.insert(composerToBeAdded);


        String url = "/ensemble/protected/composers";

        resp.sendRedirect(url);


    }

}
