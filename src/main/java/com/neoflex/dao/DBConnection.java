package com.neoflex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/neoflex";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Piyush@cr7"; // Ideally use environment variables

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Database connection failed", e);
            return null;
        }
    }
}


