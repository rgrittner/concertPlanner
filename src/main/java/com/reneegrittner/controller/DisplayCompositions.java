package com.reneegrittner.controller;

import com.reneegrittner.entity.Composition;
import com.reneegrittner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/compositions"}
)


public class DisplayCompositions extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Composition.class);
        req.setAttribute("compositions", dao.getAll("title"));


        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/allCompositions.jsp");
        dispatcher.forward(req, resp);
    }

}
