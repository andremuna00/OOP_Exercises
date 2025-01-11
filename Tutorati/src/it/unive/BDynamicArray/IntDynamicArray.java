package it.unive.BDynamicArray;

public class IntDynamicArray {
    static final int GROW_AMOUNT = 5;

    private int[] data;
    private int count;

    public IntDynamicArray() {
        data = new int[10];
        count = 0;
    }

    private void grow() {
        int[] oldData = data;
        data = new int[count + GROW_AMOUNT];

        for (int i = 0; i < oldData.length; i++) {
            data[i] = oldData[i];
        }
    }

    public void add(int x) {
        if (count == data.length) {
            this.grow();
        }

        data[count] = x;
        count++;
    }

    public int get(int i) {
        if (i >= count) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getCount() {
        return this.count;
    }
}