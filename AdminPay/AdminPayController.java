import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/adminpay")
public class AdminPayController extends HttpServlet {
    private AdminPayDao adminPayDao;

    public void init() throws ServletException {
        try {
            adminPayDao = new AdminPayDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<AdminPay> adminPays = adminPayDao.getAllpayments();
            request.setAttribute("adminPays", adminPays);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminpay.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve users", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String paymentType = request.getParameter("paymentType");
        String paymentAmount = request.getParameter("paymentAmount");
        String paymentDate = request.getParameter("paymentDate");
        String transactionID = request.getParameter("transactionID");
        String verify = request.getParameter("verify");
        try {
            AdminPay payment = new AdminPay(userID, paymentType, paymentAmount, paymentDate, transactionID, verify);
            adminPayDao.makePayment(payment);
            response.sendRedirect("/myapp/adminpay");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}