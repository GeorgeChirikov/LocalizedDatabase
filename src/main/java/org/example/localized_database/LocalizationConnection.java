package org.example.localized_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalizationConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/localized_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Password";
    private static int id = 0;
    private static Connection conn;
    private static String language;

    public static void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setLanguage(String lng) {
        language = lng;
    }

    public static void saveData(String firstName, String lastName, String email) {
        String sql = "";
        if (language.equals("English")) {
            sql = "INSERT INTO employee_en (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("Japanese")) {
            sql = "INSERT INTO employee_ja (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("Farsi")) {
            sql = "INSERT INTO employee_fa (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("French")) {
            sql = "INSERT INTO employee_fr (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("German")) {
            sql = "INSERT INTO employee_de (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("Spanish")) {
            sql = "INSERT INTO employee_es (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("Russian")) {
            sql = "INSERT INTO employee_ru (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("Swedish")) {
            sql = "INSERT INTO employee_sv (first_name, last_name, email) VALUES (?, ?, ?)";
        } else if (language.equals("Finnish")) {
            sql = "INSERT INTO employee_su (first_name, last_name, email) VALUES (?, ?, ?)";
        }

        System.out.println("Saving data...");
        id++;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("Data saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
