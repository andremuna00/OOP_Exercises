package it.unive.FInterfaces.University;

public class Prof implements UniversityThing, WithSurname {
    String name;
    String surname;

    public Prof(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getStringValue() {
        return String.format("Prof. %s %s", name, surname);
    }

    public String getSurname() {
        return surname;
    }
}
