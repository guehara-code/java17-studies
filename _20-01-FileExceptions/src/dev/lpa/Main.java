package dev.lpa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String filename = "testing.csv";
        Path path = Paths.get(filename);
//        try {
//            List<String> lines = Files.readAllLines(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("I can't run unless this file exists");
            System.out.println("Quitting Application, go figure it out");
        }
        System.out.println("I'm good to go.");


    }
}
