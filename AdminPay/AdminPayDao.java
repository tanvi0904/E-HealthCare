import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminPayDao {
    // create a connection obj to connect to the database
    private Connection connection;

    // constructor
    public AdminPayDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // connect to the database
        String url = "jdbc:mysql://localhost:3306/MVC"; // CHANGE DB NAME
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }

    public List<AdminPay> getAllpayments() throws SQLException {
        List<AdminPay> adminPays = new ArrayList<>();
        String sql = "SELECT * FROM pay";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            AdminPay adminPay = new AdminPay(
                    resultSet.getString("userID"),
                    resultSet.getString("paymentType"),
                    resultSet.getString("paymentAmount"),
                    resultSet.getString("paymentDate"),
                    resultSet.getString("transactionID"),
                    resultSet.getString("verify"));
            adminPays.add(adminPay);
        }
        return adminPays;
    }

    // Making a payment
    public void makePayment(AdminPay adminPay) throws SQLException {
        String sql = "UPDATE pay SET verify = ? WHERE userID = ? AND paymentType = ? AND paymentAmount = ? AND paymentDate = ? AND transactionID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, adminPay.getVerify());
        statement.setString(2, adminPay.getUserID());
        statement.setString(3, adminPay.getPaymentType());
        statement.setString(4, adminPay.getPaymentAmount());
        statement.setString(5, adminPay.getPaymentDate());
        statement.setString(6, adminPay.getTransactionID());
        statement.executeUpdate();
    }
}
