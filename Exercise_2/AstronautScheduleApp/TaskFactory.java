// TaskFactory.java

public class TaskFactory {

    public static Task createTask(String description, String startTime, String endTime, String priority) throws ScheduleException {
        validateTimeFormat(startTime); // Validate start time
        validateTimeFormat(endTime); // Validate end time
        TaskPriority taskPriority = TaskPriority.fromString(priority); // Convert priority string to enum
        return new Task(description, startTime, endTime, taskPriority); // Return new Task object
    }

    private static void validateTimeFormat(String time) throws ScheduleException {
        if (!time.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            throw new ScheduleException("Invalid time format: " + time);
        }
    }
}
