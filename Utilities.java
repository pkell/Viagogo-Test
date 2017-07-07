import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Static methods for generating the seed data and computing distance between points.
 */
public class Utilities {

    public static int manhattanDistance(int x1, int x2, int y1, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }

    public static List<Location> generateSeedLocations(int n){
        List<Location> locations = new ArrayList<Location>();
        Random r = new Random();
        for(int i = 0; i < n; i++){
            int x = r.nextInt((10 + 10) + 1) - 10;
            int y = r.nextInt((10 + 10) + 1) - 10;
            if(isLocationUnique(locations, x, y)){
                Location l = new Location(x, y);
                locations.add(l);
            }
            else{
                i--;
            }
        }
        return locations;
    }

    public static List<Event> generateSeedEvents(int n){
        List<Event> events = new ArrayList<Event>();
        List<Location> locations = generateSeedLocations(n);
        for(int i = 0; i < n; i++){
            Event e = new Event(i, locations.get(i));
            addTickets(e);
            events.add(e);
        }
        return events;
    }

    public static void addTickets(Event e){
        Random r = new Random();
        int n = r.nextInt((15) + 1);
        for(int i = 0; i < n; i++){
            double price = (1.0 - Math.random()) * 100;
            price = Math.floor(price * 100) / 100;
            Ticket t = new Ticket(e, price);
            e.addTicket(t);
        }
    }


    public static boolean isLocationUnique(List<Location> locations, int x, int y){
        for(Location l : locations){
            if(l.getX() == x && l.getY() == y){
                return false;
            }
        }
        return true;
    }
}
