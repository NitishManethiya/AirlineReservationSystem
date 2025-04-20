package AirlineReservationSystem;

import java.util.*;

public class AirlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flight flight = new Flight("AI101", "Delhi", "Mumbai", 5);
        ReservationManager manager = new ReservationManager(flight);

        while (true) {
            System.out.println("\n===== Airline Reservation System =====");
            System.out.println("1. Book a Ticket");
            System.out.println("2. View All Reservations");
            System.out.println("3. Update Reservation");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View Flight Info");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manager.bookTicket(scanner);
                case 2 -> manager.viewAllReservations();
                case 3 -> manager.updateReservation(scanner);
                case 4 -> manager.cancelReservation(scanner);
                case 5 -> flight.displayFlightDetails();
                case 6 -> {
                    System.out.println("Thank you for using our service.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
