package tvehicels;

import endpr.Vehicle;

public class ElecSamokat extends Vehicle {
    int capacityOfBattery;
    int maxSpeed;

    public ElecSamokat(int id, String brand, boolean isAvailable, int price, int capacityOfBattery, int maxSpeed) {
        super(id, brand, isAvailable, price); // Передаем данные в базовый класс
        this.capacityOfBattery = capacityOfBattery;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void details() {
        super.details();
        System.out.println("Battery Capacity: " + capacityOfBattery + " Wh");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}