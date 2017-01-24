import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Dummy implements Entity {

    private final ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("bin/sheep.gif"));

    protected Point position;

    protected Pasture pasture;
   
    public Dummy(Pasture pasture) {
	this.pasture = pasture;
    }

    public Dummy(Pasture pasture, Point position) {
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
    private double setPos1(){
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
        if (rnum==21){
            rnum=20;
        }
        if (rnum==-1){
            rnum=0;
        }
        return rnum;

    }
    private double setPos2(){
        int num2=randomPosition();
        double rnum=getPosition().getX();

        if (num2==-1)
        {
            rnum=getPosition().getX()-1;
        }
        if (num2==1)
        {
            rnum=getPosition().getX()+1;
        }
        if (rnum==21){
            rnum=20;
        }
        if (rnum==-1){
            rnum=0;
        }

        return rnum;
    }
    public void tick() {
	setPosition(new Point((int)setPos2(),(int)setPos1()));
        System.out.println(getPosition());

    }

    public String type() {
	return "Dummy";
    }
    
    public ImageIcon getImage() { return image; }

   
}
