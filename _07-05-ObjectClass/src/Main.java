public class Main extends Object {
    public static void main(String[] args) {

        Student max = new Student("Max", 21);
        System.out.println(max.toString());
    }
}

class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public String toString() {
//        return super.toString();
//    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
