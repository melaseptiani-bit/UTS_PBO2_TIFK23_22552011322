package com.mycompany.kasirtransportasi;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kasirtransportasi {
    public static void main(String[] args) {
        try {
            Transportasi manager = new Transportasi();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== Menu Kasir Transportasi ===");
                System.out.println("1. Tambah Kendaraan");
                System.out.println("2. Lihat Kendaraan");
                System.out.println("3. Tambah Rute");
                System.out.println("4. Lihat Rute");
                System.out.println("5. Hitung Biaya dan Simpan Transaksi");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");

                int pilihan;
                try {
                    pilihan = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka!");
                    continue;
                }

                switch (pilihan) {
                    case 1:
                        try {
                            System.out.print("Jenis kendaraan (Mobil/Bus): ");
                            String jenis = scanner.nextLine();

                            System.out.print("Kapasitas: ");
                            int kapasitas = Integer.parseInt(scanner.nextLine());

                            manager.tambahKendaraan(jenis, kapasitas);
                        } catch (NumberFormatException e) {
                            System.out.println("Kapasitas harus berupa angka!");
                        }
                        break;

                    case 2:
                        manager.lihatKendaraan();
                        break;

                    case 3:
                        try {
                            System.out.print("Asal: ");
                            String asal = scanner.nextLine();

                            System.out.print("Tujuan: ");
                            String tujuan = scanner.nextLine();

                            System.out.print("Jarak (km): ");
                            double jarak = Double.parseDouble(scanner.nextLine());

                            manager.tambahRute(asal, tujuan, jarak);
                        } catch (NumberFormatException e) {
                            System.out.println("Jarak harus berupa angka desimal!");
                        }
                        break;

                    case 4:
                        manager.lihatRute();
                        break;

                    case 5:
                        try {
                            System.out.print("ID Kendaraan: ");
                            int kendaraanId = Integer.parseInt(scanner.nextLine());

                            System.out.print("ID Rute: ");
                            int ruteId = Integer.parseInt(scanner.nextLine());

                            manager.prosesTransaksi(kendaraanId, ruteId);
                        } catch (NumberFormatException e) {
                            System.out.println("ID harus berupa angka!");
                        }
                        break;

                    case 6:
                        System.out.println("Keluar...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghubungkan ke database:");
            e.printStackTrace();
        }
    }
}
