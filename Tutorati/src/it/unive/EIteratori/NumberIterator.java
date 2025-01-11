package it.unive.EIteratori;

import java.util.Iterator;

// Una nostra classe che implementa Iterator
// Rappresenta una serie infinita di numeri!
class NumberIterator implements Iterator<Integer> {
    int i = 0;

    // Possiamo andare avanti? Yes! è infinita :D
    @Override
    public boolean hasNext() {
        return true;
    }

    // Ritorniamo il numero successivo
    @Override
    public Integer next() {
        return i++;
    }
}
