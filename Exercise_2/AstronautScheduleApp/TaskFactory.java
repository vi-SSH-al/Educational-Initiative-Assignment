
import java.time.LocalTime;

/**
 * Factory class for creating Task objects.
 */
public class TaskFactory {

    /**
     * Creates a Task object with the given parameters.
     *
     * @param description the description of the task
     * @param startTimeStr the start time of the task as a string in HH:mm
     * format
     * @param endTimeStr the end time of the task as a string in HH:mm format
     * @param priority the priority level of the task (High, Medium, Low)
     * @return a new Task object
     */
    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priority) {
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        return new Task(description, startTime, endTime, priority);
    }
}
