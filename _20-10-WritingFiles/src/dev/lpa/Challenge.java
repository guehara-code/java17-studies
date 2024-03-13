package dev.lpa;

import dev.lpa.student.Course;
import dev.lpa.student.Student;

import java.util.List;
import java.util.stream.Stream;

public class Challenge {

    public static void main(String[] args) {

        Course jmc = new Course("JMC", "Java MasterClass");
        Course pymc = new Course("PYC", "Python MasterClass");
        List<String> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(2)
                .map(Student::toJSON)
                .toList();
        students.forEach(System.out::println);
    }
}
