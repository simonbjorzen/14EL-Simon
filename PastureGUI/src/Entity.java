import javax.swing.*;

public abstract class Entity {

    private boolean alive;
    protected ImageIcon image;
    protected final Pasture pasture;

    public Entity(Pasture pasture) {
        this.pasture = pasture;

        this.image = new ImageIcon(getClass().getClassLoader().getResource("bin/empty.gif"));

        this.alive = true;
    }

    public void tick()  {

        // implements Move?
        if( this instanceof Move) {
            ((Move)this).doMove();
        }

        // implements Breeder?
        if( this instanceof Breeder) {
            ((Breeder)this).doBreed();
        }

        // implements Feeder?
        if( this instanceof Feeder ) {
            // do for all entities in this location
            for( Entity cohabitant : pasture.getEntitiesAt(pasture.getPosition(this)) ) {
                ((Feeder)this).doFeed(cohabitant);
            }
        }

    }

    // returns true iff the this.alive is true
    public boolean isAlive() {
        return this.alive;
    }

    // set this.alive to false
    public void kill() {
        this.alive = false;
    }

    /**
     * Returns the icon of this entity, to be displayed by the pasture
     * gui.
     * @see PastureGUI
     */
    public ImageIcon getImage() { return this.image; }

    /**
     * Tests if this entity can be on the same position in the pasture
     * as the given one.
     */
    public boolean isCompatible(Entity otherEntity) { return false; }

}
