public class StripeGateway {
    // Make sure this method exists, is public, and accepts a double and a String
    public void charge(double amountInCents, String currency) {
        System.out.println("Charging via Stripe: " + currency + " " + (amountInCents / 100));
    }
}