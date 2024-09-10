package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // JDBC URL for SQLite database
    private static final String URL = "jdbc:sqlite:taskmanager.db";

    // Method to establish a connection to the database
    public static Connection connect() throws SQLException {
        // Load the SQLite JDBC driver (not always required, but can be good practice)
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite JDBC driver not found", e);
        }

        // Establish and return the connection to the database
        return DriverManager.getConnection(URL);
    }
}

