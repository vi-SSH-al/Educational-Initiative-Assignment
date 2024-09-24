
/**
 * PaymentNotSupportedException is a custom exception class for handling unsupported payment methods.
 */
public class PaymentNotSupportedException extends Exception {

    public PaymentNotSupportedException(String message) {
        super(message);
    }
}
