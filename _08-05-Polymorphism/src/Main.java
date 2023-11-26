public class Main {
    public static void main(String[] args) {

//        Movie theMovie = new Adventure("Star Wars");
        Movie theMovie = Movie.getMovie("" +
                "Science", "Star Wars");
        theMovie.watchMovie();

    }
}
