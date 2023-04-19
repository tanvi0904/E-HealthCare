import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet("/room")
public class RoomController extends HttpServlet {
    private RoomDao roomDao;

    public void init() throws ServletException {
        try {
            roomDao = new RoomDao();
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Room> Rooms = roomDao.getAllRooms();
            request.setAttribute("Rooms", Rooms);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/room.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Unable to retrieve Rooms", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int RID = Integer.parseInt(request.getParameter("RID"));
        int PID = Integer.parseInt(request.getParameter("PID"));
        int NOB = Integer.parseInt(request.getParameter("NOB"));
        try {
            Room room = new Room(RID, PID, NOB);
            roomDao.Signup(room);
            response.sendRedirect("/myapp/room");
        } catch (SQLException e) {
            throw new ServletException("Unable to add user", e);
        }
    }
}
