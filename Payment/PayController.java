import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/pay")
public class PayController extends HttpServlet {
    private PayDao payDao;

    public void init() throws ServletException {
        try {
            payDao = new PayDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Pay> payments = payDao.getAllpayments();
            request.setAttribute("payments", payments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pay.jsp");
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
        String verify = "0";
        try {
            Pay payment = new Pay(userID, paymentType, paymentAmount, paymentDate, transactionID, verify);
            payDao.makePayment(payment);
            response.sendRedirect("/myapp/pay");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}