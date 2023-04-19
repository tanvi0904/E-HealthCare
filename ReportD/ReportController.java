import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/report")
public class ReportController extends HttpServlet {
    private ReportDao reportDao;

    public void init() throws ServletException {
        try {
            reportDao = new ReportDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Report> reports = reportDao.getAllReports();
            request.setAttribute("reports", reports);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/report.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve report", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid = request.getParameter("pid");
        String did = request.getParameter("did");
        String date_time = request.getParameter("date_time");
        String report1 = request.getParameter("report");
        try {
            Report report = new Report(pid, did, date_time, report1);
            reportDao.addReport(report);
            response.sendRedirect("/myapp/report");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}