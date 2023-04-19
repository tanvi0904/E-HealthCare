import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    private Connection connection;

    public DoctorDao() throws SQLException {
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

    public List<Doctor> getDocs() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctorlist";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Doctor doctor = new Doctor(
                    resultSet.getString("doctorID"),
                    resultSet.getString("doctorName"),
                    resultSet.getString("doctorSp"));
            doctors.add(doctor);
        }
        System.out.println(doctors);
        return doctors;
    }

    public void addDoc(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctorlist (doctorID, doctorName, doctorSp) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, doctor.getDoctorID());
        statement.setString(2, doctor.getdoctorName());
        statement.setString(3, doctor.getDoctorSp());
        statement.executeUpdate();
    }
}