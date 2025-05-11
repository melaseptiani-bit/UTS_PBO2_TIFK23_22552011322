package com.mycompany.kasirtransportasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnections {

    private static final String URL = "jdbc:mysql://localhost:3306/kasirtransportasi";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // sesuaikan dengan password MySQL-mu

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Gagal koneksi ke database: " + e.getMessage());
            return null;
        }
    }
}
