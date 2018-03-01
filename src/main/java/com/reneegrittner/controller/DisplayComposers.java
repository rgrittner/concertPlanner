package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/composers"}
)

public class DisplayComposers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Composer.class);
        req.setAttribute("composers", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Composer.jsp");
        dispatcher.forward(req, resp);
    }

}
