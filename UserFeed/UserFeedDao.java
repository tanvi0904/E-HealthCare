import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFeedDao {
    private Connection connection;

    public UserFeedDao() throws SQLException {
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

    public void addUserFeed(UserFeed userFeed) throws SQLException {
        String sql = "INSERT INTO feedback (id, feeb) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userFeed.getId());
        statement.setString(2, userFeed.getFeeb());
        statement.executeUpdate();
    }

    public List<UserFeed> getUserFeeds() throws SQLException {
        List<UserFeed> userFeeds = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String feeb = resultSet.getString("feeb");
            UserFeed userFeed = new UserFeed(id, feeb);
            userFeeds.add(userFeed);
        }
        System.out.println(userFeeds);
        return userFeeds;
    }
}
