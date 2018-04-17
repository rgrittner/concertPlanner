package com.reneegrittner.controller;


import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet handles adding nationalities.
 * This servlet is accessed from addComposer.jsp from a modal.
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addNationality"}
)
public class AddNationality extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Nationality nationalityToBeAdded = new Nationality();
        nationalityToBeAdded.setNationality(req.getParameter("newNationality"));

        GenericDao<Nationality> genericDao = new GenericDao<>(Nationality.class);

        genericDao.insert(nationalityToBeAdded);

        String url = "/concertPlanner/ensemble/addComposer";

        resp.sendRedirect(url);

        //TODO Data verifications
    }
}
