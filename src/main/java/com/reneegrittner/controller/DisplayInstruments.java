package com.reneegrittner.controller;

import com.reneegrittner.entity.Instrument;
import com.reneegrittner.entity.InstrumentCategory;
import com.reneegrittner.entity.Musician;
import com.reneegrittner.persistence.GenericDao;
import sun.net.www.content.text.Generic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/ensemble/instruments"}
)
public class DisplayInstruments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Instrument.class);
        GenericDao dao2 = new GenericDao(InstrumentCategory.class);

        req.setAttribute("instruments", dao.getAll());
        req.setAttribute("categories", dao2.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/instruments.jsp");
        dispatcher.forward(req, resp);


    }
}
