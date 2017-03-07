import java.awt.*;

public abstract class LivingThing implements Entity {

    protected Point position;
    protected Pasture pasture;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

}
