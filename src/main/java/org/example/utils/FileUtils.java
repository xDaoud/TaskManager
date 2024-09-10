package org.example.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileUtils {
    public static void exportTasksToFile(ResultSet resultSet, String fileName) throws SQLException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            while (resultSet.next()) {
                writer.write("ID: " + resultSet.getInt("id"));
                writer.newLine();
                writer.write("Title: " + resultSet.getString("title"));
                writer.newLine();
                writer.write("Description: " + resultSet.getString("description"));
                writer.newLine();
                writer.write("Due Date: " + resultSet.getString("due_date"));
                writer.newLine();
                writer.write("----");
                writer.newLine();
            }
        }
    }
}
