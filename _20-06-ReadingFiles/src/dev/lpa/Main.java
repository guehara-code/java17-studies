package dev.lpa;

import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("file.txt")) {

            int data;
            while ((data = reader.read()) != -1) {
                System.out.println((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
