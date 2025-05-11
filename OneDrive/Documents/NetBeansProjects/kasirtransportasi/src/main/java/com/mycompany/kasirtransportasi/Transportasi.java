package com.mycompany.kasirtransportasi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transportasi {
    private Connection connection;

    public Transportasi() throws SQLException {
        connection = DatabaseConnections.getConnection(); // koneksi ke DB
    }

    // Tambah kendaraan
    public void tambahKendaraan(String jenis, int kapasitas) {
        String query = "INSERT INTO kendaraan (jenis, kapasitas) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, jenis);
            stmt.setInt(2, kapasitas);
            stmt.executeUpdate();
            System.out.println("Kendaraan berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lihat semua kendaraan
    public void lihatKendaraan() {
        String query = "SELECT * FROM kendaraan";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Kendaraan> kendaraanList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String jenis = rs.getString("jenis");
                int kapasitas = rs.getInt("kapasitas");

                Kendaraan kendaraan;
                if (jenis.equalsIgnoreCase("mobil")) {
                    kendaraan = new Mobil(id, jenis, kapasitas);
                } else {
                    kendaraan = new Bus(id, jenis, kapasitas);
                }

                kendaraanList.add(kendaraan);
            }

            kendaraanList.forEach(k -> System.out.println(k.getDetails()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tambah rute
    public void tambahRute(String asal, String tujuan, double jarak) {
        String query = "INSERT INTO rute (asal, tujuan, jarak) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, asal);
            stmt.setString(2, tujuan);
            stmt.setDouble(3, jarak);
            stmt.executeUpdate();
            System.out.println("Rute berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lihat semua rute
    public void lihatRute() {
        String query = "SELECT * FROM rute";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Asal: " + rs.getString("asal") +
                        ", Tujuan: " + rs.getString("tujuan") +
                        ", Jarak: " + rs.getDouble("jarak") + " km");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Proses transaksi
    public void prosesTransaksi(int kendaraanId, int ruteId) {
        String kendaraanQuery = "SELECT * FROM kendaraan WHERE id = ?";
        String ruteQuery = "SELECT * FROM rute WHERE id = ?";
        String transaksiQuery = "INSERT INTO transaksi (kendaraan_id, route_id, total) VALUES (?, ?, ?)";

        try (
            PreparedStatement kendaraanStmt = connection.prepareStatement(kendaraanQuery);
            PreparedStatement ruteStmt = connection.prepareStatement(ruteQuery);
            PreparedStatement transaksiStmt = connection.prepareStatement(transaksiQuery)
        ) {
            kendaraanStmt.setInt(1, kendaraanId);
            ruteStmt.setInt(1, ruteId);

            ResultSet kendaraanRs = kendaraanStmt.executeQuery();
            ResultSet ruteRs = ruteStmt.executeQuery();

            if (kendaraanRs.next() && ruteRs.next()) {
                String jenis = kendaraanRs.getString("jenis");
                int kapasitas = kendaraanRs.getInt("kapasitas");
                double jarak = ruteRs.getDouble("jarak");

                Kendaraan kendaraan = jenis.equalsIgnoreCase("mobil")
                    ? new Mobil(kendaraanId, jenis, kapasitas)
                    : new Bus(kendaraanId, jenis, kapasitas);

                double total = kendaraan.hitungBiaya(jarak);

                transaksiStmt.setInt(1, kendaraanId);
                transaksiStmt.setInt(2, ruteId);
                transaksiStmt.setDouble(3, total);
                transaksiStmt.executeUpdate();

                System.out.println("Transaksi berhasil! Total biaya: Rp" + total);
            } else {
                System.out.println("Data kendaraan atau rute tidak ditemukan.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
