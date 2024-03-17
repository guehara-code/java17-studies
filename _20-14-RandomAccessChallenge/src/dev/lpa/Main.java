package dev.lpa;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

record Employee(int employeeId, String firstName, String lastName, double salary) {

}

public class Main {

    private static final Map<Integer, Long> indexedIds = new HashMap<>();

    static {
        int recordsInFile = 0;
        try (RandomAccessFile ra = new RandomAccessFile("employees.dat", "r")) {
            recordsInFile = ra.readInt();
            System.out.println(recordsInFile + " records in file");
            for (int i = 0; i < recordsInFile; i++) {
                indexedIds.put(ra.readInt(), ra.readLong());
            }
        } catch (IOException e) {
            e. printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
