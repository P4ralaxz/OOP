/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
public class Library {
    public String libraryname;
    public Book book1;
    public Book book2;
    public Book book3;
    
    public void addBook(Book book, int slot) {
        if (slot == 1) {
            book1 = book;
        }
        else if (slot == 2) {
            book2 = book;
        }
        else {
            book3 = book;
        }
    }
    
    public void removeBook(int slot) {
        if (slot == 1) {
            book1 = null;
        }
        else if (slot == 2) {
            book2 = null;
        }
        else {
            book3 = null;
        }
    }
    
    public void printLibraryDetails() {
        System.out.println("Library: "+libraryname);
        System.out.println();
        if (book1 != null) {
            System.out.println("Title: " + book1.title);
            System.out.println("Author: " + book1.author);
            System.out.println("Publisher: " + book1.publisher);
            System.out.println("Year Published: " + book1.yearPublished);
            System.out.println("Price: $" + book1.price);
            System.out.println("Available: " + (book1.isAvailable ? "Yes" : "No"));
            System.out.println();
        }else {
            System.out.println("No book in this slot.");
            System.out.println();
        }
        if (book2 != null) {
            System.out.println("Title: " + book2.title);
            System.out.println("Author: " + book2.author);
            System.out.println("Publisher: " + book2.publisher);
            System.out.println("Year Published: " + book2.yearPublished);
            System.out.println("Price: $" + book2.price);
            System.out.println("Available: " + (book2.isAvailable ? "Yes" : "No"));
            System.out.println();
        }else {
            System.out.println("No book in this slot.");
            System.out.println();
        }
        if (book3 != null) {
            System.out.println("Title: " + book3.title);
            System.out.println("Author: " + book3.author);
            System.out.println("Publisher: " + book3.publisher);
            System.out.println("Year Published: " + book3.yearPublished);
            System.out.println("Price: $" + book3.price);
            System.out.println("Available: " + (book3.isAvailable ? "Yes" : "No"));
            System.out.println();
        }else {
            System.out.println("No book in this slot.");
            System.out.println();
        }
    }
    
    public void checkBookAvailability(int slot) {
        if (slot == 1 && book1 != null) {
            System.out.println(book1.title + " is available.");
        }else {
            System.out.println("Book in slot 1 is not available.");
        }
        if (slot == 2 && book2 != null) {
            System.out.println(book2.title + " is available.");
        }else {
            System.out.println("Book in slot 2 is not available.");
        }
        if (slot == 3 && book3 != null) {
            System.out.println(book3.title + " is available.");
        }else {
            System.out.println("Book in slot 3 is not available.");
        }
    }
    
    public void updateBookPrice(int slot, double newPrice) {
        if ((slot == 1) & (book1 != null)) {
            book1.price = newPrice;
            System.out.println("Updated price of " + book1.title + " to $" + book1.price + ".");
        }else if ((slot == 2) & (book2 != null)){
            book2.price = newPrice;
            System.out.println("Updated price of " + book2.title + " to $" + book2.price + ".");
        }else if ((slot == 3) & (book3 != null)){
            book3.price = newPrice;
            System.out.println("Updated price of " + book3.title + " to $" + book3.price + ".");
        }else {
            System.out.println("No book in this slot.");
        }
    }
    
    public void printBookDetails(Book book) {
        book1.printDetails();
        book2.printDetails();
        book3.printDetails();
    }
}

