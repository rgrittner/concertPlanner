package contorller;


import persistence.MusicianDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/musicians"}
)

public class DisplayMusicians extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MusicianDao dao = new MusicianDao();
        req.setAttribute("musicians", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/musician.jsp");
        dispatcher.forward(req, resp);
    }


}
