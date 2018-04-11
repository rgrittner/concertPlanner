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
public class ListOfCompositionsByComposer extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String composerIdFromForm = req.getParameter("composerId");
        Integer idFromParam = Integer.parseInt(req.getParameter("param"));


        GenericDao dao2 = new GenericDao<>(Composer.class);
        Composer composer = (Composer) dao2.getById(idFromParam);
        String composerFullName = composer.getLastName() + ", " + composer.getFirstName();

        GenericDao dao = new GenericDao<>(Composition.class);
        req.setAttribute("composerCompositions", dao.getByPropertyEqualComposition(idFromParam));
        req.setAttribute("composerName", composerFullName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/compositionsOfComposer.jsp");
        dispatcher.forward(req, resp);
    }
}
