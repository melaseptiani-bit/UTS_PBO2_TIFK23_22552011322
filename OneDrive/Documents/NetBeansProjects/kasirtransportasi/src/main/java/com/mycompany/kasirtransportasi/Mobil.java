package com.mycompany.kasirtransportasi;

public class Mobil extends Kendaraan {

    public Mobil(int id, String jenis, int kapasitas) {
        super(id, jenis, kapasitas);
    }

    public double hitungBiaya(double jarak) {
        // Contoh: Rp2000 per km untuk mobil
        return jarak * 2000;
    }

    public String getDetails() {
        return "Mobil - " + super.getDetails();
    }
}
