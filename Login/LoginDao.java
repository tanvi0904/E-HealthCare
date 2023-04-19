import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    // create a connection obj to connect to the database
    private Connection connection;

    // constructor
    public LoginDao() throws SQLException {
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

    public List<Login> getAllLogins() throws SQLException {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM login";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Login login = new Login(
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("role"));
            logins.add(login);
        }
        return logins;
    }

    // Check if login is valid
    public boolean validate(Login login) throws SQLException {
        String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login.getUsername());
        statement.setString(2, login.getPassword());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    // If login is successful then get the role of the user
    public String getRole(Login login) throws SQLException {
        String sql = "SELECT role FROM login WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login.getUsername());
        statement.setString(2, login.getPassword());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("role");
        }
        return null;
    }

    // Account creation
    public void Signup(Login login) throws SQLException {
        String sql = "INSERT INTO login (username, password, role) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login.getUsername());
        statement.setString(2, login.getPassword());
        statement.setString(3, login.getRole());
        statement.executeUpdate();
    }

}
