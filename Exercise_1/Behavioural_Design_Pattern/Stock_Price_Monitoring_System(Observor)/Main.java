
import java.util.Scanner;

/**
 * Main driver class for demonstrating the Observer design pattern with user
 * interaction.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPriceTracker stockPriceTracker = new StockPriceTracker("AAPL");
        StockPriceSimulator simulator = new StockPriceSimulator(stockPriceTracker);

        System.out.println("Welcome to the Stock Price Notification System!");

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Register for Stock Updates");
            System.out.println("2. Unregister from Stock Updates");
            System.out.println("3. View Current Stock Price");
            System.out.println("4. Set Stock Price Update Interval");
            System.out.println("5. Start Stock Price Updates");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter client ID to register: ");
                    String clientId = scanner.nextLine();
                    Client newClient = new Client(clientId);
                    stockPriceTracker.registerObserver(newClient);
                    System.out.println("Client " + clientId + " registered successfully.");
                    break;
                case 2:
                    System.out.print("Enter client ID to unregister: ");
                    String clientToRemove = scanner.nextLine();
                    Client clientToUnregister = new Client(clientToRemove);
                    stockPriceTracker.unregisterObserver(clientToUnregister);
                    System.out.println("Client " + clientToRemove + " unregistered successfully.");
                    break;
                case 3:
                    System.out.println("Current Stock Price of " + stockPriceTracker.getStockSymbol() + ": $" + stockPriceTracker.getStockPrice());
                    break;
                case 4:
                    System.out.print("Enter stock price update interval in seconds: ");
                    int interval = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    simulator.setInterval(interval);
                    System.out.println("Stock price update interval set to " + interval + " seconds.");
                    break;
                case 5:
                    simulator.start();
                    System.out.println("Stock price updates started.");
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
