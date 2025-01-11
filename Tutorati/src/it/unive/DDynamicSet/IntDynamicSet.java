package it.unive.DDynamicSet;

import it.unive.BDynamicArray.IntDynamicArray;

class IntDynamicSet extends IntDynamicArray {
    public void add(int x) {
        if (!isPresent(x)) {
            // se l'elemento non c'è, riutilizziamo il codice chiamando add di IntDynamicArray
            // (super fa riferimento a chi ereditiamo, come this fa riferimento a noi stessi)
            super.add(x);
        }
    }

    // Funziona ausiliaria per testare se un elemento è presente
    public boolean isPresent(int x) {
        for (int i = 0; i < this.getCount(); i++) {
            if (this.get(i) == x) {
                return true;
            }
        }

        return false;
    }
}
