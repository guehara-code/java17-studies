package dev.lpa;

import dev.lpa.student.Course;
import dev.lpa.student.Student;
import dev.lpa.student.StudentDemographics;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String header = """
                
                Student Id,Country Code,Enrolled Year,Age,Gender,\
                Experienced,Course Code,Engagement Month,Engagement Year,\
                Engagement Type""";

        Course jmc = new Course("JMC", "Java MasterClass");
        Course pymc = new Course("PYC", "Python MasterClass");
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5)
                .toList();

        System.out.println(header);
        students.forEach(s -> s.getEngagementRecords().forEach(System.out::println));
    }
}
