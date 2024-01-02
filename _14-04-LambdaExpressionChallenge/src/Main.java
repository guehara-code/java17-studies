import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));
        
    }
}
