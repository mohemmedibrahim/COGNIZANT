public class DecoratorPatternDemo {

    public static void main(String[] args) {

        System.out.println("Email Notification");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Your order has been placed.");

        System.out.println("\nEmail + SMS Notification");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Your order has been shipped.");

        System.out.println("\nEmail + SMS + Slack Notification");
        Notifier allNotifier = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()));

        allNotifier.send("Your order has been delivered.");
    }
}