import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wolf extends Animal implements Feeder {
    static final int wolfMoveInterval = 5;
    static final int wolfViewDistance = 3;
    int lastY, lastX;
    public Wolf(Pasture pasture) {
        super( pasture, wolfMoveInterval, wolfViewDistance );
        lastX = 1;
        lastY = 1;
        this.image = new ImageIcon(getClass().getClassLoader().getResource("bin/wolf.gif"));
    }

    @Override
    public boolean isCompatible(Entity otherEntity) {
        if( otherEntity instanceof Plant )      {
            return true;
        }
        return false;
    }

    public void doFeed( Entity otherEntity ) {
        if( otherEntity instanceof Sheep ) {

            System.out.println( this + " eats " + otherEntity + " at " + pasture.getPosition( this ) );
            otherEntity.kill();
       }
    }

    private static <X> X getRandomMember(List<X> c) {
        if (c.size() == 0)
            return null;

        int n = (int)(Math.random() * c.size());

        return c.get(n);
    }



    @Override
    public void doMove() {

        if( this.moveDelay-- <= 0 ) {
            List<Entity> seen = pasture.getEntitiesWithinDistance( pasture.getPosition(this), this.viewDistance );
            Map<Point, Double> scoredNeighbours = new HashMap<Point, Double>();
            Point here = pasture.getPosition( this );

            for( Point neighbour : pasture.getAllNeighbours( here ) ) {
                Double score = 0.0;

                for( Entity e : seen ) {

                    Double distance = neighbour.distance( pasture.getPosition(e) );

                    if( e instanceof Sheep ) {
                        System.out.println( e + " spotted " + distance + " away from " + neighbour );
                        score += 100 / (1 + distance);
                    }

                }
                scoredNeighbours.put( neighbour, score );
            }
            Map.Entry<Point, Double> maxEntry = null;
            for (Map.Entry<Point, Double> entry : scoredNeighbours.entrySet() )
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }
            Point preferredNeighbour = maxEntry.getKey();
            if( pasture.getFreeNeighbours(this).contains(preferredNeighbour) == false ) {
                preferredNeighbour =
                        new Point(  (int)pasture.getPosition(this).getX() + lastX,
                                    (int)pasture.getPosition(this).getY() + lastY );
            }
            if( pasture.getFreeNeighbours(this).contains(preferredNeighbour) == false ) {
                preferredNeighbour =
                        getRandomMember(pasture.getFreeNeighbours(this));
            }
            lastX = (int)preferredNeighbour.getX() - (int)pasture.getPosition(this).getX();
            lastY = (int)preferredNeighbour.getY() - (int)pasture.getPosition(this).getY();
            pasture.moveEntity( this, preferredNeighbour );
            this.moveDelay = this.moveInterval;
        }
    }



}
