package AirlineReservationSystem;

public class Flight {
    private String flightNumber, source, destination;
    private int totalSeats, reservedSeats = 0;

    public Flight(String flightNumber, String source, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
    }

    public synchronized boolean reserveSeat() {
        if (reservedSeats < totalSeats) {
            reservedSeats++;
            return true;
        }
        return false;
    }

    public synchronized void cancelSeat() {
        if (reservedSeats > 0) reservedSeats--;
    }

    public void displayFlightDetails() {
        System.out.println("\nFlight: " + flightNumber + " | " + source + " -> " + destination);
        System.out.println("Available Seats: " + (totalSeats - reservedSeats));
    }

    public static void airlinePolicy() {
        System.out.println("⚠️ All tickets are non-refundable after 24 hours.");
    }
}
