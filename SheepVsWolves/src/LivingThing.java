import javax.swing.*;
import java.util.*;
import java.awt.*;

/**
 * Created by simon on 1/25/17.
 */
public abstract class LivingThing implements Entity {
    protected Point position;
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/unknown.gif"));
    public Point getPosition() { return position; }
    public void setPosition(Point newPosition) { position = newPosition;}
    public ImageIcon getImage() { return image; }
}
