
import java.util.*;
import java.util.logging.Logger;

/**
 * Singleton class that manages the schedule of tasks. Implements the Observer
 * Pattern to notify observers about task changes.
 */
public class ScheduleManager {

    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    /**
     * Private constructor to prevent instantiation.
     */
    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    /**
     * Gets the single instance of ScheduleManager.
     *
     * @return the ScheduleManager instance
     */
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer the observer to be added
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered observers with the specified message.
     *
     * @param message the notification message
     */
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * Adds a task to the schedule if it does not overlap with existing tasks.
     *
     * @param task the task to be added
     * @return true if the task is added successfully
     * @throws TaskConflictException if the task conflicts with existing tasks
     */
    public boolean addTask(Task task) throws TaskConflictException {
        if (validateTask(task)) {
            tasks.add(task);
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            notifyObservers("Task added: " + task.getDescription() + " with no conflicts.");
            logger.info("Task added successfully: " + task);
            return true;
        } else {
            logger.warning("Task conflicts with existing tasks: " + task);
            throw new TaskConflictException("Task conflicts with existing tasks.");
        }
    }

    /**
     * Removes a task by its description.
     *
     * @param description the description of the task to remove
     * @return true if the task was removed successfully
     * @throws TaskNotFoundException if the task is not found
     */
    public boolean removeTask(String description) throws TaskNotFoundException {
        boolean removed = tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
        if (removed) {
            logger.info("Task removed successfully: " + description);
            return true;
        } else {
            logger.warning("Task not found: " + description);
            throw new TaskNotFoundException("Task not found: " + description);
        }
    }

    /**
     * Gets a list of all scheduled tasks.
     *
     * @return a list of tasks
     */
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Validates whether a new task can be added without conflicting with
     * existing tasks.
     *
     * @param newTask the new task to validate
     * @return true if the task is valid (no conflicts), false otherwise
     */
    public boolean validateTask(Task newTask) {
        for (Task existingTask : tasks) {
            if (newTask.getStartTime().isBefore(existingTask.getEndTime())
                    && newTask.getEndTime().isAfter(existingTask.getStartTime())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Marks a specified task as completed.
     *
     * @param description the description of the task to mark as completed
     */
    public void markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markAsCompleted();
                logger.info("Task marked as completed: " + description);
                return;
            }
        }
        logger.warning("Task not found for completion: " + description);
    }

    /**
     * Retrieves tasks that match a specified priority level.
     *
     * @param priority the priority level to filter tasks by
     * @return a list of tasks with the specified priority
     */
    public List<Task> getTasksByPriority(String priority) {
        List<Task> priorityTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                priorityTasks.add(task);
            }
        }
        return priorityTasks;
    }
}
