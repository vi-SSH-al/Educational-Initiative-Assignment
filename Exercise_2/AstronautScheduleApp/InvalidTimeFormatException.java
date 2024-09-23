
/**
 * Custom exception for handling invalid time format inputs.
 */
public class InvalidTimeFormatException extends Exception {

    /**
     * Constructs a new InvalidTimeFormatException with the specified detail
     * message.
     *
     * @param message the detail message
     */
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
