package it.unive.DDynamicSet;

import it.unive.BDynamicArray.IntDynamicArray;

public class MainInstaceOf {
    // Prendiamo in input un generico IntDynamicArray,
// superclasse di IntDynamicSet
    static boolean isTwoPresent(IntDynamicArray arr) {

        // Con instanceof controlliamo se arr è in realtà
        // stato costruito come IntDynamicSet
        if (arr instanceof IntDynamicSet) {

            // In questo caso possiamo fare un cast sicuro e chiamare
            // isPresent, che esiste solo in IntDynamicSet
            IntDynamicSet mySet = (IntDynamicSet) arr;
            return mySet.isPresent(2);

        } else {
            // In caso contrario, dobbiamo per forza usare,
            // un modo alternativo, scorrendo l'array
            for (int i = 0; i < arr.getCount(); i++) {
                if (arr.get(i) == 2) {
                    return true;
                }
            }

            return false;
        }
    }

    // Stessa cosa di prima, ma senza controllo instanceof
    static boolean isTwoPresentUnsafe(IntDynamicArray arr) {
        // Facciamo un cast non sicuro e chiamamiamo isPresent
        IntDynamicSet mySet = (IntDynamicSet) arr;
        return mySet.isPresent(2);

        // WARNING: se arr non sarà un IntDynamicSet avremo
        // un errore ClassCastException a runtime!!
    }

    public static void main(String[] args) {
        // Creiamo un IntDynamicSet e assegnamolo ad un pointer
        // di tipo IntDynamicArray. In questo modo perdiamo
        // l'informazione dei campi aggiuntivi! Possiamo
        // fare questa assegnazione perchè IntDynamicSet è
        // SOTTOTIPO di IntDynamicArray
        IntDynamicArray mySet = new IntDynamicSet();
        mySet.add(1);
        mySet.add(2);

        // Funzioneranno entrambi senza errori, dato che stiamo
        // passando in realtà un IntDynamicSet
        System.out.println(isTwoPresent(mySet));
        System.out.println(isTwoPresentUnsafe(mySet));

        // Proviamo ora istanziando un IntDynamicArray...
        IntDynamicArray myArray = new IntDynamicArray();
        myArray.add(1);
        myArray.add(2);

        // Questo funzionerà, dato che cadrà nel secondo ramo
        // dell'if con instanceof
        System.out.println(isTwoPresent(myArray));
        // Questo invece darà un errore!
        // myArray non è un IntDynamicSet e non possiamo
        // fare il cast!
        System.out.println(isTwoPresentUnsafe(myArray));
    }
}
