package com.neoflex.servlet;

import com.neoflex.dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username == null || email == null || password == null ||
                username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                throw new Exception("Database connection failed");
            }

            // Check for existing user
            String checkSql = "SELECT * FROM users WHERE username = ? OR email = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, username);
                checkStmt.setString(2, email);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    request.setAttribute("error", "Username or email already exists.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    return;
                }
            }

            // Insert new user
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password); // Password should be hashed in real-world apps
                stmt.executeUpdate();
            }

            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred during registration.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}

