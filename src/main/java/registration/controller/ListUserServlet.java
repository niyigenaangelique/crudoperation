package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import registration.model.User;
import registration.DAO.UserDAO;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/list")
public class ListUserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize UserDAO object
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch all users from the database
        List<User> userList = userDAO.getAllRecords();

        // Set the list of users as an attribute in the request
        request.setAttribute("listUser", userList);

        // Forwarding to the JSP for listing all users
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
}
