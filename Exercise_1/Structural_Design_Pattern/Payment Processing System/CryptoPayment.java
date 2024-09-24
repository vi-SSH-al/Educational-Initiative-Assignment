
/**
 * CryptoPayment class implements PaymentMethod interface for processing cryptocurrency payments.
 */
public class CryptoPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount);
        // Logic to process cryptocurrency payment
    }
}
