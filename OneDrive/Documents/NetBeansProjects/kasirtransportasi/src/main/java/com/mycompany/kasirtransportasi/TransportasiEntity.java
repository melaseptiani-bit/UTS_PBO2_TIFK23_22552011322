package com.mycompany.kasirtransportasi;

public abstract class TransportasiEntity {
    private int id;

    public TransportasiEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Polymorphism: method ini akan dioverride oleh Mobil/Bus
    public abstract String getDetails();
}