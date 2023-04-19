import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/adminf")
public class AdminFeedController extends HttpServlet {
    private AdminFeedDao adminFeedDao;

    public void init() throws ServletException {
        try {
            adminFeedDao = new AdminFeedDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<AdminFeed> adminFeeds = adminFeedDao.getAdminFeeds();
            request.setAttribute("adminFeeds", adminFeeds);
            // request.getRequestDispatcher("users.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminf.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve feedback", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String feeb = request.getParameter("feeb");
        try {
            AdminFeed adminFeed = new AdminFeed(id, feeb);
            adminFeedDao.addAdminFeed(adminFeed);
            response.sendRedirect("/myapp/adminf");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}
