package registration.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import registration.DAO.UserDAO;
import registration.model.User;

@WebServlet("/register")
public class UsersServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize UserDAO object
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forwarding to the JSP for adding a new user
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle form submission to add a new user
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String country = request.getParameter("country");

        // Create a new User object with the submitted data
        User user = new User(name, password, email, sex, country);

        // Call the UserDAO to insert the new user into the database
        int result = userDAO.save(user);

        if (UserDAO.validate(user)) {
			
			response.sendRedirect("userdetail.jsp");
        } else {
            // Handle failure to insert user (redirect to an error page or show error message)
            // For simplicity, let's redirect to an error page
            response.sendRedirect(request.getContextPath() + "/userdetail.jsp");
        }
    }
}
