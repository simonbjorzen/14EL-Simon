import javax.swing.*;
import javax.swing.text.html.parser.*;
import java.util.*;
import java.awt.*;

public class Fence implements Entity {
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/fence.gif"));
    protected Point position;
    protected Pasture pasture;

  /*  public Fence(Pasture pasture) {
       this.pasture = pasture;
    }*/

    public Fence(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

    public void tick() {
        //ADD TICK HERE
    }

    public String type() {
        return "Fence";
    }

    public ImageIcon getImage() {
        return image;
    }
}
