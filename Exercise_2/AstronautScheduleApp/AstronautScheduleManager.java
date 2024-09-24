
import java.util.Scanner;
import java.util.logging.Logger;

public class AstronautScheduleManager {

    private static Logger logger = Logger.getLogger(AstronautScheduleManager.class.getName());

    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        UserObserver user = new UserObserver("Astronaut");
        scheduleManager.addObserver(user);

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Astronaut Schedule Manager!");
        System.out.println("You can manage your tasks with the following commands:");
        System.out.println("1. 'add' - Add a new task");
        System.out.println("2. 'remove' - Remove an existing task");
        System.out.println("3. 'view' - View all scheduled tasks");
        System.out.println("4. 'exit' - Exit the application");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter command: ");
            command = scanner.nextLine().toLowerCase().trim();
            switch (command) {
                case "add":
                    addTask(scheduleManager, scanner);
                    break;

                case "remove":
                    System.out.print("Enter task description to remove: ");
                    String description = scanner.nextLine().trim();
                    if (description.isEmpty()) {
                        System.out.println("Error: Task description cannot be empty.");
                        break;
                    }
                    try {
                        scheduleManager.removeTask(description);
                    } catch (TaskNotFoundException e) {
                        logger.warning(e.getMessage());
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "view":
                    System.out.println("\nScheduled Tasks:");
                    scheduleManager.viewTasks();
                    break;

                case "exit":
                    logger.info("Exiting the application.");
                    System.out.println("Thank you for using the Astronaut Schedule Manager. Goodbye!");
                    running = false;
                    System.exit(0);

                default:
                    System.out.println("Error: Invalid command. Please enter 'add', 'remove', 'view', or 'exit'.");
            }
        }
    }

    private static void addTask(ScheduleManager scheduleManager, Scanner scanner) {
        String description, startTime, endTime, priority;

        // Prompt for task description
        System.out.print("Enter task description: ");
        description = scanner.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
            return;
        }

        // Prompt for start time
        startTime = promptForTime(scanner, "Enter start time (HH:mm): ");
        if (startTime == null) {
            return;  // Time validation failed
        }
        // Prompt for end time
        endTime = promptForTime(scanner, "Enter end time (HH:mm): ");
        if (endTime == null) {
            return;  // Time validation failed
        }
        // Prompt for priority
        System.out.print("Enter priority (High, Medium, Low): ");
        priority = scanner.nextLine().trim();
        if (!isValidPriority(priority)) {
            System.out.println("Error: Invalid priority level. Must be High, Medium, or Low.");
            return;
        }

        // Confirm task details before adding
        System.out.println("\nTask Details:");
        System.out.println("Description: " + description);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Priority: " + priority);
        System.out.print("Confirm adding this task? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(confirmation)) {
            try {
                Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                scheduleManager.addTask(task);
                System.out.println("Task added successfully. No conflicts.");
            } catch (ScheduleException e) {
                logger.warning(e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Task addition canceled.");
        }
    }

    private static String promptForTime(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String time = scanner.nextLine().trim();
            if (validateTimeFormat(time)) {
                return time;  // Return valid time
            } else {
                System.out.println("Error: Invalid time format.");
            }
        }
    }

    private static boolean isValidPriority(String priority) {
        return priority.equalsIgnoreCase("High")
                || priority.equalsIgnoreCase("Medium")
                || priority.equalsIgnoreCase("Low");
    }

    private static boolean validateTimeFormat(String time) {
        // Add your time format validation logic here
        // Return true if valid, false otherwise
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
}
