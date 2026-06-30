package app;

import java.util.Scanner;
import model.Book;
import service.LibrarySearch;
import util.SortUtil;

public class Main {

    public static void main(String[] args) {

        Book[] books = {
                new Book(1, "Java Basics", "James Gosling"),
                new Book(2, "Data Structures", "Robert Lafore"),
                new Book(3, "Algorithms", "Thomas Cormen"),
                new Book(4, "Operating System", "Galvin"),
                new Book(5, "DBMS", "Korth")
        };

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display Books");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;

                case 2:
                    System.out.print("Enter Book Title: ");
                    String title1 = sc.nextLine();

                    Book result1 = LibrarySearch.linearSearch(books, title1);

                    if (result1 != null)
                        System.out.println(result1);
                    else
                        System.out.println("Book Not Found");
                    break;

                case 3:
                    SortUtil.sortByTitle(books);

                    System.out.print("Enter Book Title: ");
                    String title2 = sc.nextLine();

                    Book result2 = LibrarySearch.binarySearch(books, title2);

                    if (result2 != null)
                        System.out.println(result2);
                    else
                        System.out.println("Book Not Found");
                    break;

                case 4:
                    sc.close();
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}