import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Admin extends User {

    // Deklarasi pembuatan objek scanner agar dapat digunakan
    public static Scanner scanner = new Scanner(System.in);
    // ArrayList dari Student
    public static List<Student> studentList = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    // Deklarasi variabel username dan password yang akan digunakan untuk login
    private static String adminUsername = "rifky";
    private static String adminPassword = "rifkyrofiq";

    // Getter dan setter untuk username dan password
    public static String getAdminUsername() {
        return adminUsername;
    }

    public static void setAdminUsername(String adminUsername) {
        Admin.adminUsername = adminUsername;
    }

    public static String getAdminPassword() {
        return adminPassword;
    }

    public static void setAdminPassword(String adminPassword) {
        Admin.adminPassword = adminPassword;
    }

    // Method untuk menambahkan data mahasiswa
    public static void addStudent() {

        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();

        String nim;
        do {
            System.out.print("Masukkan NIM (Panjang harus 15 digit): ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM harus terdiri dari 15 digit.");
            }
        } while (nim.length() != 15);

        System.out.print("Masukkan Fakultas Mahasiswa: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan Program Studi Mahasiswa: ");
        String prodi = scanner.nextLine();

        boolean studentExists = false;
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                studentExists = true;
                break;
            }
        }

        if (studentExists) {
            System.out.println("Mahasiswa dengan NIM " + nim + " sudah terdaftar.");
        } else {
            Student student = new Student(nama, nim, faculty, prodi);
            studentList.add(student);
            System.out.println("Data Mahasiswa berhasil ditambahkan.");
        }
    }

    // Menampilkan daftar mahasiswa yang sudah ditambahkan
    public static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Wah, belum ada data mahasiswa yang ditambah nih.");
        } else {
            System.out.println("\n=== Data Mahasiswa ===");
            for (Student student : studentList) {
                System.out.println(student.tampilDataMahasiswa());
                System.out.println("-------------------------");
            }
        }
    }

    // Method utama untuk menjalankan program
    public static void main(String[] args) {

        books = new ArrayList<>();
        // Contoh penggunaan kelas Admin untuk menambahkan buku
        inputBook();
    }

    // Method untuk memasukkan buku
    public static void inputBook() {
        System.out.println("Pilih kategori buku:");
        System.out.println("1. History Book");
        System.out.println("2. Text Book");
        System.out.println("3. Story Book");
        System.out.print("Masukkan pilihan (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan judul buku: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan jumlah stok buku: ");
        int stock = scanner.nextInt(); // Read stock input

        switch (choice) {
            case 1:
                Book.HistoryBook historyBook = new Book.HistoryBook(title, author, stock);
                books.add(historyBook); // Add book to the ArrayList
                System.out.println("Buku dengan judul '" + title + "' berhasil terdaftar.");
                break;
            case 2:
                Book.TextBook textBook = new Book.TextBook(title, author, stock);
                books.add(textBook); // Add book to the ArrayList
                System.out.println("Buku dengan judul '" + title + "' berhasil terdaftar.");
                break;
            case 3:
                Book.StoryBook storyBook = new Book.StoryBook(title, author, stock);
                books.add(storyBook); // Add book to the ArrayList
                System.out.println("Buku dengan judul '" + title + "' berhasil terdaftar.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    // Method untuk menampilkan daftar buku menggunakan implementasi dari parent class
    public static void displayBuku() {
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


    public static boolean isAdmin(String username, String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
    public static UUID generateId() {
        return Book.bookId();
    }
}
