package com.reneegrittner.controller;


import com.reneegrittner.entity.Musician;
import com.reneegrittner.persistence.GenericDao;

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
/**
 * This servlet queries the DB for all musicians, making the result set available to the jsp
 * @author Renee Grittner
 */
public class DisplayMusicians extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Musician> dao = new GenericDao<>(Musician.class);
        req.setAttribute("musicians", dao.getAll("lastName"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/musician.jsp");
        dispatcher.forward(req, resp);
    }




}
