
import java.time.LocalDateTime;

/**
 * Singleton Logger class for logging messages.
 */
public class Logger {

    private static Logger instance;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + ": " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + LocalDateTime.now() + ": " + message);
    }
}
