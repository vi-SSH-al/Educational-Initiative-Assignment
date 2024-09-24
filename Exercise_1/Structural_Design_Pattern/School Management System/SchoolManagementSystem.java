
import SchoolService;
import SchoolException;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class SchoolManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(SchoolManagementSystem.class.getName());
    private static SchoolService schoolService;

    public static void main(String[] args) {
        setupLogger();

        schoolService = new SchoolService("School");
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nWelcome to the School Management System!");
            System.out.println("Please choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Show School Structure");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    showSchoolStructure();
                    break;
                case 4:
                    continueRunning = false;
                    System.out.println("Exiting the program. Thank you!");
                    logger.info("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    logger.warning("Invalid menu choice.");
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            schoolService.addStudent(name, id);
        } catch (SchoolException e) {
            System.err.println("Error adding student: " + e.getMessage());
            logger.severe("Error adding student: " + e.getMessage());
        }
    }

    private static void addTeacher() {
        try {
            System.out.print("Enter Teacher Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();

            schoolService.addTeacher(name, subject);
        } catch (SchoolException e) {
            System.err.println("Error adding teacher: " + e.getMessage());
            logger.severe("Error adding teacher: " + e.getMessage());
        }
    }

    private static void showSchoolStructure() {
        schoolService.showSchoolStructure();
    }

    private static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("logs/application.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            logger.info("Logger initialized.");
        } catch (Exception e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }
}
