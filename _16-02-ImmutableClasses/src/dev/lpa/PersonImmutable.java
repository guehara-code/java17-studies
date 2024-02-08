package dev.lpa;

import java.util.Arrays;

public record PersonImmutable(String name, String dob, PersonImmutable[] kids) {

    public PersonImmutable(String name, String dob) {
        this(name, dob, new PersonImmutable[20]);
    }

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

    @Override
    public PersonImmutable[] kids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }
}
