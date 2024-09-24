
/**
 * PaymentAdapter class adapts different payment methods to a unified interface.
 */
public class PaymentAdapter implements PaymentMethod {

    private PaymentMethod paymentMethod;

    // Constructor accepts a payment method type
    public PaymentAdapter(String paymentType) throws PaymentNotSupportedException {
        switch (paymentType.toLowerCase()) {
            case "creditcard":
                this.paymentMethod = new CreditCardPayment();
                break;
            case "paypal":
                this.paymentMethod = new PayPalPayment();
                break;
            case "crypto":
                this.paymentMethod = new CryptoPayment();
                break;
            default:
                throw new PaymentNotSupportedException("Payment method " + paymentType + " is not supported.");
        }
    }

    @Override
    public void pay(double amount) throws PaymentNotSupportedException {
        if (paymentMethod == null) {
            throw new PaymentNotSupportedException("No valid payment method selected.");
        }
        paymentMethod.pay(amount);
    }
}
