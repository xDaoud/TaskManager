package org.example;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Export Tasks to File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (option) {
                    case 1:
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Due Date (YYYY-MM-DD): ");
                        String dueDate = scanner.nextLine();
                        manager.addTask(title, description, dueDate);
                        break;
                    case 2:
                        manager.viewTasks();
                        break;
                    case 5:
                        System.out.print("Enter file name to export tasks: ");
                        String fileName = scanner.nextLine();
                        manager.exportTasks(fileName);
                        System.out.println("Tasks exported to " + fileName);
                        break;
                    // Implement cases for update and delete
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
