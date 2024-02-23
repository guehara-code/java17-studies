package dev.lpa;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainOptional {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass");
        Course jmc = new Course("JMC", "Java MasterClass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .collect(Collectors.toList());
    }

    private static Optional<Student> getStudent(List<Student> list, String type) {

        if (list == null || list.size() == 0) {
            return null;
        } else if (type.equals("first")) {
            return Optional.of(list.get(0));
        } else if (type.equals("last")) {
            return Optional.of(list.get(list.size() - 1));
        }
        return Optional.of(list.get(new Random().nextInt(list.size())));
    }
}
