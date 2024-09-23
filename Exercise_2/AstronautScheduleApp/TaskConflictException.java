
/**
 * Custom exception for handling task conflicts.
 */
public class TaskConflictException extends Exception {

    /**
     * Constructs a new TaskConflictException with the specified detail message.
     *
     * @param message the detail message
     */
    public TaskConflictException(String message) {
        super(message);
    }
}
