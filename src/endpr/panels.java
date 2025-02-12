package endpr;

import tvehicels.addVehF;

import java.sql.*;
import java.util.Scanner;

public class panels {
    static addVehF addVeh = new addVehF();
    static RentalSystem rent = new RentalSystem();
    static Scanner sc = new Scanner(System.in);


    public static void openAdminPanel() {
        System.out.println("Welcome to the Admin Panel!");
        while (true) {
            System.out.println("1. Add vehicle");
            System.out.println("2. Remove vehicle");
            System.out.println("3. Change vehicle");
            System.out.println("4. Update a customer status");
            System.out.println("6. Display all available vehicles");
            System.out.println("99. Exit the program");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addVehicle();
                    break;
                case "2":
                    removeVehicle();
                    break;
                case "3":
                    changeVehicle();
                    break;
                case "4":
                    updcustst();
                    break;
                case "6":
                    rent.displayAvailableVehicles();
                    break;
                case "99":
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    public static void openCustomerPanel() {
        System.out.println("Welcome to the Customer Panel!");
        while (true) {
            System.out.println("1. Search for a Vehicle by its ID");
            System.out.println("2. Rent a vehicle");
            System.out.println("3. Return a rented vehicle");
            System.out.println("6. Display all available vehicles");
            System.out.println("7. Show all rented vehicles");
            System.out.println("99. To exit the program");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    searchVehicle();
                    break;
                case "2":
                    rentVehicle();
                    break;
                case "3":
                    returnVehicle();
                    break;
                case "6":
                    rent.displayAvailableVehicles();
                    break;
                case "7":
                    rentedVeh();
                    break;
                case "99":
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
    public static void rentedVeh() {
        System.out.print("Enter your username (as logged in): ");
        String username = sc.nextLine();

        Connection con = null;
        try {

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kaireke");

            String query = "SELECT rentedveh FROM customers WHERE username = ?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setString(1, username);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Integer[] rentedVehicles = (Integer[]) rs.getArray("rentedveh").getArray();

                        if (rentedVehicles == null || rentedVehicles.length == 0) {
                            System.out.println("You have not rented any vehicles.");
                            return;
                        }

                        System.out.println("Your Rented Vehicles:");
                        for (int vehicleId : rentedVehicles) {
                            Vehicle vehicle = rent.searchVehicleByID(vehicleId);
                            if (vehicle != null) {
                                vehicle.details();
                            } else {
                                System.out.println("Vehicle with ID " + vehicleId + " not found.");
                            }
                        }
                    } else {
                        System.out.println("Customer not found. Please check the username.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException closeEx) {
                    System.out.println(closeEx.getMessage());
                }
            }
        }
    }

    public static void addVehicle() {
        addVehF addveh = new addVehF();

            while(true){
                System.out.println("To go back enter \"987\"");
                System.out.println("If you also want to exit the system write code word: hint: A.k");

                System.out.println("Do you want to add vehilce? (y/n)");
                Scanner sc = new Scanner(System.in);
                String vehType = sc.nextLine();

                if(vehType.equalsIgnoreCase("y")){
                    addveh.addV();
                } else if(vehType.equals("Abeke kachok") || vehType.equals("n")){
                    System.out.println("Exiting the system");
                    return;
                }else if(vehType.equalsIgnoreCase("987")){
                    System.out.println("Exiting the system");
                    openAdminPanel();
                }else{
                    System.out.println("y means yes , n means no");
                }

            }
    }

    public static void removeVehicle() {
        System.out.print("Enter the ID of the vehicle you want to remove: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            rent.removeVehicle(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid numeric ID.");
        }
    }

    public static void changeVehicle() {
        System.out.print("Enter the ID of the vehicle you want to change: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            rent.removeVehicle(id);
            System.out.println("Vehicle removed successfully.");
            System.out.println("Now add the new vehicle details.");
            addVehicle();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid numeric ID.");
        }
    }

    public static void searchVehicle() {
        System.out.print("Enter ID to search for a vehicle: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            Vehicle vehicle = rent.searchVehicleByID(id);
            if (vehicle != null) {
                vehicle.details();
            } else {
                System.out.println("Vehicle not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid numeric ID.");
        }
    }

    public static void rentVehicle() {
        System.out.print("Enter vehicle ID to rent: ");
        Connection con = null;

        try {
            int rentID = Integer.parseInt(sc.nextLine());
            Vehicle rentVehicle = rent.searchVehicleByID(rentID);

            if (rentVehicle != null && rentVehicle.isAvailable()) {
                System.out.print("Enter your username (as logged in): ");
                String username = sc.nextLine();

                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kaireke");
                con.setAutoCommit(false);

                String updateCustomerQuery = "UPDATE customers SET rentedveh = array_append(rentedveh, ?) WHERE username = ?";
                try (PreparedStatement stmtCustomer = con.prepareStatement(updateCustomerQuery)) {
                    stmtCustomer.setInt(1, rentID);
                    stmtCustomer.setString(2, username);
                    int customerUpdateRows = stmtCustomer.executeUpdate();

                    if (customerUpdateRows == 0) {
                        System.out.println("Failed to update customer's record. Verify username.");
                        con.rollback();
                        return;
                    }
                }

                String updateVehicleQuery = "UPDATE \"Vehicles\" SET isable = FALSE WHERE id = ?";
                try (PreparedStatement stmtVehicle = con.prepareStatement(updateVehicleQuery)) {
                    stmtVehicle.setInt(1, rentID);
                    int vehicleUpdateRows = stmtVehicle.executeUpdate();

                    if (vehicleUpdateRows == 0) {
                        System.out.println("Failed to update vehicle status.");
                        con.rollback();
                        return;
                    }
                }

                con.commit();
                System.out.println("Vehicle successfully rented.");
            } else {
                System.out.println("Vehicle either not found or already rented.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric vehicle ID.");
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback failed: " + rollbackEx.getMessage());
                }
            }
            System.out.println("Error during rent operation: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException closeEx) {
                    System.out.println("Database connection close failed: " + closeEx.getMessage());
                }
            }
        }
    }

    public static void returnVehicle() {
        System.out.print("Enter vehicle ID to return: ");
        Connection con = null;

        try {
            int returnID = Integer.parseInt(sc.nextLine());
            Vehicle returnVehicle = rent.searchVehicleByID(returnID);

            if (returnVehicle != null && !returnVehicle.isAvailable()) {
                System.out.print("Enter your username (as logged in): ");
                String username = sc.nextLine();

                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kaireke");
                con.setAutoCommit(false);

                String updateCustomerQuery = "UPDATE customers SET rentedveh = array_remove(rentedveh, ?) WHERE username = ?";
                try (PreparedStatement stmtCustomer = con.prepareStatement(updateCustomerQuery)) {
                    stmtCustomer.setInt(1, returnID);
                    stmtCustomer.setString(2, username);
                    int customerUpdateRows = stmtCustomer.executeUpdate();

                    if (customerUpdateRows == 0) {
                        System.out.println("Failed to update customer's record. Verify username or vehicle ID.");
                        con.rollback();
                        return;
                    }
                }

                String updateVehicleQuery = "UPDATE \"Vehicles\" SET isable = TRUE WHERE id = ?";
                try (PreparedStatement stmtVehicle = con.prepareStatement(updateVehicleQuery)) {
                    stmtVehicle.setInt(1, returnID);
                    int vehicleUpdateRows = stmtVehicle.executeUpdate();

                    if (vehicleUpdateRows == 0) {
                        System.out.println("Failed to update vehicle status.");
                        con.rollback();
                        return;
                    }
                }

                con.commit();
                System.out.println("Vehicle successfully returned.");
            } else {
                System.out.println("Vehicle not found or is already available.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric vehicle ID.");
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback failed: " + rollbackEx.getMessage());
                }
            }
            System.out.println("Error during return operation: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException closeEx) {
                    System.out.println("Database connection close failed: " + closeEx.getMessage());
                }
            }
        }
    }

    public static void updcustst() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "kaireke";
        System.out.println("Enter the username of the customer:");
        try {
            String username = sc.nextLine();
            System.out.println("Do you want to make them admin or make from admin to customer? (a/c)");
            String option = sc.nextLine();

            if (!option.equalsIgnoreCase("a") && !option.equalsIgnoreCase("c")) {
                System.out.println("Wrong option, use 'a' to make admin or 'c' to make customer from admin.");
                return;
            }

            boolean newAdm = option.equalsIgnoreCase("a");

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                con.setAutoCommit(false);
                String userq;
                if (newAdm) {
                    userq = "DELETE FROM customers WHERE username = ?; INSERT INTO admins (username) VALUES (?); UPDATE users SET admin = ? WHERE username = ?";
                } else {
                    userq = "DELETE FROM admins WHERE username = ?; INSERT INTO customers (username) VALUES (?); UPDATE users SET admin = ? WHERE username = ?";
                }

                try (PreparedStatement stmt = con.prepareStatement(userq)) {
                    stmt.setString(1, username);
                    stmt.setString(2, username);
                    stmt.setBoolean(3, newAdm);
                    stmt.setString(4, username);

                    stmt.executeUpdate();
                    con.commit();
                    System.out.println("user's status updated successfully.");
                } catch (SQLException e) {
                    con.rollback();
                    System.out.println(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
