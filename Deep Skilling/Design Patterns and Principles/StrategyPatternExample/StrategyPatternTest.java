public class StrategyPatternTest {

    public static void main(String[] args) {

        PaymentContext paymentContext = new PaymentContext();

        // Credit Card Payment
        paymentContext.setPaymentStrategy(
                new CreditCardPayment("1234-5678-9012-3456"));
        paymentContext.executePayment(2500.00);

        System.out.println();

        // PayPal Payment
        paymentContext.setPaymentStrategy(
                new PayPalPayment("user@gmail.com"));
        paymentContext.executePayment(1500.00);
    }
}