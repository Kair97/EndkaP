package tvehicels;

import endpr.Vehicle;

public class Motorbike extends Vehicle {
    int engineCapacity;
    boolean hasHelmetIncluded;

    public Motorbike(int id, String brand, int engineCapacity, boolean hasHelmetIncluded) {
        super(id, brand);
        this.engineCapacity = engineCapacity;
        this.hasHelmetIncluded = hasHelmetIncluded;
    }

    @Override
    public void details() {
        super.details();
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println("Helmet Included: " + (hasHelmetIncluded ? "Yes" : "No"));
    }
}
