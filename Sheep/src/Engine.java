import javax.swing.*;
import java.awt.*;

/**
 * Created by Simon on 2017-01-31.
 */
public class Engine implements Entity {
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/fence.gif"));
    protected Point position;
    protected Pasture pasture;
    private int doubletick = 2;

    public Engine(Pasture pasture, Point position) {
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
        doubleTick();
    }
    public void doubleTick(){
        if (doubletick==0){
            //Do this each other tick
            pasture.makePlant(pasture.getRandomPos());
            doubletick=2;
        }
        doubletick--;
    }

    public String type() {
        return "Engine";
    }

    public ImageIcon getImage() {
        return image;
    }
}
