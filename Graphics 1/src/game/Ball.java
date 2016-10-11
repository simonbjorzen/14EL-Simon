package game;
import java.awt.*;

/**
 * Created by simon on 10/4/16.
 */
public class Ball {
    private int x=500; //Location för bollen
    private int y=0; //Location för bollen
    private int d=50; //Diameter
    private int moveX=1;
    private int moveY=1;
    private int score=0;

    Game game;
    public Ball(Game game){
        this.game = game;
    }
    void moveBall()
    {
        if (x+moveX<=0)
        {
            moveX=1;
        }
        if (x+moveX>game.getWidth()-40)
        {
            moveX=-1;
        }
        if (y+moveY<0)
        {
            moveY=1;
        }
        if (y+moveY>game.getHeight()-40)
        {
            game.gameOver();
        }
        if (collision()){
            moveY=-1;
            setScore();
    }
        x+=moveX;
        y+=moveY;
    }
    public void paint(Graphics2D g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(x,y,d,d);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, d, d);
    }
    private boolean collision(){
        return game.platta.getBounds().intersects(getBounds());
    }

    private void setScore(){
        score=score+1;
    }

    public int getScore(){
        return score;
    }
}
