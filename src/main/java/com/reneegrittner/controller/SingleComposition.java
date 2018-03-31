package com.reneegrittner.controller;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Composition;
import com.reneegrittner.entity.CompositionInstrument;
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
        urlPatterns = {"/ensemble/singleComposition"}
)
public class SingleComposition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer idFromParam = Integer.parseInt(req.getParameter("param"));


        GenericDao dao2 = new GenericDao<>(Composer.class);


        GenericDao compositionDao = new GenericDao<>(Composition.class);
        Composition composition = (Composition) compositionDao.getById(idFromParam);

        Integer composerId = composition.getComposer().getId();
        Composer composer = (Composer) dao2.getById(composerId);

        GenericDao dao = new GenericDao<>(Composition.class);
        Integer compositionId = composition.getId();
        GenericDao<CompositionInstrument> linkingDao = new GenericDao<>(CompositionInstrument.class);

        req.setAttribute("compositionInformation", composition);
        req.setAttribute("composerInformation", composer);
        req.setAttribute("playerOneInstruments", linkingDao.getByPropertyEqualCompositionInstrument(1, compositionId));
        req.setAttribute("playerTwoInstruments", linkingDao.getByPropertyEqualCompositionInstrument(2, compositionId));
        req.setAttribute("playerThreeInstruments", linkingDao.getByPropertyEqualCompositionInstrument(3, compositionId));
        req.setAttribute("playerFourInstruments", linkingDao.getByPropertyEqualCompositionInstrument(4, compositionId));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/protected/singleComposition.jsp");
        dispatcher.forward(req, resp);
        logger.debug("from servlet: " + dao.getByPropertyEqualComposition(idFromParam));
    }
}
