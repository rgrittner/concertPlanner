package com.reneegrittner.controller;

import com.reneegrittner.entity.Instrument;
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
        urlPatterns = {"/ensemble/addPlayerInstrumentation/category"}
)
public class DisplayAddPlayerInstCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryIdFromParam = Integer.parseInt(req.getParameter("categoryId"));
        GenericDao<Instrument> dao = new GenericDao<>(Instrument.class);
        req.setAttribute("instrumentList", dao.getByPropertyEqual("instrumentCategory", categoryIdFromParam));
        String url = "";
        switch (categoryIdFromParam) {
            case 1: url = "/protected/addKeyboards.jsp";
                    break;
            case 2: url = "/protected/addSkins.jsp";
                    break;
            case 3: url = "/protected/addWoods.jsp";
                    break;
            case 4: url = "/protected/addMetals.jsp";
                    break;
            case 5: url = "/protected/addOther.jsp";
                    break;
            case 6: url = "/protected/addTimpani.jsp";
                    break;
            case 7: url = "/protected/addAccessory.jsp";
                    break;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
