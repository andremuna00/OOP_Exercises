package it.unive.DDynamicSet;

import it.unive.BDynamicArray.IntDynamicArray;

public class Main {
    // Funziona anche con IntDynamicSet, dal momento che è figlio di IntDynamicArray
    private static void printArray(IntDynamicArray arr) {
        for (int i = 0; i < arr.getCount(); i++) {
            System.out.print(arr.get(i) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        IntDynamicArray arr = new IntDynamicArray();
        for (int i = 0; i < 20; i++) {
            // Aggiungiamo due volte i
            // 0, 0, 1, 1, 2, 2, ...
            arr.add(i);
            arr.add(i);
        }
        printArray(arr);

        IntDynamicSet set = new IntDynamicSet();
        for (int i = 0; i < 20; i++) {
            // Aggiungiamo due volte i
            // 0, 0, 1, 1, 2, 2, ...
            set.add(i);
            // ... la seconda add filtrerà gli elementi già inseriti!
            set.add(i);
        }
        printArray(set); // non stamperà duplicati!
    }
}
