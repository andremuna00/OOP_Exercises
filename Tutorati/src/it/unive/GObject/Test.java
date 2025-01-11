package it.unive.GObject;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        Date oggi = new Date(9, 11, 2020);
        System.out.println(oggi);

        // Copia dei puntatori: sempre verificato
        Date oggi2 = oggi;
        if (oggi.equals(oggi2)) {
            System.out.println("oggi == oggi2");
        }

        // Due new diverse:
        // Qui entra in gioco il nostro metodo equals modificato
        Date oggiCopia = new Date(9, 11, 2020);
        if (oggi.equals(oggiCopia)) {
            System.out.println("oggi == oggiCopia");
        }

        // Vediamo come DynamicSet usa equals() per togliere i duplicati
        DynamicSet mySet = new DynamicSet();
        mySet.add(new Date(9, 11, 2020));
        mySet.add(new Date(10, 11, 2020));
        mySet.add(new Date(10, 11, 2020));
        mySet.add(new Date(10, 11, 2020));
        mySet.add(new Date(11, 11, 2020));
        mySet.add(new Date(12, 11, 2020));
        mySet.add(new Date(12, 11, 2020));

        for (int i = 0; i < mySet.getCount(); i++) {
            System.out.println(mySet.get(i).toString());
            System.out.println(mySet.get(i).hashCode());
        }

        // La classe standard di Java HashSet fa lo stesso,
        // utilizzando però il metodo hashCode() per essere più efficiente
        HashSet hashSet = new HashSet();
        hashSet.add(new Date(9, 11, 2020));
        hashSet.add(new Date(10, 11, 2020));
        hashSet.add(new Date(10, 11, 2020));
        hashSet.add(new Date(10, 11, 2020));
        hashSet.add(new Date(11, 11, 2020));
        hashSet.add(new Date(12, 11, 2020));
        hashSet.add(new Date(12, 11, 2020));

        for (Object x : hashSet) {
            System.out.println(x.toString());
        }
    }
}
