
import java.time.LocalTime;

/**
 * Represents a task with a description, start time, end time, and priority
 * level.
 */
public class Task {

    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean completed;

    /**
     * Constructs a Task with the specified details.
     *
     * @param description the description of the task
     * @param startTime the start time of the task
     * @param endTime the end time of the task
     * @param priority the priority level of the task (High, Medium, Low)
     */
    public Task(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]", startTime, endTime, description, priority);
    }
}
