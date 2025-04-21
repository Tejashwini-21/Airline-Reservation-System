package miniproject;
import java.util.*;

class AirlineSystem {
	
	    static List<User> users = new ArrayList<>();
	    static List<Flight> flights = new ArrayList<>();
	    static List<Booking> bookings = new ArrayList<>();
	    static Scanner scanner = new Scanner(System.in);
	    static User currentUser = null;

	    public static void main(String[] args) {
	        seedFlights();
	        int choice;

	        do {
	            System.out.println("\n===== Airline Reservation System =====");
	            if (currentUser == null) {
	                System.out.println("1. Register");
	                System.out.println("2. Login");
	                System.out.println("0. Exit");
	                System.out.println("enter your choice");
	                choice = scanner.nextInt();
	                scanner.nextLine(); // consume newline

	                switch (choice) {
	                    case 1 -> register();
	                    case 2 -> login();
	                }
	            } else {
	                System.out.println("1. View Flights");
	                System.out.println("2. Book Flight");
	                System.out.println("3. View My Bookings");
	                System.out.println("4. Cancel Booking");
	                System.out.println("5. Logout");
	                System.out.println("0. Exit");
	                choice = scanner.nextInt();
	                scanner.nextLine();

	                switch (choice) {
	                    case 1 -> viewFlights();
	                    case 2 -> bookFlight();
	                    case 3 -> viewBookings();
	                    case 4 -> cancelBooking();
	                    case 5 -> currentUser = null;
	                }
	            }
	        } while (choice != 0);
	        System.out.println("Thank you for using the system!");
	    }

	    private static void seedFlights() {
	        flights.add(new Flight(101, "Bangalore", "Delhi", 50, 4500));
	        flights.add(new Flight(102, "Mumbai", "Chennai", 40, 4200));
	        flights.add(new Flight(103, "Kolkata", "Hyderabad", 60, 4000));
	    }

	    private static void register() {
	        System.out.print("Enter name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter email: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();

	        users.add(new User(name, email, password));
	        System.out.println("Registration successful. Please login.");
	    }

	    private static void login() {
	        System.out.print("Enter email: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();

	        for (User u : users) {
	            if (u.getEmail().equals(email) && u.checkPassword(password)) {
	                currentUser = u;
	                System.out.println("Welcome, " + u.getName());
	                return;
	            }
	        }
	        System.out.println("Invalid credentials.");
	    }

	    private static void viewFlights() {
	        System.out.println("Available Flights:");
	        for (Flight f : flights) {
	            f.displayInfo();
	        }
	    }

	    private static void bookFlight() {
	        viewFlights();
	        System.out.print("Enter Flight ID to book: ");
	        int id = scanner.nextInt();
	        System.out.print("Enter number of tickets: ");
	        int tickets = scanner.nextInt();

	        for (Flight f : flights) {
	            if (f.getFlightId() == id) {
	                if (f.getSeatsAvailable() >= tickets) {
	                    f.bookSeats(tickets);
	                    bookings.add(new Booking(currentUser, f, tickets));
	                    System.out.println("Booking successful!");
	                } else {
	                    System.out.println("Not enough seats available.");
	                }
	                return;
	            }
	        }
	        System.out.println("Invalid flight ID.");
	    }

	    private static void viewBookings() {
	        System.out.println("Your Bookings:");
	        for (Booking b : bookings) {
	            if (b.getUser().equals(currentUser)) {
	                b.displayBooking();
	            }
	        }
	    }

	    private static void cancelBooking() {
	        viewBookings();
	        System.out.print("Enter Flight ID to cancel booking: ");
	        int id = scanner.nextInt();

	        for (int i = 0; i < bookings.size(); i++) {
	            Booking b = bookings.get(i);
	            if (b.getUser().equals(currentUser) && b.getFlight().getFlightId() == id) {
	                b.getFlight().cancelSeats(b.getNumTickets());
	                bookings.remove(i);
	                System.out.println("Booking cancelled.");
	                return;
	            }
	        }
	        System.out.println("Booking not found.");
	    }
	}

