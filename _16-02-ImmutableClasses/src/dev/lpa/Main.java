package dev.lpa;

public class Main {

    public static void main(String[] args) {

        Person jane = new Person();
        jane.setName("Jane");
        Person jim = new Person();
        jim.setName("Jin");
        Person joe = new Person();
        joe.setName("Joe");
        Person john = new Person();
        john.setName("John");
        john.setDob("05/05/1900");
        john.setKids(new Person[]{jane, jim, john});
        System.out.println(john);

        john.setName("Jacob");
        john.setKids(new Person[]{new Person(), new Person()});
        System.out.println(john);
    }
}


