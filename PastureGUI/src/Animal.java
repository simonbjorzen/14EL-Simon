import java.awt.*;

public abstract class Animal extends Entity implements Move {

    protected int moveInterval;
    protected int moveDelay;
    protected int viewDistance;

    public Animal(Pasture pasture, int moveInterval, int viewDistance ) {
        super(pasture);

        this.moveInterval = moveInterval;
        this.moveDelay = this.moveInterval;

        this.viewDistance = viewDistance;
    }

    private static <X> X getRandomMember(java.util.List<X> c) {
        if (c.size() == 0)
            return null;

        int n = (int)(Math.random() * c.size());

        return c.get(n);
    }

    public void doMove() {

        if( this.moveDelay-- <= 0 ) {
            Point neighbour =
                    getRandomMember(pasture.getFreeNeighbours(this));

            if(neighbour != null)
                pasture.moveEntity(this, neighbour);

            this.moveDelay = this.moveInterval;
        }
    }
}
