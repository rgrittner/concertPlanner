package com.reneegrittner.controller;

import com.reneegrittner.entity.Musician;
import com.reneegrittner.persistence.GenericDao;
import com.sun.xml.internal.bind.v2.TODO;
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
        urlPatterns = {"/ensemble/deleteMusician"}
)

public class DeleteMusician extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("idOfMusicianToBeDeleted"));
        GenericDao dao = new GenericDao(Musician.class);
        req.setAttribute("musician", dao.getById(id));
        //TODO -- Figure out how to send the correct ID along with the get request.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/deleteMusician.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Musician musicianToBeDeleted = new Musician();
        Integer id = Integer.parseInt(req.getParameter("idOfMusicianToBeDeleted"));
        GenericDao dao = new GenericDao<>(Musician.class);
        logger.debug("id from delete doPost" + id);

        dao.delete(musicianToBeDeleted);







        String url = "/concertPlanner/ensemble/musicians";

        resp.sendRedirect(url);


    }
}
