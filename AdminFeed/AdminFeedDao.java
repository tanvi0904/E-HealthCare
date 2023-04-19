import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminFeedDao {
    private Connection connection;

    public AdminFeedDao() throws SQLException {
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

    public void addAdminFeed(AdminFeed adminFeed) throws SQLException {
        String sql = "INSERT INTO feedback (id, feeb) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, adminFeed.getId());
        statement.setString(2, adminFeed.getFeeb());
        statement.executeUpdate();
    }

    public List<AdminFeed> getAdminFeeds() throws SQLException {
        List<AdminFeed> adminFeeds = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String feeb = resultSet.getString("feeb");
            AdminFeed adminFeed = new AdminFeed(id, feeb);
            adminFeeds.add(adminFeed);
        }
        System.out.println(adminFeeds);
        return adminFeeds;
    }
}
