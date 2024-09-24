
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnectionManager is a singleton class responsible for managing the
 * database connection.
 */
public class DatabaseConnectionManager {

    private static DatabaseConnectionManager instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnectionManager() {
        try {
            DatabaseConfig config = DatabaseConfig.getInstance();
            this.connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            Logger.getInstance().logError("Failed to establish database connection: " + e.getMessage());
        }
    }

    // Method to get the single instance of DatabaseConnectionManager
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            Logger.getInstance().logError("Failed to close database connection: " + e.getMessage());
        }
    }
}
