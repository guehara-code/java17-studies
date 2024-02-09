package dev.lpa;


import java.util.Arrays;

record Person (String name, String dob) {}

public class Main {

    public static void main(String[] args) {

        Person joe = new Person("Joe", "01/01/1961");
        Person jim = new Person("Jim", "02/02/1961");
        Person jack = new Person("Jack", "03/03/1961");
        Person jane = new Person("Jane", "04/04/1961");
        Person jill = new Person("Jill", "05/05/1961");

        Person[] persons = {joe, jim, jack, jane, jill};
        Person[] personCopy = Arrays.copyOf(persons, persons.length);

        for (int i = 0; i < 5; i++) {
            if (persons[i] == personCopy[i]) {
                System.out.println("Equal References " + persons[i]);
            }
        }
    }
}
