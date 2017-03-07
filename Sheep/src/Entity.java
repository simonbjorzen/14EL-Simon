import javax.swing.*;
import java.awt.*;

public interface Entity {

    public Point getPosition();

    public void setPosition(Point newPosition);

    public void tick();

    public ImageIcon getImage();

    public String type();

}
