
package dev.lpa;

public class Student {

    private final String name;
    private final StringBuilder studentNotes;

    public Student(String name, StringBuilder studentNotes) {
        this.name = name;
        this.studentNotes = studentNotes;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getStudentNotes() {
        return studentNotes;
    }

    @Override
    public String toString() {
        return "Main{" +
                "name='" + name + '\'' +
                ", studentNotes=" + studentNotes +
                '}';
    }
}
