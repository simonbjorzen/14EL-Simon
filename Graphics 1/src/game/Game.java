package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;


public class Game extends JPanel {
Platta platta = new Platta(this);
Ball ball = new Ball(this);
    Font scoreFont = new Font("SansSerif", Font.PLAIN, 30);
    public int timeToStart=3;

    public Game(){
        setBackground(Color.BLACK);
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {

            }


            public void keyPressed(KeyEvent e) {
                platta.keyPressed(e);

            }


            public void keyReleased(KeyEvent e) {
                platta.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    private void move(){
        ball.moveBall();
        platta.move();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        setDoubleBuffered(true);
        g2d.setColor(Color.WHITE);
        g2d.setFont(scoreFont);
        g2d.drawString("Score: "+ball.getScore(), 30,50);
        if (timeToStart!=0) {
            g2d.drawString("The game starts in: " + timeToStart, 650, 50);
        }
        ball.paint(g2d);
        platta.paint(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Game game = new Game();
        frame.add(game);
        frame.setSize(1000, 700);
        frame.setLocation(20,20);
        frame.setDefaultCloseOperation(3);
        frame.setTitle("Graphics");
        frame.setResizable(false);
        frame.setVisible(true);
        game.countDown();
        while(true)
        {
            Toolkit.getDefaultToolkit().sync();
            game.move();
            game.repaint();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void gameOver(){
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public void countDown(){
        try{
            for(int timeLeft = 3; timeLeft>0; timeLeft--){
                repaint();
                TimeUnit.SECONDS.sleep(1);
                timeToStart--;
            }

        }catch (InterruptedException e){}
    }


}
