import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Sheep implements Entity {

    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/sheep.gif"));

    protected Point position;

    protected Pasture pasture;
   
    public Sheep(Pasture pasture) {
	this.pasture = pasture;
    }

    public Sheep(Pasture pasture, Point position) {
	this.pasture   = pasture;
	this.position  = position;
    }
    
    public Point getPosition() { return position; }

    
    public void setPosition(Point newPosition) { position = newPosition; }

    private int randomPosition(){
        Random randomObj = new Random();
        int rnum;
        rnum = randomObj.ints(-1, 2).findFirst().getAsInt();
        return rnum;
    }
    private double setPosY(){
        int num=randomPosition();
        double rnum=getPosition().getY();
        if (num==-1)
        {
            rnum=getPosition().getY()-1;
        }
        if (num==1)
        {
            rnum=getPosition().getY()+1;
        }
        if (rnum>=29){
            rnum=28;
        }
        if (rnum<=1){
            rnum=2;
        }
        return rnum;

    }
    private double setPosX(){
        int num=randomPosition();
        double rnum=getPosition().getX();

        if (num==-1)
        {
            rnum=getPosition().getX()-1;
        }
        if (num==1)
        {
            rnum=getPosition().getX()+1;
        }
        if (rnum>=29){
            rnum=28;
        }
        if (rnum<=1){
            rnum=2;
        }

        return rnum;
    }
    public void tick() {
	    setPosition(new Point((int)setPosX(),(int)setPosY()));
        System.out.println(randomPosition());
        }


    public String type() {
	return "Sheep";
    }
    
    public ImageIcon getImage() { return image; }

   
}
