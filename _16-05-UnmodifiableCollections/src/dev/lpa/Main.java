package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));

        students.forEach(System.out::println);
        System.out.println("-----------------------------");

    }
}

