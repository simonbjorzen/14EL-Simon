/**
 * Created by simon on 10/26/16.
 */
public class Triangle extends Shape{
    public Triangle(double a,double b){
        base=b;
        height=a;
    }

    public double getArea(){
        double area=base*height/2;
        return area;
    }
}
