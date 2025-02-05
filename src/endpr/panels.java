package endpr;

import java.util.Scanner;
import tvehicels.*;

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
            System.out.println("3. Search for a Vehicle by its ID");
            System.out.println("4. Rent a vehicle");
            System.out.println("5. Return a rented vehicle");
            System.out.println("6. Display all available vehicles");
            System.out.println("99. To exit the program");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "3":
                    searchVehicle();
                    break;
                case "4":
                    rentVehicle();
                    break;
                case "5":
                    returnVehicle();
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

    public static void addVehicle() {
        addVehF addveh = new addVehF();

            while(true){

                System.out.println("If you also want to exit the system write code word: hint: A.k");

                System.out.println("Do you want to add vehilce? (y/n)");
                Scanner sc = new Scanner(System.in);
                String vehType = sc.nextLine();

                if(vehType.equalsIgnoreCase("y")){
                    addveh.addV();
                } else if(vehType.equals("Abeke kachok") || vehType.equals("n")){
                    System.out.println("Exiting the system");
                    return;
                } else{
                    System.out.println("y means yes , n means no");
                }

            }
    }

    public static void removeVehicle() {
        System.out.print("Enter the ID of the vehicle you want to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        rent.removeVehicle(id);
    }

    public static void changeVehicle() {
        System.out.print("Enter the ID of the vehicle you want to change: ");
        int id = Integer.parseInt(sc.nextLine());
        rent.removeVehicle(id);
        System.out.println("Now add the new vehicle details.");
        addVehicle();
    }

    public static void searchVehicle() {
        System.out.print("Enter ID to search for a vehicle: ");
        int id = Integer.parseInt(sc.nextLine());
        Vehicle vehicle = rent.searchVehicleByID(id);
        if (vehicle != null) {
            vehicle.details();
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public static void rentVehicle() {
        System.out.print("Enter vehicle ID to rent: ");
        int rentID = Integer.parseInt(sc.nextLine());
        Vehicle rentVehicle = rent.searchVehicleByID(rentID);
        if (rentVehicle != null) {
            rentVehicle.rent();
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public static void returnVehicle() {
        System.out.print("Enter vehicle ID to return: ");
        int returnID = Integer.parseInt(sc.nextLine());
        Vehicle returnVehicle = rent.searchVehicleByID(returnID);
        if (returnVehicle != null) {
            returnVehicle.returnVehicle();
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
