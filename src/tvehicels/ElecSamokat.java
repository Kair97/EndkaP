package tvehicels;

import endpr.Vehicle;

public class ElecSamokat extends Vehicle {
    int capacityofbattery;
    int speed;

    public ElecSamokat(int id, String brand, int capacityofbat, int speed) {
        super(id, brand);
        this.capacityofbattery = capacityofbat;
        this.speed = speed;
    }

    public void details() {
        super.details();
        System.out.println("Capacity of the battery (Wh): " + capacityofbattery);
        System.out.println("Max speed (km/h): " + speed);
    }

}
