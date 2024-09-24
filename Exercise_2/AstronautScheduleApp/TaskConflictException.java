
/**
 * Custom exception for task conflict scenarios.
 */
public class TaskConflictException extends ScheduleException {

    public TaskConflictException(String message) {
        super(message);
    }
}
