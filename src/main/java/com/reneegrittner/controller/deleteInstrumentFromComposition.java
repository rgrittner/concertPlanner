package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.CompositionInstrumentLogic;
import com.reneegrittner.entity.CompositionInstrument;
import com.reneegrittner.entity.User;
import com.reneegrittner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/deleteInstrumentFromComposition"}
)
public class deleteInstrumentFromComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private CompositionInstrumentLogic compositionInstrumentLogic = new CompositionInstrumentLogic();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String compositionId = req.getParameter("compositionId");

        Integer id = Integer.parseInt(req.getParameter("compositionInstrumentId"));
        compositionInstrumentLogic.deleteInstrumentFromCompositionById(id);

        String url = "http://localhost:8080/concertPlanner/ensemble/singleComposition?param=" + compositionId;
        resp.sendRedirect(url);


    }
}
