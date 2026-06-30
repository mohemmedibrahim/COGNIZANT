public class AdapterTest {

    public static void main(String[] args) {

        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        PaymentProcessor payPalProcessor =
                new PayPalAdapter(payPalGateway, "user@example.com");

        PaymentProcessor stripeProcessor =
                new StripeAdapter(stripeGateway);

        System.out.println("=== Payment Processing ===");

        payPalProcessor.processPayment(49.99);
        stripeProcessor.processPayment(120.50);
    }
}