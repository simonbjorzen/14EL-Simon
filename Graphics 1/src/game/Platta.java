package game;

import java.awt.*;
import java.awt.event.KeyEvent;
// Testing Git  
/**
 * Created by simon on 10/4/16.
 */
public class Platta {
    private Game game;
    private int x=470;
    private int y=665;
    private int width=150;
    private int height=10;
    private int moveX=0;

    public Platta(Game game){
    this.game=game;
    }

    public void paint(Graphics2D g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    void move()
    {
        if (x+moveX>0 && x+moveX<game.getWidth()-150)
            x+=moveX;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
        {
        moveX=-2;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            moveX=2;
        }
    }

    public void keyReleased(KeyEvent e){
        moveX=0;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public int getY(){
        return y;
    }
}
