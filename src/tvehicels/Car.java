package tvehicels;

import endpr.Vehicle;
import tvehicels.*;

public class Car extends Vehicle {

    int seatingCapacity;
    String fueltype;

    public Car(int id, String brand, int seatingCapacity, String fueltype) {
        super(id, brand);
        this.seatingCapacity = seatingCapacity;
        this.fueltype = fueltype;
    }

    public void details() {
        super.details();
        System.out.println("Seating Capacity: " + seatingCapacity);
        System.out.println("Fuel Type: " + fueltype);
    }

}


