import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppoDao {
    private Connection connection;

    public AppoDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/MVC";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }

    public void addAppo(Appo appo) throws SQLException {
        // check if an appointment already exists with the same did and date_time
        String checkSql = "SELECT pid FROM appointment WHERE did = ? AND date_time = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkSql);
        checkStatement.setString(1, appo.getDid());
        checkStatement.setString(2, appo.getDate_time());
        ResultSet resultSet = checkStatement.executeQuery();

        // if an appointment already exists, throw an exception
        if (resultSet.next()) {
            throw new SQLException("An appointment with the same did and date_time already exists");
        }

        // insert the new appointment
        String insertSql = "INSERT INTO appointment (pid, did, date_time, report) VALUES (?, ?, ?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
        insertStatement.setString(1, appo.getPid());
        insertStatement.setString(2, appo.getDid());
        insertStatement.setString(3, appo.getDate_time());
        insertStatement.setString(4, "Not yet");
        insertStatement.executeUpdate();
    }

    public List<Appo> getAllAppos() throws SQLException {
        List<Appo> appos = new ArrayList<>();
        String sql = "SELECT * FROM appointment";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String pid = resultSet.getString("pid");
            String did = resultSet.getString("did");
            String date_time = resultSet.getString("date_time");
            String report = resultSet.getString("report");
            Appo appo = new Appo(pid, did, date_time, report);
            appos.add(appo);
        }
        System.out.println(appos);
        return appos;
    }
}