package dev.lpa;

import java.util.Arrays;

public class Person {

    private final String name;
    private final String dob;
    private final Person[] kids;

    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }


    public String getDob() {
        return dob;
    }


    public Person[] getKids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

//    public void setKids(Person[] kids) {
//        this.kids = kids;
//    }

    @Override
    public String toString() {

        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + dob + ", kids = " + kidString;
    }
}
