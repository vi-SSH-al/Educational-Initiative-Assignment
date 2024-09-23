
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

/**
 * Main application class to interact with the task scheduling system. Provides
 * a console-based interface for users to manage their tasks.
 */
public class AstronautScheduleApp {

    private static final Pattern TIME_PATTERN = Pattern.compile("([01]?\\d|2[0-3]):([0-5]\\d)");
    private static final Logger logger = Logger.getLogger(AstronautScheduleApp.class.getName());

    public static void main(String[] args) {
        try {
            // Configure logger
            FileHandler fh = new FileHandler("app.log", true);
            fh.setFormatter(new
