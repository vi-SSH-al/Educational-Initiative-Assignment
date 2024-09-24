
import java.util.Scanner;

/**
 * PaymentProcessor is the client class that interacts with the PaymentAdapter
 * to process payments.
 */
public class PaymentProcessorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProcessing = true;

        while (continueProcessing) {
            System.out.print("Enter payment method (creditcard, paypal, crypto) or 'exit' to quit: ");
            String paymentType = scanner.nextLine();

            if (paymentType.equalsIgnoreCase("exit")) {
                continueProcessing = false;
                System.out.println("Exiting the application. Goodbye!");
                continue;
            }

            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            try {
                PaymentAdapter paymentAdapter = new PaymentAdapter(paymentType);
                paymentAdapter.pay(amount);
            } catch (PaymentNotSupportedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
