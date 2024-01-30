import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

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

        addPurchase("Chuck Cheese", python, 119.99);
        addPurchase("Davey Jones", jmc, 139.99);
        addPurchase("Eva East", python, 139.99);
        addPurchase("Fred Forker", jmc, 139.99);
        addPurchase("Greg Brady", python, 139.99);

        purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("---------------------------");
        students.forEach((key, value) -> System.out.println(key + ": " + value));

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();

        for (Purchase p : purchases.values()) {
            datedPurchases.compute(p.purchaseDate(),
                    (pdate, plist) -> {
                        List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                        list.add(p);
                        return list;
                    });
        }

        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));

        int currentYear = LocalDate.now().getYear();

        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);
        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1);
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1);

        System.out.println("------------------------");
        week1Purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("------------------------");
        week2Purchases.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void addPurchase(String name, Course course, double price) {

        Student existStudent = students.get(name);
        if (existStudent == null) {
            existStudent = new Student(name, course);
            students.put(name, existStudent);
        } else {
            existStudent.addCourse(course);
        }

        int day = new Random().nextInt(1, 15);
        String key = course.courseId() + "-" + existStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(),
                existStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }
}