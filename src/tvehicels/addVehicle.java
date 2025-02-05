package tvehicels;

import java.util.Scanner;

public class addVehicle {
    static addVehF addveh = new addVehF();
    public static void main(String[] args) throws Exception {
        while(true){

        System.out.println("If you also want to exit the system write code word: hint: A.k");

        System.out.println("Do you want to add vehilce? (y/n)");
        Scanner sc = new Scanner(System.in);
        String vehType = sc.nextLine();

        if(vehType.equalsIgnoreCase("y")){
            addveh.addV();
        } else if(vehType.equals("Abeke kachok")){
            System.out.println("Exiting the system");
            return;
        } else{
            System.out.println("y means yes , n means no");
        }


        }
    }
}