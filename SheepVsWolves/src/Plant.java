import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 * Created by simon on 1/25/17.
 */
public class Plant extends LivingThing {
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/plant.gif"));

    protected Pasture pasture;

    public Plant(Pasture pasture) {
        this.pasture = pasture;
    }
    public Plant(Pasture pasture, Point position) {
        this.pasture   = pasture;
        this.position  = position;
    }
    public void setPosition(Point newPosition) { position = newPosition; }

    private int randomPosition(){
        Random randomObj = new Random();
        int rnum;
        rnum = randomObj.ints(-1, 2).findFirst().getAsInt();
        return rnum;
    }
        private double setPos() {
            int num1=randomPosition();
            double rnum=getPosition().getY();
            if (num1==-1)
            {
                rnum=getPosition().getY()-1;
            }
            if (num1==1)
            {
                rnum=getPosition().getY()+1;
            }
            if (rnum==30){
                rnum=29;
            }
            if (rnum==0){
                rnum=1;
            }
            return rnum;
        }


    public void tick() {

        System.out.println(getPosition());


    }

    public String type() {
        return "Plant";
    }

    public ImageIcon getImage() { return image; }
}
