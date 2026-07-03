import java.util.Scanner;

public class CustomException {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above.");
            }

            System.out.println("You are eligible.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }
}