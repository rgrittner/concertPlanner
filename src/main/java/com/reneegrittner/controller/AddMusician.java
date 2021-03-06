package com.reneegrittner.controller;

import com.reneegrittner.controllerLogic.MusicianLogic;
import com.reneegrittner.entity.Musician;
import com.reneegrittner.entity.User;
import com.reneegrittner.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet handles adding a new Musician.
 * This servlet is accessed from TODO fill this out
 * @author Renee Grittner
 */
@WebServlet(
        urlPatterns = {"/ensemble/addMusician"}
)
public class AddMusician extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/addMusician.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Get the user's Information
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);
        String userNameFromSignIn = req.getUserPrincipal().getName();
        int userIdFromSignIn = userGenericDao.getUser("userName", userNameFromSignIn).get(0).getId();

        MusicianLogic musicianLogic = new MusicianLogic();

        Musician musician = musicianLogic.createOrUpdateMusician(
                req.getParameter("musicianId")
                ,req.getParameter("firstName")
                ,req.getParameter("lastName")
                ,req.getParameter("phone")
                ,req.getParameter("email")
                ,req.getParameter("status")
                , userIdFromSignIn
        );

        Integer musicianId = null;
        GenericDao genericDao = new GenericDao(Musician.class);
        musicianId = musician.getId();
        if(musicianId == null){
            genericDao.insert(musician);
        }

        if(musicianId != null){
            genericDao.saveOrUpdate(musician);
        }

        String url = "/concertPlanner/ensemble/musicians";

        resp.sendRedirect(url);

        //TODO Data verifications
    }

}
