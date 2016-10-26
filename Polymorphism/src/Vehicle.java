/**
 * Created by simon on 10/19/16.
 */
public abstract class Vehicle {
    protected int price; // The price of the vehicle
    protected int weight; // The weight of the vehicle
    protected String color; // The color of the vehicle

    public void printInfo(){
        System.out.println("Price: "+price);
        System.out.println("Weight: "+weight);
        System.out.println("Color: "+color);
    }
}
