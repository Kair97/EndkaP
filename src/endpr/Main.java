package endpr;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import tvehicels.*;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Add new User");
        System.out.println("Enter Username");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();



        Connection con = DatabaseHandler.getDbhand().getConnection();{

            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate("INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "');");

                String selectSql = "SELECT username, password FROM users";
                try (PreparedStatement pstmt = con.prepareStatement(selectSql);
                     ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("username "+resultSet.getString("username"));
                        System.out.println("password "+resultSet.getString("password"));
                        System.out.println();
                    }
                }
            }

        }

    }


}