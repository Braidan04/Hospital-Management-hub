package com.hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private int id;
    private String name;
    private String specialty;

    // Constructor for Doctor objects
    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }

    // Static method to register a doctor in the database
    public static void registerDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialty = scanner.nextLine();

        try (Connection conn = Database.connect()) {
            String query = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, specialty);
            stmt.executeUpdate();
            System.out.println("✅ Doctor registered successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}