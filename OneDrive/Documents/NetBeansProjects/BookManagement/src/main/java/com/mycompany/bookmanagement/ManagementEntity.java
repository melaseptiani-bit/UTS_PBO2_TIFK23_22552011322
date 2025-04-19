package com.mycompany.bookmanagement;

public abstract class ManagementEntity {
    private int id;

    public ManagementEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract String getDetails(); // Polymorphism
}    