package dev.lpa;

import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {


        System.out.println(ZoneId.systemDefault());

        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("Australia"))
                .sorted()
                .map(ZoneId::of)
                .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));
    }
}
