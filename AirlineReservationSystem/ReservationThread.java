package AirlineReservationSystem;

import java.util.List;

public class ReservationThread extends Thread {
    private Flight flight;
    private Passenger passenger;
    private List<Reservation> reservationList;

    public ReservationThread(Flight flight, Passenger passenger, List<Reservation> reservationList) {
        this.flight = flight;
        this.passenger = passenger;
        this.reservationList = reservationList;
    }

    @Override
    public void run() {
        if (flight.reserveSeat()) {
            Reservation r = new Reservation(passenger);
            reservationList.add(r);
            System.out.println("✔ Booking confirmed! Ticket ID: " + r.getTicketId());
        } else {
            System.out.println("❌ No seats available. Booking failed.");
        }
    }
}
