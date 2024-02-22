package dev.lpa;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python MasterClass", 50);
        Course jmc = new Course("JMC", "Java MasterClass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        List<Student> students = IntStream
                .rangeClosed( 1, 5000)
                .mapToObj( s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);

        double avePercent = totalPercent / students.size();
        System.out.printf("Average Percentage Complete = %.2f%% %n", avePercent);

        int topPercent = (int) (1.25 * avePercent);
        System.out.printf("Best Percetage Complete = %d%% %n", topPercent);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .toList();

        System.out.println("hardWorkers = " + hardWorkers.size());
    }
}
