package tvehicels;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class addVehF {
    Scanner sc = new Scanner(System.in);

    public void addV(){
        System.out.println("Enter vehicle details");
        System.out.print("id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("transport type: ");
        String ttype = sc.nextLine();
        System.out.print("brand: ");
        String brand = sc.nextLine();
        System.out.print("price: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("isable: ");
        Boolean isable = Boolean.parseBoolean(sc.nextLine());


        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kaireke")) {
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
