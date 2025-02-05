package tvehicels;

import endpr.Vehicle;

public class Boat extends Vehicle {
    int length;
    int usedyear;

    public Boat(int id, String brand, int length, int usedyear) {
        super(id, brand);
        this.length = length;
        this.usedyear = usedyear;
    }

    public void details() {
        super.details();
        System.out.println("The length if the boat: " + length);
        System.out.println("Used time(year): " + usedyear);
    }


}
