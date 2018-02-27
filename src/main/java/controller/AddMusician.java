package controller;

import entity.Musician;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/addMusician"}
)
public class AddMusician extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GenericDao dao = new GenericDao(Musician.class);
        //req.setAttribute("musicians", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addMusician.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Musician musicianToBeAdded = new Musician();
        musicianToBeAdded.setFirstName(req.getParameter("firstName"));
        musicianToBeAdded.setLastName(req.getParameter("lastName"));
        musicianToBeAdded.setPhoneNumber(req.getParameter("phone"));

        // Check for someone that already exists?
        // If not found then add?

        // Search by object? search by two parameters?

        GenericDao genericDao = new GenericDao(Musician.class);

        genericDao.insert(musicianToBeAdded);


        String url = "/musicians";

        resp.sendRedirect(url);


    }

}
