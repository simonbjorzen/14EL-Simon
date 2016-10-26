/**
 * Created by simon on 10/19/16.
 */
public class Truck extends Vehicle  {
    public String licenseplate; // The license plate's text
    public int horsepower; // The amount of horsepowers that are in the vehicle
    public double gasusage; // How much gas the vehicle uses each 10 km
    public int storage; // Storage space in m²

    public Truck(){
        licenseplate="TRU123";
        horsepower=450;
        gasusage=1.2;
        storage=25;
        price=60000;
        color="Red";
        weight=3900;
    }
}
