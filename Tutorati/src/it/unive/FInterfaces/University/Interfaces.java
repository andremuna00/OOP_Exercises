package it.unive.FInterfaces.University;

import java.util.ArrayList;

public class Interfaces {
    public static void main(String[] args) {
        Prof pietro = new Prof("Pietro", "Ferrara");
        Course oop = new Course("Programmazione ad Oggetti", pietro);

        Prof marcello = new Prof("Marcello", "Pelillo");
        Course asd = new Course("Algoritmi e Strutture Dati", marcello);

        Student giulio = new Student("Giulio", "Zausa", 870040);
        giulio.addCourse(oop);
        giulio.addCourse(asd);

        ArrayList<UniversityThing> things = new ArrayList<UniversityThing>();
        things.add(pietro);
        things.add(marcello);
        things.add(oop);
        things.add(asd);
        things.add(giulio);

        for (UniversityThing t : things) {
            System.out.println(t.getStringValue());
        }
    }
}
