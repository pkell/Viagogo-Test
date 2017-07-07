public class Ticket {

    private Event event;
    private double price;

    public Ticket(Event e, double price){
        this.event = e;
        this.price = price;
    }

    public Event getEvent(){
        return event;
    }

    public double getPrice(){
        return price;
    }
}
