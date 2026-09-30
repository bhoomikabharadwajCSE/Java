import java.util.Scanner;

class Book {

String bookID;
String title;
String author;
double price;

static int totalBooks = 0;

Book(String bookID, String title, String author, double price) {
this.bookID = bookID;
this.title = title;
this.author = author;
this.price = price;
totalBooks++;
}

void display() {
System.out.println("Book ID : " + bookID);
System.out.println("Title : " + title);
System.out.println("Author : " + author);
System.out.println("Price : ₹" + price);
}
static void search(Book[] books, String searchID) {
boolean found = false;
for (Book b : books) {
if (b.bookID.equalsIgnoreCase(searchID)) {
System.out.println("\n[Match Found by Book ID]");
b.display();
found = true;
break;
}
}
if (!found) {
System.out.println("\nNo book found with ID: " + searchID);
}
}
static void search(Book[] books, String searchTitle, boolean isTitle) {
boolean found = false;
for (Book b : books) {
if (b.title.equalsIgnoreCase(searchTitle)) {
System.out.println("\n[Match Found by Title]");
b.display();
found = true;
break;
}
}
if (!found) {
System.out.println("\nNo book found with Title: " + searchTitle);
}
}
Book getCostlierBook(Book otherBook) {
if (this.price >= otherBook.price) {
return this;
} else {
return otherBook;
}
}
static void displayTotalBooks() {
System.out.println("Total number of books created: " + totalBooks);
}
}

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Book b1 = new Book("B101", "Java Programming", "James", 450.0);
Book b2 = new Book("B102", "Data Structures", "idk", 650.0);
Book b3 = new Book("B103", "Operating Systems", "Galvin", 550.0);

Book.displayTotalBooks();
System.out.println("\n--- Displaying All Books ---");
b1.display();
b2.display();
b3.display();

System.out.print("Enter Book ID to search: ");
String idQuery = sc.next();
Book.search(new Book[]{b1, b2, b3}, idQuery);

sc.nextLine();
System.out.print("Enter Book Title to search: ");
String titleQuery = sc.nextLine();
Book.search(new Book[]{b1, b2, b3}, titleQuery, true);

System.out.println("\n--- Comparing Costs ---");
Book costlier = b1.getCostlierBook(b2);
System.out.println("Between '" + b1.title + "' and '" + b2.title + "', the costlier book is:");
costlier.display();

sc.close();
}
}

