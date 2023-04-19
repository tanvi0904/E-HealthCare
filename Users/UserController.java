import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private UserDao userDao;

    public static void main(String[] args) {
        // code to start your application goes here
    }

    public void init() throws ServletException {
        try {
            userDao = new UserDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<User> users = userDao.getUsers();
            request.setAttribute("users", users);
            // request.getRequestDispatcher("users.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/users.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve users", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String bg = request.getParameter("bg");
        String donation = request.getParameter("donation");
        try {
            User user = new User(id, name, age, bg, donation);
            userDao.addUser(user);
            response.sendRedirect("/myapp/users");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}