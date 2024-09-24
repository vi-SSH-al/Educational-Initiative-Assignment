
import java.util.Scanner;

/**
 * Main class to demonstrate the Strategy Pattern in resolving support tickets.
 */
public class Main {

    public static void main(String[] args) {
        TicketProcessor processor = new TicketProcessor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCreate a Support Ticket:");
            System.out.println("Enter ticket description: ");
            String description = scanner.nextLine();
            System.out.println("Choose ticket type:");
            System.out.println("1. Technical Support");
            System.out.println("2. Billing Inquiry");
            System.out.println("3. General Inquiry");
            System.out.println("4. Exit");

            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Ticket ticket = null;
            switch (choice) {
                case 1:
                    ticket = new Ticket(1, description, "Technical");
                    processor.setResolutionStrategy(new TechnicalSupportResolution());
                    break;
                case 2:
                    ticket = new Ticket(2, description, "Billing");
                    processor.setResolutionStrategy(new BillingInquiryResolution());
                    break;
                case 3:
                    ticket = new Ticket(3, description, "General");
                    processor.setResolutionStrategy(new GeneralInquiryResolution());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (ticket != null) {
                processor.resolveTicket(ticket);
            }
        }
    }
}
