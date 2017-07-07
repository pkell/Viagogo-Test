import java.util.ArrayList;
import java.util.List;

public class Event {

    private int id;
    private List<Ticket> tickets;
    private Location location;


    public Event(int identifier, Location location){
        this.tickets = new ArrayList<Ticket>();
        this.id = identifier;
        this.location = location;
    }

    public int getId(){
        return id;
    }

    public Location getLocation(){
        return location;
    }

    public List<Ticket> getTickets(){
        return tickets;
    }

    public void addTicket(Ticket t){
        tickets.add(t);
    }

    public void removeTicket(Ticket t){
        tickets.remove(t);
    }
}
