
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Main class to interact with the Database Connection Manager.
 */
public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        logger.logInfo("Welcome to the Database Connection Management System!");

        while (continueRunning) {
            System.out.println("\nOptions:");
            System.out.println("1. Execute a Simple Query");
            System.out.println("2. Exit");
            System.out.print("Select an option (1-2): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter your SQL query: ");
                    String sqlQuery = scanner.nextLine();
                    try {
                        executeQuery(dbManager.getConnection(), sqlQuery);
                    } catch (DatabaseException e) {
                        logger.logError("Error executing query: " + e.getMessage());
                    }
                    break;

                case "2":
                    continueRunning = false;
                    dbManager.closeConnection();
                    logger.logInfo("Exiting the application. Goodbye!");
                    break;

                default:
                    logger.logError("Invalid option. Please select 1 or 2.");
            }
        }

        scanner.close();
    }

    // Method to execute a SQL query
    private static void executeQuery(Connection connection, String query) throws DatabaseException {
        try (Statement statement = connection.createStatement()) {
            boolean isResultSet = statement.execute(query);

            if (isResultSet) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    System.out.println("Result: " + resultSet.getString(1));
                }
            } else {
                int updateCount = statement.getUpdateCount();
                System.out.println("Query executed successfully. Rows affected: " + updateCount);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to execute query: " + e.getMessage(), e);
        }
    }
}
