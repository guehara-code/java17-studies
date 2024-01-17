public class BookingAgent {

    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;
        Theatre rodgerNYC = new Theatre("Richard Rodgers", rows, totalSeats);

        rodgerNYC.printSeatMap();
    }
}
