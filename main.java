//package mainop; not using a new package,default 

//import SeatBooking; not required as both in same default package
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class main {
    public static void main(String[] args) {
        // Take input using Scanner class
        Scanner keyboard = new Scanner(System.in);
        // Create an object of SeatBooking class
        SeatBooking bookingManager = new SeatBooking();

        while (true) {
            System.out.println("\n1. Add Booking\n2. Cancel Booking\n3. Update Booking\n4. Display Bookings\n5. Exit");
            System.out.print("Choose an option: ");
            // Choose an option
            int choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (choice) {
                case 1:
                    // TODO 16: add New Seats
                    // use a print statement to instruct the user to enter a seat number for booking.
                    System.out.print("Enter the seat number to book: ");

                    // take the seat number input from the user.
                    String seatNumberToBook = keyboard.nextLine();

                    // pass the seat number to the addNewBooking method to add the
                    bookingManager.addNewBooking(seatNumberToBook);

                    break;
                case 2:
                    // TODO 17: remove Booking
                    // print a message instructing the user to enter the seat number they wish to cancel.
                    System.out.print("Enter the seat number to cancel booking: ");

                    // take the seat number input from the user.
                    String seatNumberToCancel = keyboard.nextLine();

                    // call the cancelBooking method with the provided seat number to cancel the booking.
                    bookingManager.cancelBooking(seatNumberToCancel);

                    break;
                case 3:
                    // TODO 18: update booking
                    // prompt users to enter the old seat number they want to update.
                    System.out.print("Enter the old seat number: ");

                    // take the old seat number input from the user.
                    String oldSeatNumber = keyboard.nextLine();

                    // prompt the user to enter the new seat number.
                    System.out.print("Enter the new seat number: ");
                   
                    // take the new seat number input from the user.
                    String newSeatNumber = keyboard.nextLine();
                    
                    // call the updateBooking method with the old and new seat numbers to update the booking.
                    bookingManager.updateBooking(oldSeatNumber, newSeatNumber);


                    break;
                case 4:
                    /* display the all bookings does:
                     1.check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
                     2.iterate through the list of booked seats, Check if the seat is booked and not cancelled
                     3.display the seat number and booking date.   */
                    bookingManager.displayBookings();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    keyboard.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}


