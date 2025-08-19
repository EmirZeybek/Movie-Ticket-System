public class Auditorium {
    private String name;
    private int numberOfRows;
    private int numberofColumns;
    private double baseTicketPrice;
    private double priceMultiplier;

    public Auditorium(String name, int numberOfRows, int numberofColumns, double priceMultiplier) {
        this.name = name;
        this.numberOfRows = numberOfRows;
        this.numberofColumns = numberofColumns;
        this.priceMultiplier = priceMultiplier;
    }

    public String getName() {
        return name;
    }
    public int getNumberOfRows() {
        return numberOfRows;
    }
    public int getNumberofColumns() {
        return numberofColumns;
    }
    public int getCapacity(){
        return numberOfRows * numberofColumns;
    }
    public double getBaseTicketPrice() {
        return baseTicketPrice;
    }
    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public String toString( Auditorium auditorium ){
        String stringRepresentation = auditorium.getName() + ", " + (auditorium.getNumberOfRows() * auditorium.getNumberofColumns()) + " seats";
        return stringRepresentation;
    }
    public boolean equals( Auditorium auditorium ){
        if ( auditorium.getName().equals( this.getName() )){
            return true;
        }
        return false;
    }

}
