
/**
 * DatabaseConfig holds the configuration settings for the database connection.
 */
public class DatabaseConfig {

    private static DatabaseConfig instance;
    private String url;
    private String username;
    private String password;

    // Private constructor to prevent instantiation
    private DatabaseConfig() {
        this.url = "jdbc:mysql://localhost:3306/mydatabase"; // Example database URL
        this.username = "root"; // Example username
        this.password = "password"; // Example password
    }

    // Method to get the single instance of DatabaseConfig
    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    // Getters
    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
