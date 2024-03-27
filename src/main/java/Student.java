import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student extends User {
    private String nama;
    private String nim;
    private String faculty;
    private String ProgramStudi;
    private static Scanner scanner;
    private static ArrayList<Book> borrowedBooks;
    static {
    borrowedBooks = new ArrayList<>();
    }

    public Student(String nama, String nim, String faculty, String ProgramStudi) {
        this.nama = nama;
        this.nim = nim;
        this.faculty = faculty;
        this.ProgramStudi = ProgramStudi;
        scanner = new Scanner(System.in);
    }

    public static void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        Student.borrowedBooks = borrowedBooks;
    }

    public String getNim() {
        return nim;
    }

    public String tampilDataMahasiswa() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nFakultas: " + faculty + "\nProgram Studi: " + ProgramStudi;
    }

    public void displayBooks() {
        super.displayBook();
    }

    // Method untuk meminjam buku
    public static void borrowBook() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return; // Kembali ke menu utama
        }

        User user = new User();
        // Menampilkan daftar buku yang tersedia
        user.displayBook();

        // Meminta input ID buku yang ingin dipinjam
        System.out.print("Masukkan ID buku yang ingin dipinjam: ");
        UUID bookId = UUID.fromString(scanner.nextLine());

        // Mencari buku berdasarkan ID
        Book bookToBorrow = null;
        for (Book book : books)
            if (book.getBookId() == bookId && book.getStock() > 0) {
                bookToBorrow = book;
                break;
            }

        // Jika buku ditemukan, meminjamnya
        if (bookToBorrow != null) {
            System.out.print("Masukkan durasi peminjaman (dalam hari): ");
            int duration;
            while (!scanner.hasNextInt()) {
                System.out.println("Masukkan durasi peminjaman dengan angka yang valid.");
                scanner.next(); // Clear buffer
            }
            duration = scanner.nextInt();

            // Mengurangi stok buku yang dipinjam
            int currentStock = bookToBorrow.getStock();
            bookToBorrow.setStock(currentStock - 1);

            System.out.println("Anda telah berhasil meminjam buku dengan judul '" + bookToBorrow.getTitle() +
                    "' untuk " + duration + " hari.");
        } else {
            System.out.println("Buku tidak tersedia atau ID buku tidak valid.");
        }
    }

    // Method untuk mengembalikan buku
    public static void returnBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda belum meminjam buku apapun.");
            return;
        }

        // Menampilkan daftar buku yang telah dipinjam
        System.out.println("Buku yang Anda pinjam:");
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooks.get(i).getTitle());
        }

        // Meminta input indeks buku yang akan dikembalikan
        System.out.print("Masukkan nomor buku yang akan dikembalikan: ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= borrowedBooks.size()) {
            // Mengembalikan buku dan menambahkan stoknya kembali
            Book returnedBook = borrowedBooks.remove(index - 1);
            returnedBook.setStock(returnedBook.getStock() + 1);
            System.out.println("Anda telah berhasil mengembalikan buku dengan judul '" + returnedBook.getTitle() + "'.");
        } else {
            System.out.println("Nomor buku tidak valid.");
        }
    }

    // Method untuk logout
    public static void logout() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda telah berhasil logout.");
            return;
        }

        System.out.println("Anda memiliki buku yang belum dikembalikan.");

        // Menampilkan buku yang telah dipinjam
        showBorrowedBooks();

        System.out.print("Apakah Anda ingin melakukan konfirmasi peminjaman atau membatalkan (Y/N)? ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("N")) {
            System.out.println("Anda telah berhasil logout.");
        } else if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Anda telah membatalkan logout.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public static void showBorrowedBooks() {
        System.out.println("Buku yang Anda pinjam:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda belum meminjam buku apapun.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("ID: " + book.getBookId() +
                        ", Judul: " + book.getTitle() +
                        ", Penulis: " + book.getAuthor() +
                        ", Kategori: " + book.getCategory() +
                        ", Durasi Peminjaman: " + book.getDuration() + " hari");
            }
        }
    }

    // Method untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.print("Nama: ");
        nama = scanner.next();
        System.out.print("NIM: ");
        nim = scanner.next();
        System.out.print("Fakultas: ");
        faculty = scanner.next();
        System.out.print("Program Studi: ");
        ProgramStudi = scanner.next();
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Fakultas: " + faculty);
        System.out.println("Program Studi: " + ProgramStudi);
    }

    public static void main(String[] args) {
        // Membuat objek Student
        Student student = new Student("", "", "", "");

        // Menampilkan informasi mahasiswa
        student.displayInfo();

        // Menambahkan beberapa buku ke dalam daftar
        student.addBook(new Book("Judul Buku 1", "Penulis 1", "Kategori 1"));
        student.addBook(new Book("Judul Buku 2", "Penulis 2", "Kategori 2"));
        student.addBook(new Book("Judul Buku 3", "Penulis 3", "Kategori 3"));

        // Meminjam buku
        student.borrowBook();

        // Mengembalikan buku
        student.returnBooks();

        // Menampilkan buku yang telah dipinjam
        student.showBorrowedBooks();

        // Logout
        student.logout();
    }
}

