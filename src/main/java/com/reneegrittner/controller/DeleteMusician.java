package com.reneegrittner.controller;

import com.reneegrittner.entity.Musician;
import com.reneegrittner.persistence.GenericDao;
import com.sun.xml.internal.bind.v2.TODO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/ensemble/deleteMusician"}
)

public class DeleteMusician extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("musicianId"));
        GenericDao dao = new GenericDao(Musician.class);
       // req.setAttribute("musicians", dao.getById("id"));
        //TODO -- Figure out how to send the correct ID along with the get request. 
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/musician.jsp");
        dispatcher.forward(req, resp);
    }
}
