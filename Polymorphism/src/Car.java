/**
 * Created by simon on 10/19/16.
 */
public class Car extends Vehicle {
    public String licenseplate; // The license plate's text
    public int horsepower; // The amount of horsepowers that are in the vehicle
    public double gasusage; // How much gas the vehicle uses each 10 k


    public Car() {
        licenseplate = "CAR123";
        horsepower = 230;
        gasusage = 0.7;
        price=30000;
        color="Black";
        weight=2100;
    }
}