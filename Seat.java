public class Seat {
    private int row;
    private int column;
    private boolean bookingStatus = false;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public boolean getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    public String toString( Seat seat ){
        String stringRepresentation = seat.getRow() + " x " + seat.getColumn();
        return stringRepresentation;
    }
    
    public boolean equals( Seat seat ){
        if ( ( seat.getRow() == this.getRow() ) && (seat.getColumn() == this.getColumn())) {
            return true;
        }
        return false;
    }
}
