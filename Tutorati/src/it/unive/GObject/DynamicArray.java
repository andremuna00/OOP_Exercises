package it.unive.GObject;

public class DynamicArray {
    static final int GROW_AMOUNT = 5;

    private Object[] data;
    private int count;

    public DynamicArray() {
        data = new Object[10];
        count = 0;
    }

    private void grow() {
        Object[] oldData = data;
        data = new Object[count + GROW_AMOUNT];

        for (int i = 0; i < oldData.length; i++) {
            data[i] = oldData[i];
        }
    }

    public void add(Object x) {
        if (count == data.length) {
            this.grow();
        }

        data[count] = x;
        count++;
    }

    public Object get(int i) {
        if (i >= count) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getCount() {
        return this.count;
    }
}
