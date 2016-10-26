/**
 * Created by simon on 10/26/16.
 */
public class TestShapes {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(4.0, 5.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        System.out.println(rectangle.getArea());
        System.out.println(triangle.getArea());
    }
}
