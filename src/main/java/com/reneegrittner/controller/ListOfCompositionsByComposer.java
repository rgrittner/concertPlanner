package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;
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
        urlPatterns = {"/ensemble/compositionsByComposer"}
)
/**
 * This servlet queries the DB for a list of compositions by a provided composer.
 * Accessed from: TODO fill this out
 * @author Renee Grittner
 */
public class ListOfCompositionsByComposer extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO find out why there is composerIDFromForm and idFromParam.
        String composerIdFromForm = req.getParameter("composerId");
        Integer idFromParam = Integer.parseInt(req.getParameter("param"));

        GenericDao<Composer> dao2 = new GenericDao<>(Composer.class);
        Composer composer = dao2.getById(idFromParam);
        String composerFullName = composer.getLastName() + ", " + composer.getFirstName();

        GenericDao<Composition> dao = new GenericDao<>(Composition.class);
        req.setAttribute("composerCompositions", dao.getByPropertyEqualComposition(idFromParam));
        req.setAttribute("composerName", composerFullName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/compositionsOfComposer.jsp");
        dispatcher.forward(req, resp);
    }
}
