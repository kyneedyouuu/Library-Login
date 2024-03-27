import java.util.ArrayList;
import java.util.List;

public class User {
    protected static List<Book> books;

    public User() {
        books = new ArrayList<>();
    }

    // buat nambahin buku
    public void addBook(Book book) {
        books.add(book);
    }

    // buat nampilin buku
    public void displayBook() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nAvailable Books:");
            System.out.println("+------------------+------------+-----------+----------+-------+");
            System.out.println("|      ID buku     |  Nama buku |   Author  | Category | Stock |");
            System.out.println("+------------------+------------+-----------+----------+-------+");

            for (Book book : books) {
                String truncatedId = book.getBookId().toString().substring(0, 8); // Truncate to first 8 characters
                String truncatedTitle = truncateString(book.getTitle(), 15); // Example: Truncate title to 15 characters
                // Similarly truncate other fields if needed
                System.out.printf("| %-16s | %-10s | %-9s | %-8s | %-5d |\n",
                        truncatedId, truncatedTitle, book.getAuthor(), book.getCategory(), book.getStock());
            }

            System.out.println("+------------------+------------+-----------+----------+-------+");

        }
    }
    public static String truncateString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        } else {
            return str.substring(0, maxLength);
        }
    }

    public static void main(String[] args) {
        User user = new User();

        // Menambahkan beberapa buku ke dalam daftar
        user.addBook(new Book("Judul Buku 1", "Penulis 1", "Kategori 1"));
        user.addBook(new Book("Judul Buku 2", "Penulis 2", "Kategori 2"));
        user.addBook(new Book("Judul Buku 3", "Penulis 3", "Kategori 3"));

        // Menampilkan daftar buku yang tersedia
        user.displayBook();
    }
}

