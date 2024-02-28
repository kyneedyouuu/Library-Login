package com.sistemperpustakaan;

import java.util.Scanner;

public class LibraryLogin {
    private static String[] dataMahasiswa = {"202310370311489", "Rifky Rofiq"};
    private static String usernameAdmin = "rifky";
    private static String passwordAdmin = "rifkyrofiq";

    public static void main(String[] args) {
        startProgram();
    }

    public static void startProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to the Library Login System! ======");

        while (true) {
            System.out.println("\nIngin masuk sebagai siapa?");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Admin");
            System.out.println("3. Keluar dari Program");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    loginSebagaiMahasiswa(scanner);
                    break;
                case 2:
                    loginSebagaiAdmin(scanner);
                    break;
                case 3:
                    System.out.println("Terima Kasih! Have a nice day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mohon maaf, anda hanya bisa mengakses pilihan yang tersedia");
            }
        }
    }

    public static void loginSebagaiMahasiswa(Scanner scanner) {
        System.out.println("\nLogin sebagai Mahasiswa");
        System.out.println("Masukkan NIM (panjang harus 15 karakter) : ");
        String nim = scanner.nextLine();

        if (nim.length() == 15 && nim.equals(dataMahasiswa[0])) {
            System.out.println("Login sebagai mahasiswa berhasil, Selamat Datang! " + dataMahasiswa[1] );
        } else {
            System.out.println("Login error, Mohon maaf NIM anda tidak valid atau tidak terdaftar (Hubungi Admin)");
        }
    }

    public static void loginSebagaiAdmin (Scanner scanner) {
        System.out.println("\nLogin sebagai Admin");
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
            System.out.println("Login berhasil sebagai Admin");
        } else {
            System.out.println("Login gagal. Username atau Password tidak valid.");
        }
    }

}