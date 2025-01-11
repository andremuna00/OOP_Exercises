package it.unive.EIteratori;

import java.util.Iterator;

// Il nostro iterabile, ci serve da proxy per il foreach
class Numbers implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        // Quando chiediamo l'iteratore, ne costruisce uno nuovo
        return new NumberIterator();
    }
}
