package com.mycompany.bookmanagement;

import java.sql.SQLException;
import java.sql.SQLException;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        try {
            ManagementBook managementBook = new ManagementBook();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nBook Management Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.next();
                        System.out.print("Enter book author: ");
                        String author = scanner.next();
                        managementBook.addBook(new Book(0, title, author, true));
                        break;
                    case 2:
                        managementBook.viewBooks();
                        break;
                    case 3:
                        System.out.print("Enter book ID to borrow: ");
                        int bookId = scanner.nextInt();
                        System.out.print("Enter user ID: ");
                        int userId = scanner.nextInt();
                        managementBook.borrowBook(bookId, userId);
                        break;
                    case 4:
                        System.out.print("Enter book ID to return: ");
                        int returnBookId = scanner.nextInt();
                        managementBook.returnBook(returnBookId);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
