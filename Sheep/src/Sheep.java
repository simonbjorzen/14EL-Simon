import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import javax.swing.text.html.parser.*;
import java.util.*;
import java.awt.*;

public class Sheep implements Entity {
    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/sheep.gif"));
    protected Point position;
    protected Pasture pasture;
    private Random r = new Random();


  /* public Sheep(Pasture pasture) {
        this.pasture = pasture;
    }*/

    public Sheep(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

    public int randomNumber(){
        int Low = -1;
        int High = 2;
        int rnum = r.nextInt(High-Low) + Low;
        return rnum;
    }

    public Point moveEnt(){
        int rx = randomNumber();
        int ry = randomNumber();
        int moveX=(int)getPosition().getX();
        int moveY=(int)getPosition().getY();

        if (rx==1){
            if(getPosition().getX()<29){
                moveX++;
            }
        }
        else if (rx==-1){
            if(getPosition().getX()>1){
                moveX--;
            }
        }
        if (ry==1){
            if(getPosition().getY()<29){
                moveY++;
            }
        }
        else if (ry==-1){
            if(getPosition().getY()>1){
                moveY--;
            }
        }

        Point rPoint = new Point(moveX, moveY);

        return rPoint;
    }


    public void tick() {
        setPosition(moveEnt());
    }

    public String type() {
        return "Sheep";
    }

    public ImageIcon getImage() {
        return image;
    }

}
