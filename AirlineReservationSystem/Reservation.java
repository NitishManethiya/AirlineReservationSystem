package AirlineReservationSystem;

public class Reservation {
    private static int idCounter = 1000;
    private int ticketId;
    private Passenger passenger;

    public Reservation(Passenger passenger) {
        this.passenger = passenger;
        this.ticketId = ++idCounter;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger p) {
        this.passenger = p;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + " | " + passenger.toString();
    }
}

