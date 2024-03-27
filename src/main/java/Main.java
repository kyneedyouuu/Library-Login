import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choice;

        do {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan (1-3): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Masukkan pilihan angka yang valid.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dalam buffer

            switch (choice) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    System.out.println("Terima kasih! Sampai jumpa lagi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 3);
    }

    public static void studentLogin() {
        inputNIM();
    }

    private static void inputNIM() {
        System.out.println("Enter Your NIM (input 0 to back): ");
        String nimInput = scanner.nextLine();

        if (nimInput.equals("0")) {
            return;
        }
        if (nimInput.length() != 15) {
            System.out.println("NIM must consist of 15 digits. Please try again.");
            inputNIM();
            return;
        }

        // Logic to proceed with NIM validation or registration
        // You may prompt for other details if needed or directly validate/register the NIM
        // For the sake of example, let's assume we proceed to the next step directly
        checkNIM(nimInput);
    }

    private static void checkNIM(String nim) {
        boolean isNIMRegistered = false;
        for (Student student : Admin.studentList) {
            if (student.getNim().equals(nim)) {
                isNIMRegistered = true;
                break;
            }
        }
        if (isNIMRegistered) {
            System.out.println("NIM is registered. Displaying student data...");
            Admin.displayStudents();
        } else {
            System.out.println("NIM is not registered. Adding student data...");
            Admin.addStudent();
        }

        menuStudent();
    }

    Student student = new Student("","","","");

    public static void menuStudent() {
        int choice;
        do {
            System.out.println("\nStudent Menu : ");
            System.out.println("1. Buku Terpinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Pinjam Buku atau Logout");
            System.out.print("Masukkan pilihan (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Masukkan pilihan angka yang valid.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Student.showBorrowedBooks();
                    break;
                case 2:
                    Student.borrowBook();
                    break;
                case 3:
                    Student.returnBooks();
                    break;
                case 4:
                    Student.logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);
    }


    public static void loginAdmin() {
        System.out.println("\nLogin sebagai Admin");
        System.out.println("username (administrator) : ");
        String username = scanner.nextLine();
        System.out.println("password (administrator) : ");
        String password = scanner.nextLine();

        if (username.equals(Admin.getAdminUsername()) && password.equals(Admin.getAdminPassword())) {
            System.out.println("Login berhasil sebagai Admin");
            menuAdmin();
        } else {
            System.out.println("Login gagal. Username atau Password tidak valid.");
        }
    }

    private static void menuAdmin() {
        int choice;
        do {
            System.out.println("\nMenu Admin : ");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Registered Students");
            System.out.println("4. Display Available Book");
            System.out.println("5. Logout");
            System.out.print("Masukkan pilihan (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Masukkan pilihan angka yang valid.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Admin.addStudent();
                    break;
                case 2:
                    Admin.inputBook();
                    break;
                case 3:
                    Admin.displayStudents();
                    break;
                case 4:
                    Admin.displayBuku();
                    break;
                case 5:
                    System.out.println("Logout dari Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 5);
    }
}
