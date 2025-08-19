import java.util.ArrayList;

public class Screening {
    private Movie movie;
    private Auditorium auditorium;
    private double startTime;
    private ArrayList<Ticket> soldTickets = new ArrayList<Ticket>();
    private Seat[][] seats;

    public Screening(Movie movie, Auditorium auditorium, double startTime) {
        this.movie = movie;
        this.auditorium = auditorium;
        this.startTime = startTime;
        this.seats = new Seat[auditorium.getNumberOfRows()][auditorium.getNumberofColumns()];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }
    public Movie getMovie() {
        return movie;
    }
    public Auditorium getAuditorium() {
        return auditorium;
    }
    public double getStartTime() {
        return startTime;
    }
    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }
    public Seat[][] getSeats() {
        return seats;
    }
    public double getEndTime(){
        return startTime + movie.getDuration();
    }
    public double getPrice(){
        return movie.getBaseTicketPrice() * auditorium.getPriceMultiplier();
    }
    public double calculateRevenue(){
        double revenue = 0;
        for ( Ticket ticket : soldTickets){
            revenue += ticket.getTotalPrice();
        }
        return revenue;
    }
    public Seat getSeat( int row , int column){
        row--; column--;
        if ( seats.length < row && seats[0].length < column){
            Seat seat = new Seat(row, column);
            return seat;
        }
        return null;
    }
    public boolean isSeatAvailable(int row , int column){
        if( !seats[row][column].getBookingStatus()){
            return true;
        }
        return false;
    }
    public Ticket buyTicket( Seat seat ){
        if ( !seat.getBookingStatus() ){
            ArrayList<Seat> bookedSeats = new ArrayList<Seat>();
            bookedSeats.add(seat);
            Ticket ticket = new Ticket(this, bookedSeats , getPrice());
            soldTickets.add(ticket);
            seat.setBookingStatus(true);
            return ticket;
        }
        return null;
    }
    public Ticket buyTicketForRange(int row, int startColumn, int endColumn){
        row--;
        startColumn--;
        endColumn--;
        ArrayList<Seat> bookedSeats = new ArrayList<Seat>();
        for ( int i = startColumn; i <= endColumn; i++){
            if (i < 0 || i >= seats[0].length || row < 0 || row >= seats.length || seats[row][i].getBookingStatus()) {
                return null;
            }
            seats[row][i].setBookingStatus(true);
            bookedSeats.add(seats[row][i]);
        }
        
        Ticket ticket = new Ticket(this , bookedSeats, getPrice() * bookedSeats.size() );
        soldTickets.add(ticket);
        return ticket; 
    }
    public void getSeatingLayout(){
        System.out.print(" ");
        for (int i = 1; i < seats.length; i++){
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++){
            System.out.print(i + 1);
            for (int j = 0; j < seats[0].length; j++){
                if (!seats[i][j].getBookingStatus()){
                    System.out.print("_");
                }
                else{
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
    public String toString( Screening screening ){
        String stringRepresentation = "'" + screening.getMovie().getMovieTitle() + "'" + " is playing in the " + screening.getAuditorium().getName() + " auditorium from " + startTime + " to " + screening.getEndTime();
        return stringRepresentation;
    }
    public boolean equals( Screening screening ){
        if ( ( screening.getMovie().equals( this.getMovie() ) ) && (screening.getAuditorium().equals( this.getAuditorium() )) && ( startTime == this.getStartTime() )) {
            return true;
        }
        return false;
    }





}
