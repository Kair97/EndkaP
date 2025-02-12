package endpr;

public class Vehicle {
    private int id;
    private String ttype;
    private String brand;
    private int price;
    private boolean isAvailable;

    public Vehicle(int id, String ttype, String brand, int price, boolean isAvailable) {
        this.id = id;
        this.ttype = ttype;
        this.brand = brand;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Vehicle(int id, String brand, boolean isAvailable, int price) {
    }

    public int getId() {
        return id;
    }

    public String getTtype() {
        return ttype;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void rent() {
        if (isAvailable) {
            isAvailable = false; // Меняем статус на "арендован"
            System.out.println("The vehicle has been rented successfully.");
        } else {
            System.out.println("This vehicle is already rented.");
        }
    }

    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("The vehicle has been returned successfully.");
        } else {
            System.out.println("This vehicle is already available.");
        }
    }

    public void details() {
        System.out.println("Vehicle ID: " + id);
        System.out.println("Type: " + ttype);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("-------");
    }
}