
public enum TaskPriority {
    HIGH, MEDIUM, LOW;

    public static TaskPriority fromString(String priority) {
        return TaskPriority.valueOf(priority.toUpperCase());
    }
}
