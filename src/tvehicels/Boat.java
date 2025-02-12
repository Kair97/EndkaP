package tvehicels;

import endpr.Vehicle;

public class Boat extends Vehicle {
    int length;
    int usedYear;

    public Boat(int id, String brand, boolean isAvailable, int price, int length, int usedYear) {
        super(id, brand, isAvailable, price);
        this.length = length;
        this.usedYear = usedYear;
    }

    @Override
    public void details() {
        super.details();
        System.out.println("Boat Length: " + length + " meters");
        System.out.println("Used for: " + usedYear + " years");
    }
}