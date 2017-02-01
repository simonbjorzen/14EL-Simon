import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;

public class Pasture implements ActionListener {

    /** A reference to use when setting the speed. */
    private final int  SPEED_REFERENCE = 1000;
    /** The entities that this pasture contains. */
    private Set        world = Collections.synchronizedSet(new HashSet());
    /** The speed of this simulation. */
    private int        speed           = 3;
    /** The timer that triggers ticks to be sent out to the entities. */
    private Timer      timer           = new Timer(SPEED_REFERENCE/speed,this);
    /** The width of this pasture */
    private int         width          = 30;
    /** The height of this pasture */
    private int         height         = 30;
   

    private PastureGUI gui;

    private int randomPosition(){
        Random randomObj = new Random();
        int rnum;
        rnum = randomObj.ints(1, 29).findFirst().getAsInt();
        return rnum;
    }
    private int setPos() {
        Random randomObj = new Random();
        int rnum;
        rnum = randomObj.ints(1, 29).findFirst().getAsInt();
        return rnum;
    }

    public Pasture(PastureGUI gui) {
	this.gui = gui;
        try {
            Point position1 = new Point(randomPosition(), randomPosition());
	        Entity sheep = new Sheep(this, position1);
	        addEntity(sheep);
            Point position2 = new Point(randomPosition(), randomPosition());
            Plant plant = new Plant(this, position2);
            addEntity(plant);

            }
        catch (MissingResourceException pe) {
            System.err.println("Pasture.initPasture(): " + pe.getMessage());
            System.exit(20);
        }
    }

  
    public void actionPerformed(ActionEvent e) {
	Iterator it = getEntities().iterator();

	while(it.hasNext()) {
	    ((Entity)it.next()).tick();
	    gui.updateAll();

        	}
	
    }


    public void addEntity(Entity entity) {
	synchronized(world) {
	    world.add(entity);
	}
    }

    public Collection getEntities() {
	HashSet currentWorld = new HashSet();

        synchronized(world) {
	    Iterator it = world.iterator();

	    while(it.hasNext()) 
		currentWorld.add(it.next());
	}

	return currentWorld;
    }
        
   
    public void removeEntity(Entity entity) { 
	synchronized(world) {
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



