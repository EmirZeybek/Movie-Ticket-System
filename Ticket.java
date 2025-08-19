import java.util.ArrayList;

public class Ticket {
    private Screening screening;
    private ArrayList<Seat> bookedSeats = new ArrayList<Seat>();
    private double totalPrice;
    
    public Ticket(Screening screening, ArrayList<Seat> bookedSeates, double totalPrice) {
        this.screening = screening;
        this.bookedSeats = bookedSeates;
        this.totalPrice = totalPrice;
    }

    public Screening getScreening() {
        return screening;
    }
        public ArrayList<Seat> getBookedSeates() {
        return bookedSeats;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public String toString( Ticket ticket ){
        String stringRepresentation = ticket.screening.getMovie().getMovieTitle() + " " + ticket.screening.getAuditorium().getName() + " " + ticket.screening.getStartTime() + " " + bookedSeats + " " + ticket.screening.getPrice();
        return stringRepresentation;
    }


}
