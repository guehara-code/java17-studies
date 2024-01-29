import java.awt.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();
    public static void main(String[] args) {

        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);

        purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("---------------------------");
        students.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    private static void addPurchase(String name, Course course, double price) {

        Student existStudent = students.get(name);
        if (existStudent == null) {
            existStudent = new Student(name, course);
            students.put(name, existStudent);
        } else {
            existStudent.addCourse(course);
        }

        int day = purchases.size() + 1;
        String key = course.courseId() + "-" + existStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(),
                existStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }
}
