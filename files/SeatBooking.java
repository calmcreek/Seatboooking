//package controller; not using a new package,default 

//import Seat; not required as both in same default package
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        // TODO 1 : this.bookedSeatsList = ?
        this.bookedSeatsList = new ArrayList<>();

    }

    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // TODO 2: Check if the seat is already booked and not canceled
        for (Seat seat : bookedSeatsList) {
            if (seat.getSeatNumber().equals(seatNumber) && seat.isBooked() && !seat.isCanceled()) {
                System.out.println("Seat " + seatNumber + " is already booked!");
                return;
            }
        }

        // TODO 3: Create a new Seat object for the booking
        Seat newSeat = new Seat(seatNumber);

        // Mark the seat as booked and set the booking date
        newSeat.setBooked(true);
        newSeat.setBookingDate(new Date());

        // TODO 4: Add the new seat to the bookedSeatsList
        bookedSeatsList.add(newSeat);

        // TODO 5: Confirm the booking to the user
        System.out.println("Seat " + seatNumber + " has been successfully booked on " + newSeat.getBookingDate());
    }

    // Method to get the list of all booked seats
    public List<Seat> getBookedSeatsList() {
        return bookedSeatsList;
    }
    // Method to cancel a booking
    public void cancelBooking(String seatNumber) {
        // TODO 6: Iterate through the list of booked seats
        for (Seat seat : bookedSeatsList) {
            // TODO 7: Check if the seat number matches and is not already canceled
            if (seat.getSeatNumber().equals(seatNumber) && seat.isBooked() && !seat.isCanceled()) {
                // Mark the seat as canceled and not booked
                seat.setCanceled(true);
                seat.setBooked(false);

                // Confirm the cancellation to the user
                System.out.println("Booking for seat " + seatNumber + " has been successfully canceled.");
                return;
            }
        }

        // TODO 8: Inform the user if no booking was found for the seat number
        System.out.println("No active booking found for seat " + seatNumber);
    }

    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        // TODO 9: Iterate through the list of booked seats
        for (Seat seat : bookedSeatsList) {
            // TODO 10: Check if the seat number matches the old seat number and is not canceled
            if (seat.getSeatNumber().equals(oldSeatNumber) && !seat.isCanceled()) {
                // TODO 11: Update the seat number to the new seat number
                seat.setSeatNumber(newSeatNumber);

                // Confirm the update to the user
                System.out.println("Booking updated from seat " + oldSeatNumber + " to " + newSeatNumber);
                return;
            }
        }

        // TODO 12: Inform the user if no booking was found for the old seat number
        System.out.println("No active booking found for seat " + oldSeatNumber);
    }

    // Method to display all bookings
    public void displayBookings() {
        // TODO 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        if (bookedSeatsList.isEmpty()) {
            System.out.println("No bookings have been made yet.");
            return;
        }

        // TODO 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
        boolean hasBookedSeats = false;
        for (Seat seat : bookedSeatsList) {
            //  Check if the seat is booked and not canceled
            if (seat.isBooked() && !seat.isCanceled()) {
                // TODO 15: display the seat number and booking date
                System.out.println("Seat Number: " + seat.getSeatNumber() +
                                   ", Booking Date: " + seat.getBookingDate());
                hasBookedSeats = true;
            }
        }
    
        // If no valid bookings were found, inform the user
        if (!hasBookedSeats) {
            System.out.println("No active bookings found.");
        }
    }
}
