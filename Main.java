import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){

       List<Event> events = Utilities.generateSeedEvents(10);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter coordinates: ");
        String location = scanner.nextLine();

        String[] coordinates = location.split(",");
        Location user = new Location(Integer.parseInt(coordinates[0]),
                Integer.parseInt(coordinates[1]));
        for(Event e : events){
            Collections.sort(e.getTickets(), new TicketComparator());
        }
        Collections.sort(events, new DistanceComparator(user));

        System.out.println("Closest events to (" + user.getX() + "," + user.getY() + ")");
        for(int i = 0; i < 5; i++){
            int x1 = events.get(i).getLocation().getX();
            int y1 = events.get(i).getLocation().getY();
            int dist = Utilities.manhattanDistance(x1, user.getX(), y1, user.getY());
            if(events.get(i).getTickets().size() > 0){
                System.out.println("Event " + events.get(i).getId() + " - $" +
                        events.get(i).getTickets().get(0).getPrice() + ", Distance " + dist);
            }
            else{
                System.out.println("Event " + events.get(i).getId()
                        + " No Tickets, Distance " + dist);
            }
        }
    }
}
