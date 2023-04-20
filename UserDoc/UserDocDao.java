import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDocDao {

    private Connection connection;

    public UserDocDao() throws SQLException {
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

    public List<UserDoc> getDocs() throws SQLException {
        List<UserDoc> userDocs = new ArrayList<>();
        String sql = "SELECT * FROM doctorlist";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            UserDoc userDoc = new UserDoc(
                    resultSet.getString("doctorID"),
                    resultSet.getString("doctorName"),
                    resultSet.getString("doctorSp"));
            userDocs.add(userDoc);
        }
        System.out.println(userDocs);
        return userDocs;
    }

    public void addDoc(UserDoc userDoc) throws SQLException {
        String sql = "INSERT INTO doctorlist (doctorID, doctorName, doctorSp) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userDoc.getDoctorID());
        statement.setString(2, userDoc.getdoctorName());
        statement.setString(3, userDoc.getDoctorSp());
        statement.executeUpdate();
    }
}