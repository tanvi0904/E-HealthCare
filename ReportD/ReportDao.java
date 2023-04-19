import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDao {
    private Connection connection;

    public ReportDao() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/MVC";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }

    public void addReport(Report report) throws SQLException {
        String sql = "UPDATE appointment SET report = ? WHERE pid = ? AND did = ? AND date_time = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, report.getReport());
        statement.setString(2, report.getPid());
        statement.setString(3, report.getDid());
        statement.setString(4, report.getDate_time());
        statement.executeUpdate();
    }

    public List<Report> getAllReports() throws SQLException {
        List<Report> reports = new ArrayList<>();
        String sql = "SELECT * FROM appointment";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String pid = resultSet.getString("pid");
            String did = resultSet.getString("did");
            String date_time = resultSet.getString("date_time");
            String report1 = resultSet.getString("report");
            Report report = new Report(pid, did, date_time, report1);
            reports.add(report);
        }
        System.out.println(reports);
        return reports;
    }
}