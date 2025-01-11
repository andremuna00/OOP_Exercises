package it.unive.FInterfaces.University;

public class Course implements UniversityThing {
    String name;
    Prof professor;

    public Course(String name, Prof professor) {
        this.name = name;
        this.professor = professor;
    }

    public String getStringValue() {
        return String.format("%s (%s)", name, professor.getStringValue());
    }
}