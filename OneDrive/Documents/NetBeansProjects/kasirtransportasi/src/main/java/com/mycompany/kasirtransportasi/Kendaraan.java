package com.mycompany.kasirtransportasi;

public abstract class Kendaraan extends TransportasiEntity implements TransportasiUmum {
    private String jenis;
    private int kapasitas;

    public Kendaraan(int id, String jenis, int kapasitas) {
        super(id);
        this.jenis = jenis;
        this.kapasitas = kapasitas;
    }

    public String getJenis() {
        return jenis;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    // Polymorphic method yang dioverride di Mobil/Bus
    @Override
    public String getDetails() {
        return "ID: " + getId() + ", Jenis: " + jenis + ", Kapasitas: " + kapasitas;
    }

    // Harus dioverride oleh subclass
    public abstract double hitungBiaya(double jarak);

}
