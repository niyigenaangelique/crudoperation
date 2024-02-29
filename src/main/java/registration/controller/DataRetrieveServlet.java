package registration.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.model.User;

@WebServlet("/DataRetrieveServlet")
public class DataRetrieveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/webtech";
        String username = "root";
        String passwrd = "";

        try (Connection connection = DriverManager.getConnection(url, username, passwrd)) {
            String sql = "SELECT name, password, email, sex, country FROM users";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String sex = resultSet.getString("sex");
                    String country = resultSet.getString("country");

                    // Create a User object and add it to the list
                    User user = new User(name, password, email, sex, country);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log it, display an error message)
        }

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
