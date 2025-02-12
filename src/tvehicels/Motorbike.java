package tvehicels;

import endpr.Vehicle;

public class Motorbike extends Vehicle {
    int engineCapacity;
    boolean hasHelmetIncluded;

    public Motorbike(int id, String brand, boolean isAvailable, int price, int engineCapacity, boolean hasHelmetIncluded) {
        super(id, brand, isAvailable, price);
        this.engineCapacity = engineCapacity;
        this.hasHelmetIncluded = hasHelmetIncluded;
    }

    @Override
    public void details() {
        super.details();
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
        System.out.println("Helmet Included: " + (hasHelmetIncluded ? "Yes" : "No"));
    }
}