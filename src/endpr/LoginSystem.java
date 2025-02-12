package endpr;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tvehicels.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            Connection conn = DatabaseHandler.getDbhand().getConnection();
            System.out.println("Connected to Database!");

            // User input
            System.out.print("Enter Username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Enter Password: ");
            String inputPassword = scanner.nextLine();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, inputUsername);
            pstmt.setString(2, inputPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                boolean isAdmin = isAdmin(inputUsername);
                if ((inputUsername.equals("admin")&&inputPassword.equals("admin"))||(inputUsername.equals("Kairzhan")&&inputPassword.equals("kachok"))
                || (isAdmin)) {
                    System.out.println("Opening Admin Panel...");
                    openAdminPanel();
                } else {
                    System.out.println("Opening Customer Panel...");
                    openCustomerPanel();
                }
            } else {
                System.out.println("Invalid username or password. Try again.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static boolean isAdmin(String username) throws SQLException {
        String sql = "SELECT admin FROM users WHERE username = ?";

        try (Connection conn = DatabaseHandler.getDbhand().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("admin");
                }
            }
        }

        return false;
    }


    public static void openAdminPanel() {
        System.out.println("Welcome to Admin Panel!");
        panels.openAdminPanel();
    }

    public static void openCustomerPanel() {
        System.out.println("Welcome to Customer Panel!");
        panels.openCustomerPanel();
    }
}
