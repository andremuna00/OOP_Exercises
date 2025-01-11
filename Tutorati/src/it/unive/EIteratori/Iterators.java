package it.unive.EIteratori;
import java.util.Iterator;

// FOREACH:
// for (tipo valore : array) {
//   ...
// }
// dove array è qualsiasi cosa che è iterabile

// Per fare un blocco foreach abbiamo bisogno di:
// 1. una classe che implementi Iterable<T>
//    e che, quindi, può creare un Iterator<T>
// 2. una classe Iterator<T> che rappresenta lo stato
//    dell'iterazione corrente

// GLOSSARIO:
// Iterable: cosa che può essere iterata (un array)
// Iterator: tiene lo stato dell'iterazione

// L'idea di base è che un ciclo for è composto da tre cose:
// - inizializzazione (int i = 0)
// - condizione (i < length)
// - step avanti (i++)
// Possiamo quindi astrarre questo comportamento con tre metodi:
// - Costruttore  <-- inizializzazione
// - hasNext()    <-- condizione se posso avanzare
// - next()       <-- ritorna il valore nella posizione corrente


public class Iterators {
    public static void main(String[] args) {
        // Con il foreach
        Numbers ns = new Numbers();
        for (int n : ns) {
            System.out.print(n + ", ");
        }

        // Con un ciclo for normale: esattamente equivalente
        for (int i = 0; true; i++) {
            System.out.print(i + ", ");
        }
    }
}
