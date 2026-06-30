public class PayPalAdapter implements PaymentProcessor {
    // ADD THIS LINE:
    private PayPalGateway payPalGateway;
    private String userEmail;

    // The adapter accepts the adaptee via constructor injection
    public PayPalAdapter(PayPalGateway payPalGateway, String userEmail) {
        this.payPalGateway = payPalGateway;
        this.userEmail = userEmail;
    }

    @Override
    public void processPayment(double amount) {
        // Translates the unified method call into the specific PayPal method call
        payPalGateway.makePayment(userEmail, amount);
    }
}