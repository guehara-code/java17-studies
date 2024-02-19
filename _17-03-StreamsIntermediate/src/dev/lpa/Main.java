package dev.lpa;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .forEach(d -> System.out.printf("%c", d));

    }
}
