import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.MissingResourceException;
import java.util.Set;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class Pasture implements ActionListener {

    private final int SPEED_REFERENCE = 1000;
    private Set world = Collections.synchronizedSet(new HashSet());
    private int speed = 2;
    private Timer timer = new Timer(SPEED_REFERENCE / speed, this);
    private int width = 31;
    private int height = 31;
    private Random r = new Random();

    public Point getRandomPos(){
        int Low = 1;
        int High = 29;
        int Result1 = r.nextInt(High-Low) + Low;
        int Result2 = r.nextInt(High-Low) + Low;
        Point pos = new Point(Result1, Result2);
        return pos;
    }


    private Core gui;
    public Pasture(Core gui) {
        this.gui = gui;

        try {

        /*    Point position = getRandomPos();
            Entity sheep = new Sheep(this, position);
            addEntity(sheep); */

            Point position1 = getRandomPos();
            Entity sheep = new SheepTwo(this, position1);
            addEntity(sheep);

            Point position2 = getRandomPos();
            Entity wolf = new WolfTwo(this, position2);
            addEntity(wolf);


            for(int i=0; i<=30; i++){  //Set the X row with fences
                Point fencepos1 = new Point(i, 0);
                Entity fence1 = new Fence(this, fencepos1);
                addEntity(fence1);
                Point fencepos2 = new Point(i, 30);
                Entity fence2 = new Fence(this, fencepos2);
                addEntity(fence2);
            }
            for(int i=0; i<=30; i++){  //Set the Y row with fences
                Point fencepos1 = new Point(0, i);
                Entity fence1 = new Fence(this, fencepos1);
                addEntity(fence1);
                Point fencepos2 = new Point(30, i);
                Entity fence2 = new Fence(this, fencepos2);
                addEntity(fence2);
            }
            Point enginepos = new Point(0, 0);
            Entity engine = new Engine(this, enginepos);
            addEntity(engine);




        } catch (MissingResourceException pe) {
            System.err.println("Pasture.initPasture(): " + pe.getMessage());
            System.exit(20);
        }


    }
    public void createSheep(Point position){
        Entity sheep = new SheepTwo(this, position);
        addEntity(sheep);
    }
    public void createWolf(Point position){
        Entity wolf = new WolfTwo(this, position);
        addEntity(wolf);
    }
    public void createPlant(Point position){
        Entity plant = new Plant(this, position);
        addEntity(plant);
    }

    public void makePlant(Point position){
            Entity plant = new Plant(this, position);
            addEntity(plant);
        }

    public void actionPerformed(ActionEvent e) {
        Iterator it = getEntities().iterator();

        while (it.hasNext()) {
            ((Entity) it.next()).tick();
            gui.updateAll();
        }

    }


    public void addEntity(Entity entity) {
        synchronized (world) {
            world.add(entity);
        }
    }

    public Collection getEntities() {
        HashSet currentWorld = new HashSet();

        synchronized (world) {
            Iterator it = world.iterator();

            while (it.hasNext())
                currentWorld.add(it.next());
        }

        return currentWorld;
    }


    public void removeEntity(Entity entity) {
        synchronized (world) {
            world.remove(entity);
        }
    }

    public void start() {

        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}



