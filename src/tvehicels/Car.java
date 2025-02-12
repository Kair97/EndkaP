package tvehicels;

import endpr.Vehicle;

public class Car extends Vehicle {
    int seatingCapacity;
    String fuelType;

    public Car(int id, String brand, boolean isAvailable, int price, int seatingCapacity, String fuelType) {
        super(id, brand, isAvailable, price);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void details() {
        super.details();
        System.out.println("Seating Capacity: " + seatingCapacity);
        System.out.println("Fuel Type: " + fuelType);
    }
}