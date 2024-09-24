
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger is a singleton class for centralized logging.
 */
public class Logger {

    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
    }

    // Method to get the single instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log information messages
    public void logInfo(String message) {
        System.out.println(getTimestamp() + " INFO: " + message);
    }

    // Method to log error messages
    public void logError(String message) {
        System.err.println(getTimestamp() + " ERROR: " + message);
    }

    // Helper method to get the current timestamp
    private String getTimestamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }
}
