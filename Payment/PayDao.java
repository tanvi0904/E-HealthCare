import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayDao {
    // create a connection obj to connect to the database
    private Connection connection;

    // constructor
    public PayDao() throws SQLException {
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

    public List<Pay> getAllpayments() throws SQLException {
        List<Pay> payments = new ArrayList<>();
        String sql = "SELECT * FROM pay";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Pay pay = new Pay(
                    resultSet.getString("userID"),
                    resultSet.getString("paymentType"),
                    resultSet.getString("paymentAmount"),
                    resultSet.getString("paymentDate"),
                    resultSet.getString("transactionID"),
                    resultSet.getString("verify"));
            payments.add(pay);
        }
        return payments;
    }

    // Making a payment
    public void makePayment(Pay pay) throws SQLException {
        String sql = "INSERT INTO pay (userID, paymentType, paymentAmount, paymentDate, transactionID, verify) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pay.getUserID());
        statement.setString(2, pay.getPaymentType());
        statement.setString(3, pay.getPaymentAmount());
        statement.setString(4, pay.getPaymentDate());
        statement.setString(5, pay.getTransactionID());
        statement.setString(6, "0");
        statement.executeUpdate();
    }
}
