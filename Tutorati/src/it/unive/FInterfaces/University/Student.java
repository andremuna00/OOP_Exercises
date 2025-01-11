package it.unive.FInterfaces.University;

import java.util.ArrayList;

public class Student implements UniversityThing, WithSurname {
    String name;
    String surname;
    int studentNumber;

    ArrayList<Course> following;

    public Student(String _name, String _surname, int _studentNumber) {
        name = _name;
        surname = _surname;
        studentNumber = _studentNumber;
        following = new ArrayList<Course>();
    }

    public void addCourse(Course c) {
        following.add(c);
    }

    public String getStringValue() {
        String courses = "";
        for (Course c : following) {
            courses += " - ";
            courses += c.getStringValue();
            courses += "\n";
        }

        return String.format("%s %s (%d)\n%s", name, surname, studentNumber, courses);
    }

    public String getSurname() {
        return surname;
    }
}