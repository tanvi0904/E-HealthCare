import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/userf")
public class UserFeedController extends HttpServlet {
    private UserFeedDao userFeedDao;

    public void init() throws ServletException {
        try {
            userFeedDao = new UserFeedDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<UserFeed> userFeeds = userFeedDao.getUserFeeds();
            request.setAttribute("userFeeds", userFeeds);
            // request.getRequestDispatcher("users.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userf.jsp");
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
            UserFeed userFeed = new UserFeed(id, feeb);
            userFeedDao.addUserFeed(userFeed);
            response.sendRedirect("/myapp/userf");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}
