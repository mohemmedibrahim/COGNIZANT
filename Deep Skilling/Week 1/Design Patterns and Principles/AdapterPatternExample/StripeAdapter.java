public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Stripe expects cents instead of dollars, so we adapt it
        double amountInCents = amount * 100;
        
        // This call will work perfectly once StripeGateway has the matching charge method
        stripeGateway.charge(amountInCents, "USD");
    }
}