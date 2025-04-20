package AirlineReservationSystem;

import java.util.*;

public class ReservationManager {
    private List<Reservation> reservationList = new ArrayList<>();
    private Flight flight;

    public ReservationManager(Flight flight) {
        this.flight = flight;
    }

    public void bookTicket(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        Passenger passenger = new Passenger(name, age, gender);
        ReservationThread thread = new ReservationThread(flight, passenger, reservationList);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted.");
        }
    }

    public void viewAllReservations() {
        if (reservationList.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : reservationList) {
                System.out.println(r);
            }
        }
    }

    public void updateReservation(Scanner scanner) {
        System.out.print("Enter Ticket ID to update: ");
        int id = scanner.nextInt(); scanner.nextLine();
        for (Reservation r : reservationList) {
            if (r.getTicketId() == id) {
                System.out.print("New Name: ");
                String name = scanner.nextLine();
                System.out.print("New Age: ");
                int age = scanner.nextInt(); scanner.nextLine();
                System.out.print("New Gender: ");
                String gender = scanner.nextLine();

                r.setPassenger(new Passenger(name, age, gender));
                System.out.println("Reservation updated!");
                return;
            }
        }
        System.out.println("Ticket ID not found.");
    }

    public void cancelReservation(Scanner scanner) {
        System.out.print("Enter Ticket ID to cancel: ");
        int id = scanner.nextInt(); scanner.nextLine();
        Iterator<Reservation> it = reservationList.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getTicketId() == id) {
                it.remove();
                flight.cancelSeat();
                System.out.println("Reservation cancelled.");
                return;
            }
        }
        System.out.println("Ticket ID not found.");
    }
}
