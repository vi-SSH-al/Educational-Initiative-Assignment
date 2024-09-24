
/**
 * CreditCardPayment class implements PaymentMethod interface for processing credit card payments.
 */
public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Logic to process credit card payment
    }
}
