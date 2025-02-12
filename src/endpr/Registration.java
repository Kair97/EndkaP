package endpr;

import java.sql.*;
import java.util.Scanner;

public class Registration {

    public static void main(String[] args) throws Exception {
        registr();
    }

    public static void registr() throws Exception {
        System.out.println("Registration");
        Scanner sc = new Scanner(System.in);

        try (Connection con = DatabaseHandler.getDbhand().getConnection()) {
            System.out.println("Enter Username:");
            String username = sc.nextLine();

            if (usernameExists(username, con)) {
                System.out.println("This username already exists. Please choose another username.");
                System.out.println("Enter Username:");
                username = sc.nextLine();
            }

            System.out.println("Enter Password:");
            String password = sc.nextLine();

            System.out.println("Confirm Password:");
            String confirmPassword = sc.nextLine();

            while (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match. Try again.");
                System.out.println("Enter Password:");
                password = sc.nextLine();

                System.out.println("Confirm Password:");
                confirmPassword = sc.nextLine();
            }

            String insertSql = "INSERT INTO customers (username, password) VALUES (?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(insertSql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                System.out.println("Registration successful!");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static boolean usernameExists(String username, Connection con) throws SQLException {
        String query = "SELECT username FROM users WHERE username = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }
}