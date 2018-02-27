package controller;

import entity.Composition;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/compositions"}
)


public class DisplayCompositions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Composition.class);
        req.setAttribute("compositions", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Composition.jsp");
        dispatcher.forward(req, resp);
    }

}
