import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketSystem {
    public static void calculateRevenue( ArrayList<Screening> screenings ){
        double totalRevenue = 0;
        for ( Screening screening : screenings ){
            totalRevenue += screening.calculateRevenue();
        }
        System.out.printf("Total revenue for today: $%.2f\n ", totalRevenue );
    }
    public static void listMovies( ArrayList<Movie> movies ){
        System.out.println("Available Movies: ");
        for ( Movie movie : movies ){
            System.out.printf( " \"%s\", Genre: %s, Duration: %d hours\n", movie.getMovieTitle(), movie.getMovieGenre(), movie.getDuration());
        }
    }
    public static void listMoviesWithIndex( ArrayList<Movie> movies ){
        int i = 0;
        for ( Movie movie : movies ){
            i++;
            System.out.printf( i + ": " + "\"%s\", Genre: %s, Duration: %d hours\n", movie.getMovieTitle(), movie.getMovieGenre(), movie.getDuration());
        }
    }
    public static void listScreenings( ArrayList<Screening> screenings ){
        for ( Screening screening : screenings ){
            System.out.printf( " %s, is playing in the %s auditorium from %.2f to %.2f\n", screening.getMovie().getMovieTitle(), screening.getAuditorium().getName(), screening.getStartTime(), screening.getEndTime() );
        }
    }
    public static void listScreeningsWithIndex( ArrayList<Screening> screenings ){
        int i = 0;
        for ( Screening screening : screenings ){
            i++;
            System.out.printf( i + ": " + " %s, is playing in the %s auditorium from %.2f to %.2f\n", screening.getMovie().getMovieTitle(), screening.getAuditorium().getName(), screening.getStartTime(), screening.getEndTime() );
        }
    }
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        // Initial mock data
        // Add movies
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Toyz Goin' Wild", "Family", 1, 1.23));
        movies.add(new Movie("Car's Life", "Family", 2, 1.00));
        movies.add(new Movie("The Amazing Bulk", "Action", 1, 2.10));
        movies.add(new Movie("The Rise of Black Bat", "Action", 2, 1.90));

        // Add auditoriums
        ArrayList<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(new Auditorium("Screen 1", 5, 4, 1.0));
        auditoriums.add(new Auditorium("Screen 2", 5, 4, 1.0));
        auditoriums.add(new Auditorium("IMAX", 3, 5, 1.5));

        // Add initial screenings
        ArrayList<Screening> screenings = new ArrayList<>();
        screenings.add(new Screening(movies.get(1), auditoriums.get(0), 1));
        screenings.add(new Screening(movies.get(2), auditoriums.get(0), 0));
        screenings.add(new Screening(movies.get(2), auditoriums.get(0), 4));
        screenings.add(new Screening(movies.get(0), auditoriums.get(1), 0));
        screenings.add(new Screening(movies.get(2), auditoriums.get(2), 4));
        screenings.add(new Screening(movies.get(3), auditoriums.get(2), 6));

        // Buy some tickets
        screenings.get(0).buyTicketForRange(2, 2, 4);
        screenings.get(1).buyTicketForRange(2, 1, 2);
        screenings.get(2).buyTicketForRange(1, 1, 4);
        screenings.get(2).buyTicketForRange(3, 2, 4);
        screenings.get(3).buyTicketForRange(5, 1, 3);
        screenings.get(3).buyTicketForRange(3, 3, 4);
        screenings.get(5).buyTicketForRange(3, 1, 5);        
        
        int option = 0;

        while ( option != 6 ){

            System.out.println("1. List Movies");
            System.out.println("2. List Screenings");
            System.out.println("3. Add Screening");
            System.out.println("4. Buy Ticket");
            System.out.println("5. Calculate Revenue");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");
            
            option = in.nextInt();

            if ( option == 1 ){
                MovieTicketSystem.listMovies(movies);
            }
            else if ( option == 2 ){
                MovieTicketSystem.listScreenings(screenings);
            }
            else if( option == 3 ){
                int option2 = -1;
                while (option2 < 0 || option2 > movies.size()) {
                    if (option2 != -1) {
                        System.out.println("Invalid selection. Please try again.");
                    }
                    System.out.println("Select a movie: ");
                    MovieTicketSystem.listMoviesWithIndex(movies);
                    System.out.print("Enter: ");
                    option2 = in.nextInt();
                }
                int option3 = -1;
                int auditoriumCount = 0;
                while (option3 < 0 || option3 >= auditoriumCount) {
                    if (option3 != -1) {
                        System.out.println("Invalid selection. Please try again.");
                    }
                    System.out.println("Select an auditorium: ");
                    auditoriumCount = 0;
                    for (int i = 0; i < auditoriums.size(); i++) {
                            System.out.println((auditoriumCount + 1) + ": " + auditoriums.get(i).toString(auditoriums.get(i)));
                            auditoriumCount++;
                    }
                    System.out.print("Enter: ");
                    option3 = in.nextInt() - 1; 
                }
                ArrayList<Integer> reservedHours = new ArrayList<Integer>();

                for (Screening screening : screenings) {
                    if ( screening.getAuditorium().equals(auditoriums.get(option3))){
                        System.out.println(screening.toString(screening));
                        reservedHours.add((int)screening.getStartTime());
                        if ( screening.getMovie().getDuration() > 1){
                            for (int i = 1; i < screening.getMovie().getDuration(); i++) {
                                    reservedHours.add((int)screening.getStartTime() + i);
                            }
                        }
                    }
                }
                System.out.print("Enter a start time: ");
                int startTime = in.nextInt();
                if( reservedHours.contains(startTime)){
                    System.out.println("The auditorium is not available at the given time.");
                }
                else{

                }
            }
            else if( option == 4 ){
                Screening selectedScreening = null;
                int option2 = -1;
                while (option2 < 0 || option2 > movies.size()) {
                    if (option2 != -1) {
                        System.out.println("Invalid selection. Please try again.");
                    }
                    System.out.println("Select a movie: ");
                    MovieTicketSystem.listMoviesWithIndex(movies);
                    System.out.print("Enter: ");
                    option2 = in.nextInt();
                }
                Movie selectedMovie = movies.get(option2 - 1);
                int option3 = -1;
                int screeningCount = 0;
                while (option3 < 0 || option3 >= screeningCount) {
                    if (option3 != -1) {
                        System.out.println("Invalid selection. Please try again.");
                    }
                    System.out.printf("Select a screening for '%s':\n", selectedMovie.getMovieTitle());
                    screeningCount = 0;
                    for (int i = 0; i < screenings.size(); i++) {
                        if (screenings.get(i).getMovie().equals(selectedMovie)) {
                            System.out.println((screeningCount + 1) + ": " + screenings.get(i).toString(screenings.get(i)));
                            screeningCount++;
                        }
                    }

                    System.out.print("Enter: ");
                    option3 = in.nextInt() - 1; 
                }
                int count = 0;
                for (int i = 0; i < screenings.size(); i++) {
                    if (screenings.get(i).getMovie().equals(selectedMovie)) {
                        if (count == option3) {
                            selectedScreening = screenings.get(i);
                            break;
                        }
                        count++;
                    }
                }

                System.out.printf("Seating layout for ");
                System.out.println(selectedScreening.toString( selectedScreening ));
                selectedScreening.getSeatingLayout();
                System.out.print("Select row: ");
                int selectedRow = in.nextInt() -1;
                System.out.print("Select column or range: ");
                int selectedColumn = 0;
                String selectedRange = null;
                Seat boughtSeat = new Seat(-1, -1);
                boolean success = true;
                if ( in.hasNextInt() ) {
                    selectedColumn = in.nextInt() - 1;
                    if( !selectedScreening.isSeatAvailable(selectedRow, selectedColumn)){
                        System.out.println("Ticket purchase failed: one or more selected seats are unavailable.\n");
                        success = false;
                    }
                    else{
                        boughtSeat = selectedScreening.getSeats()[selectedRow][selectedColumn];
                        selectedScreening.buyTicket( boughtSeat );
                    }            
                }
                else if( in.hasNext()){
                    selectedRange = in.next();
                    int start = Integer.parseInt(selectedRange.charAt(0) + "") - 1;
                    int end = Integer.parseInt(selectedRange.substring(2)) - 1;
                    for ( int i = start ; i <= end; i++){
                        if ( !selectedScreening.isSeatAvailable(selectedRow, i)){
                            System.out.println("Ticket purchase failed: one or more selected seats are unavailable.\n");
                            success = false;
                            break;
                        }
                    }
                    if ( success ){
                        selectedScreening.buyTicketForRange(selectedRow, start , end );
                    }
                }
                if ( success){
                    System.out.print("Ticket purchased: ");
                    System.out.println( selectedMovie.toString( selectedMovie ) );
                    System.out.println("Auditorium: " + selectedScreening.getAuditorium().getName() + ", " + selectedScreening.getAuditorium().getCapacity() + " seats");
                    System.out.printf("Start time: %.1f\n" , selectedScreening.getStartTime());
                    System.out.print("Seats: ");
                    Ticket lastTicket = selectedScreening.getSoldTickets().get(selectedScreening.getSoldTickets().size() - 1);
                    System.out.println( lastTicket.getBookedSeates().toString());
                    System.out.printf( "Total price: $%.2f\n" , lastTicket.getTotalPrice() );
                    System.out.printf("Seating layout for ");
                    System.out.println(selectedScreening.toString( selectedScreening ));
                    selectedScreening.getSeatingLayout();    
                }             
            }
            else if ( option == 5 ){
                MovieTicketSystem.calculateRevenue(screenings);                
            }
            else if ( option == 6 ){
                
            }
            else{
                System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
