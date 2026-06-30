public class PayPalGateway {
    public void makePayment(String email, double totalAmount) {
        System.out.println("Processing PayPal payment of $" + totalAmount + " for user: " + email);
    }
}