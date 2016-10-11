package game;
import java.awt.*;


/**
 * Created by simon on 10/11/16.
 */
public class Brick
{
        private int x=480; //Location för brick
        private int y=0; //Location för brick
        private int width=40; //vidd på brick
        private int height=10; //höjd på brick

        Game game;
        public Brick(Game game){
            this.game = game;
        }
        public void paint(Graphics2D g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
        }
        public Rectangle getBounds(){
        return new Rectangle(x, y, d, d);
    }
        private boolean collision(){
        return game.ball.getBounds().intersects(getBounds());
    }



}
