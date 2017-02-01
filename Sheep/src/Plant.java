import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Plant extends LivingThing {
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/plant.gif"));

    public Plant(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }





    public void tick() {
    }

    public String type() {
        return "Plant";
    }

    public ImageIcon getImage() {
        return image;
    }

}
