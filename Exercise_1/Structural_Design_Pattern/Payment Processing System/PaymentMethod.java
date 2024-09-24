
/**
 * PaymentMethod interface defines the method for processing payments.
 */
public interface PaymentMethod {

    void pay(double amount) throws PaymentNotSupportedException;
}
