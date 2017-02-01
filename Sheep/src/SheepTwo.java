import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Simon on 2017-01-31.
 */
public class SheepTwo extends Animal{
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/sheep.gif"));

    public SheepTwo(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }

    public String type() {
        return "Sheep";
    }
    public ImageIcon getImage() {
        return image;
    }




    public void tick() {
        super.tick();
    }

    public void checkForGrass(){
    System.out.print("test");

    }
}
