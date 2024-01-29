import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();
    public static void main(String[] args) {


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
