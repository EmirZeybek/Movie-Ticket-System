public class Movie {
    private String movieTitle;
    private String movieGenre;
    private int duration;
    private double baseTicketPrice;
    
    public Movie( String title, String genre, int duration, double baseTicketPrice){
        movieTitle = title;
        movieGenre = genre;
        this.duration = duration;
        this.baseTicketPrice = baseTicketPrice;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public int getDuration() {
        return duration;
    }

    public double getBaseTicketPrice() {
        return baseTicketPrice;
    }

    public String toString( Movie movie ){
        String stringRepresentation = "\"" + movie.getMovieTitle() + "\", Genre: " + movie.getMovieGenre() + ", Duration: " + movie.getDuration() + " hours";
        return stringRepresentation;
    }

    public boolean equals( Movie movie ){
        if ( movie.getMovieTitle().equals( this.getMovieTitle() )){
            return true;
        }
        return false;
    }
    
}
