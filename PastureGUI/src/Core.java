import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;


public class Core implements ActionListener {
    
    private final int  SPEED_REFERENCE = 1000; /* 1000 */
    private final int speed          = 10;
    private final Timer      timer   = new Timer(SPEED_REFERENCE/speed,this);
    private int              time    = 0;

    private Pasture pasture;


    public Core(Pasture pasture) {
        this.pasture = pasture;
    }

    public void actionPerformed(ActionEvent event) {
     
        List<Entity> queue = pasture.getEntities();

        try {
            for (Entity e : queue) {
                e.tick();
            }

            for( Entity entity : queue ) {
                if( ! entity.isAlive() ) {
                    System.out.println( "  removing: " + entity );
                    pasture.removeEntity( entity );
                }
            }

        } catch( NullPointerException e ) {
            System.out.println( "Core: " + e );
            System.exit(0);
        }

        pasture.refresh();
        time++;
    }

    public void setSpeed(int speed) {
        timer.setDelay(SPEED_REFERENCE/speed);
    }

    public void start() {
        setSpeed(speed);
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getTime () {
        return time;
    }

}
