package com.reneegrittner.controller;

import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/addPlayerInstrumentation"}
)
public class AddInstrumentationStart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(InstrumentCategory.class);
        req.setAttribute("instrumentCat", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addInstrumentationStart.jsp");
        dispatcher.forward(req, resp);
    }
}
