package dev.lpa;

public class Main {

    public static void main(String[] args) {

        String helloworld = "%s %s".formatted("Hello", "World");
        String helloworld2 = String.format("%s %s", "Hello", "World");
        System.out.println("Using string's formatted method: " + helloworld);
        System.out.println("Using String.format: " + helloworld2);

        String helloworld3 = Main.format("%s %s", "Hello", "World");
        System.out.println("Using Main.format: " + helloworld3);

    }

    private static String format(String regexp, String... args) {

        int index = 0;
        while (regexp.matches(".*%s.*")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }

        return regexp;
    }
}
