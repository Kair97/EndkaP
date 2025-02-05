package endpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystem {
    Scanner scanner = new Scanner(System.in);
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "kaireke";

    public void removeVehicle(int id) {
        System.out.println("Removing vehicle with id: " + id);

        String sql = "DELETE FROM \"Vehicles\" WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);  // Use setInt instead of converting to String
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle removed successfully!");
            } else {
                System.out.println("No vehicle found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error removing vehicle: " + e.getMessage());
        }
    }


    public void displayAvailableVehicles() {
        String sql = "SELECT * FROM \"Vehicles\" WHERE isable = TRUE";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            boolean foundAvailable = false;

            while (rs.next()) {
                foundAvailable = true;
                System.out.println("Vehicle ID: " + rs.getInt("id"));
                System.out.println("ttype: " + rs.getString("ttype"));
                System.out.println("Brand: " + rs.getString("brand"));
                System.out.println("Price: $" + rs.getInt("price"));
                System.out.println("-------");
            }

            if (!foundAvailable) {
                System.out.println("No vehicles are currently available.");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching available vehicles: " + e.getMessage());
        }
    }


    public Vehicle searchVehicleByID(int id) {
        String sql = "SELECT * FROM \"Vehicles\" WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Vehicle Found:");
                    System.out.println("Vehicle ID: " + rs.getInt("id"));
                    System.out.println("ttype: " + rs.getString("ttype"));
                    System.out.println("Brand: " + rs.getString("brand"));
                    System.out.println("Price: $" + rs.getInt("price"));
                    System.out.println("Available: " + (rs.getBoolean("isable") ? "Yes" : "No"));
                    System.out.println("-------");

                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching for vehicle: " + e.getMessage());
        }

        System.out.println("Vehicle not found.");
        return null;
    }

}
