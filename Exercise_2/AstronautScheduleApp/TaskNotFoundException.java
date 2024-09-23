
/**
 * Custom exception for handling scenarios where a task is not found.
 */
public class TaskNotFoundException extends Exception {

    /**
     * Constructs a new TaskNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
