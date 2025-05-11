package com.mycompany.kasirtransportasi;

public class Bus extends Kendaraan {

    public Bus(int id, String jenis, int kapasitas) {
        super(id, jenis, kapasitas);
    }

    @Override
    public double hitungBiaya(double jarak) {
        // Contoh: Rp1500 per km untuk bus
        return jarak * 1500;
    }

    @Override
    public String getDetails() {
        return "Bus - " + super.getDetails();
    }
}

