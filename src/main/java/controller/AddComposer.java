package controller;

import entity.Composer;
import entity.Nationality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/addComposer"}
)

public class AddComposer extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Nationality.class);
        req.setAttribute("nationality", dao.getAll());
        logger.info("hello?");
        logger.debug("hello?");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addComposer.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Composer composerToBeAdded = new Composer();
        Nationality nationalityToInsert = new Nationality();
        GenericDao nationalityDao = new GenericDao(Nationality.class);
        String nationalityFromForm = req.getParameter("nationality");
        logger.debug("nationality from form" + nationalityFromForm);


//        composerToBeAdded.setFirstName(req.getParameter("firstName"));
//        composerToBeAdded.setLastName(req.getParameter("lastName"));
//        composerToBeAdded.setNationality(req.getParameter("phone"));
//        composerToBeAdded.setBirthYear(Integer.parseInt(req.getParameter("birthYear")));
//        composerToBeAdded.setDeathYear(Integer.parseInt(req.getParameter("deathYear")));





                // Check for someone that already exists?
        // If not found then add?

        // Search by object? search by two parameters?

//        GenericDao genericDao = new GenericDao(Composer.class);
//
//        genericDao.insert(composerToBeAdded);


        String url = "/composers";

        resp.sendRedirect(url);


    }

}
