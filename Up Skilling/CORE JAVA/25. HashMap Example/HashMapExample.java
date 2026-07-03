import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, String> students = new HashMap<>();

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            students.put(id, name);
        }

        System.out.print("Enter Student ID to search: ");
        int searchId = scanner.nextInt();

        if (students.containsKey(searchId)) {
            System.out.println("Student Name: " + students.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}