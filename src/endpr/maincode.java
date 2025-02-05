/*package endpr;

import java.util.Scanner;

public class maink {
    public static void main(String[] args) {
        RentalSystem rent = new RentalSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Authorization");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        boolean yes = false;
        if("admin".equals(username) && "admin".equals(password)) {
            yes = true;
            System.out.println("What do you want to update?: ");
            while (true){
                System.out.println("1. Add vehicle");
                System.out.println("2. Remove vehicle");
                System.out.println("3. Change vehicle");
                System.out.println("99. Exit the program");
                System.out.println("6. Display all available vehicles");
                String choice = sc.nextLine();

                switch(choice){
                    case "1":
                        System.out.print("Enter the number of vehicles you want to add: ");
                        int n1 = Integer.parseInt(sc.nextLine());
                        for (int i = 1; i <= n1; i++) {
                            System.out.print("What do you want to add (car or bike or boat or elsamokat): ");
                            String veh = sc.nextLine();
                            System.out.print("Enter Vehicle ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Brand: ");
                            String brand = sc.nextLine();

                            if ("car".equalsIgnoreCase(veh)) {
                                System.out.print("Enter Seating Capacity: ");
                                int seatingCapacity = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter Fuel Type: ");
                                String fuelType = sc.nextLine();
                                rent.addVehicle(new Car(id, brand, seatingCapacity, fuelType));
                            } else if ("bike".equalsIgnoreCase(veh)) {
                                System.out.print("Enter Engine Capacity (in cc): ");
                                int engineCapacity = Integer.parseInt(sc.nextLine());
                                System.out.print("Does it include a helmet? (true/false): ");
                                boolean hasHelmet = Boolean.parseBoolean(sc.nextLine());
                                rent.addVehicle(new Motorbike(id, brand, engineCapacity, hasHelmet));

                            } else if ("boat".equalsIgnoreCase(veh)) {
                                System.out.print("Enter the length of the boat: ");
                                int length = Integer.parseInt(sc.nextLine());
                                System.out.print("How many years have been used for : ");
                                int usedyear = Integer.parseInt(sc.nextLine());
                                rent.addVehicle(new Boat(id, brand, length, usedyear));

                            }else if ("elsamokat".equalsIgnoreCase(veh)) {
                                System.out.print("Enter the capacity of the battery: ");
                                int capacityofbattery = Integer.parseInt(sc.nextLine());
                                System.out.print("What is the max speed: ");
                                int speed = Integer.parseInt(sc.nextLine());
                                rent.addVehicle(new ElecSamokat(id, brand, capacityofbattery, speed));

                            }
                            else {
                                System.out.println("Invalid Vehicle Type");
                            }
                        }
                        break;
                    case "2":
                        System.out.print("Enter the ID of vehicles you want to remove: ");
                        int id = Integer.parseInt(sc.nextLine());
                        rent.removeVehicle(id);
                        break;case "3":
                        System.out.print("Enter the ID of vehicles you want to change: ");
                        id = Integer.parseInt(sc.nextLine());
                        rent.removeVehicle(id);

                        break;

                    case "6":
                        rent.displayAvailableVehicles();
                        break;

                    case "99":
                        System.out.println("Exiting the program.");
                        return;

                }
            }
        }
        else{
            while (true) {

                System.out.println("2. Display all vehicles");
                System.out.println("3. Search for a Vehicle by its ID");
                System.out.println("4. Rent a vehicle");
                System.out.println("5. Return a rented vehicle");
                System.out.println("6. Display all available vehicles");
                System.out.println("99. To exit the program");
                System.out.print("Enter your choice: ");
                String choice = sc.nextLine();

                switch (choice) {

                    case "2":
                        rent.displayAllVehicles();
                        break;

                    case "3":
                        System.out.print("Enter id to search vehicle: ");
                        int id = Integer.parseInt(sc.nextLine());
                        Vehicle vehicle = rent.searchVehicleByID(id);
                        if (vehicle != null) {
                            vehicle.details();
                        } else {
                            System.out.println("Vehicle not found.");
                        }
                        break;

                    case "4":
                        System.out.print("Enter vehicle id to rent: ");
                        int rentID = Integer.parseInt(sc.nextLine());
                        Vehicle rentVehicle = rent.searchVehicleByID(rentID);
                        if (rentVehicle != null) {
                            rentVehicle.rent();
                        } else {
                            System.out.println("vehicle not found.");
                        }
                        break;

                    case "5":
                        System.out.print("Enter vehicle id to return: ");
                        int returnID = Integer.parseInt(sc.nextLine());
                        Vehicle returnVehicle = rent.searchVehicleByID(returnID);
                        if (returnVehicle != null) {
                            returnVehicle.returnVehicle();
                        } else {
                            System.out.println("Vehicle not found.");
                        }
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
    }
}*/