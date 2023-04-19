import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/appo")
public class AppoController extends HttpServlet {
    private AppoDao appoDao;

    public void init() throws ServletException {
        try {
            appoDao = new AppoDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Appo> appos = appoDao.getAllAppos();
            request.setAttribute("appos", appos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/appo.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve appos", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("pid");
        String did = request.getParameter("did");
        String date_time = request.getParameter("date_time");
        String Report = "Not yet";
        try {
            Appo appo = new Appo(pid, did, date_time, Report);
            appoDao.addAppo(appo);
            response.sendRedirect("/myapp/appo");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}