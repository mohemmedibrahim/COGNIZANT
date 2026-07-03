import java.util.Scanner;

public class EvenOrOddChecker {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            if (number % 2 == 0) {
                System.out.println(number + " is an Even number.");
            } else {
                System.out.println(number + " is an Odd number.");
            }
        }
    }
}