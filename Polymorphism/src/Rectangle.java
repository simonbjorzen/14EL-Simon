/**
 * Created by simon on 10/26/16.
 */
public class Rectangle extends Shape {
    public Rectangle(double a,double b){
        base=b;
        height=a;
    }
    public double getArea(){

        double area=base*height;
        return area;

    }

}
