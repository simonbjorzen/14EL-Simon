import java.util.Scanner;

/**
 * Created by simon on 10/19/16.
 */
public class Program {
    public static void main(String[] args) {
        Bicycle bike = new Bicycle();
        Car sedan = new Car();
        Truck freighter = new Truck();
        System.out.println("Welcome to this amazing piece of shit software written by Simon Björzén!");
        System.out.println(" ");
        System.out.println("What would you like to do?");
        System.out.println(" ");
        System.out.println("1. Calculate the price of a product while it's on sale.");
        System.out.println("2. Calculate the gas usage of your vehicle.");
        int ans;
        Scanner reader = new Scanner(System.in);
        ans = reader.nextInt();
        switch (ans) {
            case 1: {
                System.out.println("Which vehicle is this sale on?");
                System.out.println(" ");
                System.out.println("1. The Bicycle");
                System.out.println("2. The Car");
                System.out.println("3. The Truck");
                int ans1;
                ans1 = reader.nextInt();
                switch (ans1) {
                    case 1: {
                        System.out.println("What is the percentage of the sale?");
                        double percent = reader.nextInt();
                        double percent1 = percent / 100;
                        double price = bike.price * percent1;
                        double finalprice = bike.price - price;
                        System.out.print("Priset efter rabatten blir ");
                        System.out.print(finalprice);
                        System.out.print(" kronor.");
                        System.out.println("");
                        break;
                    }
                    case 2: {
                        System.out.println("What is the percentage of the sale?");
                        double percent = reader.nextInt();
                        double percent1 = percent / 100;
                        double price = sedan.price * percent1;
                        double finalprice = sedan.price - price;
                        System.out.print("Priset efter rabatten blir ");
                        System.out.print(finalprice);
                        System.out.print(" kronor.");
                        System.out.println("");
                        break;
                    }
                    case 3: {
                        System.out.println("What is the percentage of the sale?");
                        double percent = reader.nextInt();
                        double percent1 = percent / 100;
                        double price = freighter.price * percent1;
                        double finalprice = freighter.price - price;
                        System.out.print("Priset efter rabatten blir ");
                        System.out.print(finalprice);
                        System.out.print(" kronor.");
                        System.out.println("");
                        break;
                    }
                    default: {
                        System.out.println("Error!");
                        break;
                    }
                }

            }
            case 2: {
                System.out.println("Which vehicle do you want to know the gas usage of?");
                System.out.println(" ");
                System.out.println("1. The Bicycle");
                System.out.println("2. The Car");
                System.out.println("3. The Truck");
                int ans2;
                ans2 = reader.nextInt();
                switch (ans2) {
                    case 1: {
                        System.out.println(bike.gasusage + " liters/10km");
                        break;
                    }
                    case 2: {
                        System.out.println(sedan.gasusage + " liters/10km");
                        break;
                    }
                    case 3: {
                        System.out.println(freighter.gasusage + " liters/10km");
                        break;
                    }
                    default: {
                        System.out.println("Error!");
                        break;
                    }
                }
            }
        }
    }

}
