import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter student " + i + " name: ");
            studentNames.add(scanner.nextLine());
        }

        System.out.println("\nStudent Names:");

        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}