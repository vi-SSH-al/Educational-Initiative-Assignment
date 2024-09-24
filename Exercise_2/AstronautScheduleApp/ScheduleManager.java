
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleManager {

    private static ScheduleManager instance = null;
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        // Configure logger
        logger.setLevel(Level.INFO);
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addTask(Task task) throws ScheduleException {
        for (Task existingTask : tasks) {
            if (existingTask.conflictsWith(task)) {
                String errorMessage = "Error: Task conflicts with existing task \"" + existingTask.getDescription() + "\".";
                logger.warning(errorMessage);
                notifyObservers(errorMessage);
                throw new ScheduleException(errorMessage);
            }
        }
        tasks.add(task);
        logger.info("Task added successfully: " + task);
        notifyObservers("Task added successfully: " + task);
    }

    public void removeTask(String description) throws TaskNotFoundException {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove == null) {
            throw new TaskNotFoundException("Task not found: " + description);
        }
        tasks.remove(taskToRemove);
        logger.info("Task removed successfully: " + taskToRemove);
        notifyObservers("Task removed successfully: " + taskToRemove);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
