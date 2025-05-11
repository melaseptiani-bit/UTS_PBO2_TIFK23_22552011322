package com.mycompany.kasirtransportasi;

public interface Operations {
    void tambahKendaraan(String jenis, int kapasitas);
    void lihatKendaraan();
    void tambahRute(String asal, String tujuan, double jarak);
    void lihatRute();
    void prosesTransaksi(int kendaraanId, int ruteId);
}
