import java.awt.*;
import java.util.Random;

/**
 * Created by Simon on 2017-01-31.
 */

public abstract class Animal extends LivingThing {
    private int maxFood = 30;
    private int currentFood = 30;
    public int randomNumber(){
        int Low = -1;
        int High = 2;
        int rnum = r.nextInt(High-Low) + Low;
        return rnum;
    }
    private Random r = new Random();

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
        //currentFood--;
        if(currentFood==0){
            pasture.removeEntity(this);
        }
    }
}
