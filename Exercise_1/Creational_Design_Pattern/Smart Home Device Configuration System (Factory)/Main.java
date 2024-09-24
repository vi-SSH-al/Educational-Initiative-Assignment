
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        logger.logInfo("Welcome to the Smart Home Device Configuration System!");

        while (continueRunning) {
            System.out.println("Enter the type of smart device you want to configure (Light, Thermostat, Camera) or type 'exit' to quit: ");
            String deviceType = scanner.nextLine();

            if (deviceType.equalsIgnoreCase("exit")) {
                continueRunning = false;
                logger.logInfo("Exiting the application. Goodbye!");
                continue;
            }

            try {
                SmartDevice device = DeviceFactory.createDevice(deviceType);
                device.configure();
                logger.logInfo(deviceType + " successfully configured.");
            } catch (IllegalArgumentException e) {
                logger.logError(e.getMessage());
            }
        }

        scanner.close();
    }
}
