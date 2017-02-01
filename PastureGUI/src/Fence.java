import javax.swing.*;

public class Fence extends Entity {

    /**
     * Creates a new instance of this class, with the given pasture as
     * its pasture.
     * @param pasture the pasture this entity should belong to.
     */
    public Fence(Pasture pasture) {
        super(pasture);

        this.image = new ImageIcon("bin/fence.gif");
    }

}

