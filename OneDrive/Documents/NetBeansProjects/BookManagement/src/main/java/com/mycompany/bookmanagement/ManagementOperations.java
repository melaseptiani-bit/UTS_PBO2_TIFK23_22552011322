package com.mycompany.bookmanagement;

public interface ManagementOperations {
    void addBook(Book book);
    void viewBooks();
    void borrowBook(int bookId, int userId);
    void returnBook(int bookId);
}    
