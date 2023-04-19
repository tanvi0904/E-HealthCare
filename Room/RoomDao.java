import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class RoomDao {
    

    // create a connection obj to connect to the database
    private Connection connection;

    // constructor
    public RoomDao() throws SQLException {
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

    public List<Room> getAllRooms() throws SQLException {
        List<Room> Rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Room room = new Room(
                    resultSet.getInt("RID"),
                    resultSet.getInt("PID"),
                    resultSet.getInt("NOB"));
            Rooms.add(room);
        }
        return Rooms;
    }

    // Check if Room is valid
    public boolean validate(Room room) throws SQLException {
        String sql = "SELECT * FROM Room WHERE RID = ? AND PID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,(room.getRID()));
        statement.setInt(2, (room.getPID()));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    // If Room is successful then get the number of beds
    public String getRole(Room room) throws SQLException {
        String sql = "SELECT NOB FROM Room WHERE RID = ? AND PID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (room.getRID()));
        statement.setInt(2, (room.getPID()));
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("NOB");
        }
        return null;
    }

    // Account creation
    public void Signup(Room room) throws SQLException {
        String sql = "INSERT INTO Room (RID, PID, NOB) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (room.getRID()));
        statement.setInt(2, (room.getPID()));
        statement.setInt(3, (room.getNOB()));
        statement.executeUpdate();
    }

}
