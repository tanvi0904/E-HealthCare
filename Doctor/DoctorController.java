import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/doctor")

public class DoctorController extends HttpServlet {
    private DoctorDao doctorDao;

    public void init() throws ServletException {
        try {
            doctorDao = new DoctorDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Doctor> doctors = doctorDao.getDocs();
            request.setAttribute("doctors", doctors);
            // request.getRequestDispatcher("users.jsp").forward(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/doctor.jsp");
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
            Doctor doc = new Doctor(doctorID, doctorName, doctorSp);
            doctorDao.addDoc(doc);
            response.sendRedirect("/myapp/doctor");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }

}
