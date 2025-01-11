package it.unive.GObject;

public class DynamicSet extends DynamicArray {
    public void add(Object x) {
        if (!isPresent(x)) {
            super.add(x);
        }
    }

    private boolean isPresent(Object x) {
        for (int i = 0; i < getCount(); i++) {
            // Per verificare se l'oggetto è presente possiamo chiamare equals
            // - se viene fatto l'override (come in Date) possono venire confrontati i campi
            // - se NON viene fatto l'override di default vengono confrontati i puntatori
            if (x.equals(get(i))) {
                return true;
            }
        }

        return false;
    }
}

