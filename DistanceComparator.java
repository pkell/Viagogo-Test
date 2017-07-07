import java.util.Comparator;

/*
Used to order lists of Event objects by their distance to the user's location
 */

public class DistanceComparator implements Comparator<Event>{
    Location l;

    public DistanceComparator(Location l) {
        this.l = l;
    }

    private Integer distance(Event e){
        return Utilities.manhattanDistance(e.getLocation().getX(),
                l.getX(), e.getLocation().getY(), l.getY());
    }

    @Override
    public int compare(Event e1, Event e2) {
        return distance(e1).compareTo(distance(e2));
    }
}
