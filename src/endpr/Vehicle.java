package endpr;

public class Vehicle {
    int id;
    String brand;
    Boolean isAvailable;
    int price;

    public Vehicle(int id, String brand){
        this.id = id;
        this.brand = brand;
        this.isAvailable = true;
        this.price = price;
    }
    public int getid() {
        return id;
    }

    public String getbrand() {
        return brand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getprice() {
        return price;
    }

    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Vehicle rented successfully.");
        } else {
            System.out.println("This vehicle is already rented.");
        }
    }
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle returned successfully.");
        } else {
            System.out.println("This vehicle is already available.");
        }
    }

    public void details(){
        System.out.println("Vehicle ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Is available: " + isAvailable);
        System.out.println("Vehicle costs: " + price);
    }

}
