// Task.java

public class Task {

    private String description;
    private String startTime;
    private String endTime;
    private TaskPriority priority;

    public Task(String description, String startTime, String endTime, TaskPriority priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public boolean conflictsWith(Task other) {
        return (this.startTime.compareTo(other.endTime) < 0 && this.endTime.compareTo(other.startTime) > 0);
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]";
    }
}
