
/*
 * PayPalPayment class implements PaymentMethod interface for processing PayPal payments.
 */
public class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Logic to process PayPal payment
    }
}
