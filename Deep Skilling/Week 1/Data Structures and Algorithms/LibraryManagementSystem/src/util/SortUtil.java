package util;

import model.Book;

public class SortUtil {

    public static void sortByTitle(Book[] books) {

        for (int i = 0; i < books.length - 1; i++) {

            for (int j = 0; j < books.length - i - 1; j++) {

                if (books[j].getTitle().compareToIgnoreCase(books[j + 1].getTitle()) > 0) {

                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;

                }

            }

        }

    }

}