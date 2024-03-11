package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File("file.txt"))) {
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//            System.out.println(scanner.delimiter());
//            scanner.useDelimiter("$");
//            scanner.tokens().forEach(System.out::println);
            scanner.findAll("[A-Za-z]{10,}")
                    .map(MatchResult::group)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
