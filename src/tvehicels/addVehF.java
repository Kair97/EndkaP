package tvehicels;

import java.sql.*;
import java.util.Scanner;

public class addVehF {
    Scanner sc = new Scanner(System.in);

    public void addV() {
        System.out.println("Enter vehicle details");

        long id;
        while (true) {
            try {
                System.out.print("id (numeric): ");
                id = Long.parseLong(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value for ID.");
            }
        }

        System.out.print("transport type: ");
        String ttype = sc.nextLine();
        System.out.print("brand: ");
        String brand = sc.nextLine();

        int price;
        while (true) {
            try {
                System.out.print("price (numeric): ");
                price = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for price.");
            }
        }

        System.out.print("isable (true/false): ");
        Boolean isable;
        while (true) {
            try {
                isable = Boolean.parseBoolean(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter true or false for isable.");
            }
        }

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "kaireke";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate("INSERT INTO \"Vehicles\" (id, ttype, brand, price, isable) VALUES ('" + id + "', '" + ttype + "', '" + brand + "', '" + price + "', '" + isable + "');");

                String selectSql = "SELECT id, brand, isable, price, ttype FROM \"Vehicles\"";
                try (PreparedStatement pstmt = con.prepareStatement(selectSql); ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("id: " + resultSet.getString("id"));
                        System.out.println("ttype: " + resultSet.getString("ttype"));
                        System.out.println("brand: " + resultSet.getString("brand"));
                        System.out.println("price: " + resultSet.getString("price"));
                        System.out.println("isable: " + resultSet.getBoolean("isable"));

                        System.out.println();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}