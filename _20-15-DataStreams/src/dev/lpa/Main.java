package dev.lpa;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path dataFile = Path.of("data.dat");
        writeData(dataFile);
    }

    private static void writeData(Path dataFile) {

        try (DataOutputStream dataStream =
                new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(dataFile.toFile())))) {

            int myInt = 17;
            long myLong = 100_000_000_000_000L;
            boolean myBoolean = true;
            char myChar = 'z';
            float myFloat = 77.7f;
            double myDouble = 98.6;
            String myString = "Hello World";

            long position = 0;
            dataStream.writeInt(myInt);
            System.out.println("writeInt writes " + (dataStream.size() - position));
            position = dataStream.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
