import java.util.Scanner;

public class Airport {

    static class Passenger {
        String hasRG;
        String birthDateRG;
        String hasTicket;
        String birthDateTicket;
        String seat;
    }

    public static void check(int numPassengers) {
        Passenger[] passengers = new Passenger[numPassengers];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < numPassengers; ++i) {
                passengers[i] = new Passenger();

                System.out.print("Do you have an RG? Type 'RG' if yes or 'No RG' if not: ");
                passengers[i].hasRG = scanner.next();

                if ("No RG".equals(passengers[i].hasRG)) {
                    System.out.println("Head towards the exit.");
                    continue;
                }

                System.out.print("Enter the birth date on the RG (format DD/MM/YYYY): ");
                passengers[i].birthDateRG = scanner.next();

                System.out.print("Do you have a ticket? Type 'Ticket' if yes or 'No Ticket' if not: ");
                passengers[i].hasTicket = scanner.next();

                if ("No Ticket".equals(passengers[i].hasTicket)) {
                    System.out.println("Head to the reception.");
                    continue;
                }

                System.out.print("Enter the birth date on the ticket (format DD/MM/YYYY): ");
                passengers[i].birthDateTicket = scanner.next();

                if (!passengers[i].birthDateRG.equals(passengers[i].birthDateTicket)) {
                    System.out.println("190");
                    continue;
                }

                System.out.print("Enter the seat number (format A12): ");
                passengers[i].seat = scanner.next();
                System.out.println("Your seat is " + passengers[i].seat + ", have an excellent trip!");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of passengers: ");
            int numPassengers = scanner.nextInt();

            check(numPassengers);
        }
    }
}
