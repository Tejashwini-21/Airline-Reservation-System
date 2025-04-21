package miniproject;

class Flight {

	    private int flightId;
	    private String source;
	    private String destination;
	    private int seatsAvailable;
	    private double fare;

	    public Flight(int flightId, String source, String destination, int seatsAvailable, double fare) {
	        this.flightId = flightId;
	        this.source = source;
	        this.destination = destination;
	        this.seatsAvailable = seatsAvailable;
	        this.fare = fare;
	    }

	    public int getFlightId() {
	        return flightId;
	    }

	    public String getSource() {
	        return source;
	    }

	    public String getDestination() {
	        return destination;
	    }

	    public int getSeatsAvailable() {
	        return seatsAvailable;
	    }

	    public double getFare() {
	        return fare;
	    }

	    public void bookSeats(int count) {
	        this.seatsAvailable -= count;
	    }

	    public void cancelSeats(int count) {
	        this.seatsAvailable += count;
	    }

	    public void displayInfo() {
	        System.out.println("Flight ID: " + flightId + ", From: " + source + ", To: " + destination + 
	            ", Seats: " + seatsAvailable + ", Fare: ₹" + fare);
	    }
	}
