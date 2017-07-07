import java.util.Comparator;

/*
Used to order lists of Ticket objects by their price in ascending order.
 */

public class TicketComparator implements Comparator<Ticket>{
    @Override
    public int compare(Ticket t1, Ticket t2) {

        return Double.compare(t1.getPrice(), t2.getPrice());
    }
}
