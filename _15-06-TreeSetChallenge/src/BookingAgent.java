public class BookingAgent {

    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;
        Theatre rodgerNYC = new Theatre("Richard Rodgers", rows, totalSeats);

        rodgerNYC.printSeatMap();

        bookSeat(rodgerNYC, 'A', 3);
        bookSeat(rodgerNYC, 'A', 3);
        bookSeat(rodgerNYC, 'B', 1);
        bookSeat(rodgerNYC, 'B', 11);
        bookSeat(rodgerNYC, 'M', 1);
    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {

        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null) {
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }
}
