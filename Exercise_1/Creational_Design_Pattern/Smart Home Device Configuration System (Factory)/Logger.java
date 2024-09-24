
public class Logger {

    private static Logger logger;

    private Logger() {
        // Private constructor to enforce singleton pattern
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    public void logError(String message) {
        System.err.println("ERROR: " + message);
    }
}
