import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/userdoc")

public class UserDocController extends HttpServlet {
    private UserDocDao userDocDao;

    public void init() throws ServletException {
        try {
            userDocDao = new UserDocDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<UserDoc> userDocs = userDocDao.getDocs();
            request.setAttribute("userDocs", userDocs);
            // request.getRequestDispatcher("users.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userdoc.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve users", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String doctorID = request.getParameter("doctorID");
        String doctorName = request.getParameter("doctorName");
        String doctorSp = request.getParameter("doctorSp");
        try {
            UserDoc userDoc = new UserDoc(doctorID, doctorName, doctorSp);
            userDocDao.addDoc(userDoc);
            response.sendRedirect("/myapp/userdoc");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }

}
