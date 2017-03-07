import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Iterator;

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
        checkEnt();
    }
    public void checkEnt(){
        /*Iterator it = pasture.getEntities().iterator();
        while (it.hasNext()) {
            Entity ent = (Entity)it.next();
            if(!ent.type().equals("Fence")) {
                System.out.print(ent.type());
                System.out.print((int)ent.getPosition().getX());
                System.out.println((int)ent.getPosition().getY());
            }
        }
        System.out.println("--------");*/



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
    public boolean isThing(){
        return true;
    }
}
