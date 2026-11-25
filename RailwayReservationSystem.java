import java.util.InputMismatchException;
import java.util.Scanner;

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}
class Reservation {
    private final boolean[] seats;
    private final int totalSeats;

    public Reservation(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }

    public void reserveSeat(int seatNumber) throws SeatAlreadyBookedException {

        if (seatNumber < 1 || seatNumber > totalSeats) {
            throw new IllegalArgumentException(
                "Invalid seat number: " + seatNumber + ". Please choose between 1 and " + totalSeats + "."
            );
        }

        int index = seatNumber - 1;

        if (seats[index]) {
            throw new SeatAlreadyBookedException(
                "Seat " + seatNumber + " is already booked. Please select another seat."
            );
        }

        seats[index] = true;
        System.out.println("Success! Seat " + seatNumber + " has been reserved.");
    }

    public void displaySeatStatus() {
        System.out.print("Current Seat Map: ");
        for (int i = 0; i < totalSeats; i++) {
            System.out.print("[" + (i + 1) + ":" + (seats[i] ? "Booked" : "Open") + "] ");
        }
        System.out.println();
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Reservation trainReservation = new Reservation(5);
        boolean keepRunning = true;

        System.out.println("=== Railway Reservation Management System ===");

        while (keepRunning) {
            System.out.println();
            trainReservation.displaySeatStatus();
            System.out.print("Enter seat number to reserve (1-5) or 0 to exit: ");

            boolean transactionSuccess = false;

            try {
        
                int seatChoice = scanner.nextInt();

                if (seatChoice == 0) {
                    keepRunning = false;
                    System.out.println("Exiting system...");
                    continue;
                }

     
                trainReservation.reserveSeat(seatChoice);
                transactionSuccess = true;

            } 
          
            catch (InputMismatchException e) {
                System.out.println("Input Error: Invalid entry. Please enter a numeric seat number.");
                scanner.nextLine(); 
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
            } 
            catch (SeatAlreadyBookedException e) {
                System.out.println("Booking Error: " + e.getMessage());
            } 
            catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            } 
      
            finally {
                if (keepRunning) {
                    String status = transactionSuccess ? "COMPLETED SUCCESSFULLY" : "FAILED / ABORTED";
                    System.out.println("[Transaction Status: " + status + "]");
                }
            }
        }

        scanner.close();
    }
}
