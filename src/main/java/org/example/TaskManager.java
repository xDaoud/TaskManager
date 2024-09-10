package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.utils.FileUtils;

public class TaskManager {
    private Connection conn;

    public TaskManager() {
        try {
            conn = DatabaseConnection.connect();
            // Optionally, initialize the database schema here if not already done
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTask(String title, String description, String dueDate) throws SQLException {
        String sql = "INSERT INTO tasks (title, description, due_date) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, dueDate);
            pstmt.executeUpdate();
        }
    }

    public void viewTasks() throws SQLException {
        String sql = "SELECT * FROM tasks";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Due Date: " + rs.getString("due_date"));
                System.out.println("----");
            }
        }
    }

    public void exportTasks(String fileName) throws SQLException, IOException {
        String sql = "SELECT * FROM tasks";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            FileUtils.exportTasksToFile(rs, fileName);
        }
    }

    // Implement updateTask and deleteTask similarly
}
