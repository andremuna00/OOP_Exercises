package it.unive.BDynamicArray;

public class Main {
    public static void main(String[] args) {
        IntDynamicArray arr = new IntDynamicArray();

        for (int i = 0; i < 20; i++) {
            arr.add(i);
        }

        for (int i = 0; i < arr.getCount(); i++) {
            System.out.print(arr.get(i) + ", ");
        }
        System.out.println();
    }
}
