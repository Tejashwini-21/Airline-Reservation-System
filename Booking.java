package miniproject;

class Booking {

	    private User user;
	    private Flight flight;
	    private int numTickets;

	    public Booking(User user, Flight flight, int numTickets) {
	        this.user = user;
	        this.flight = flight;
	        this.numTickets = numTickets;
	    }

	    public User getUser() {
	        return user;
	    }

	    public Flight getFlight() {
	        return flight;
	    }

	    public int getNumTickets() {
	        return numTickets;
	    }

	    public void displayBooking() {
	        System.out.println("Booking: " + user.getName() + " booked " + numTickets + 
	            " ticket(s) on flight " + flight.getFlightId() + " from " + 
	            flight.getSource() + " to " + flight.getDestination());
	    }
	}
