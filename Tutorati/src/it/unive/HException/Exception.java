package it.unive.HException;

import it.unive.BDynamicArray.IntDynamicArray;
import it.unive.FInterfaces.University.Prof;
import it.unive.FInterfaces.University.Student;
import it.unive.FInterfaces.University.UniversityThing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exception {

    static int calc(int k) throws MyException {

        if (k == 0) {
            return 0;
        }

        // Non serve ritornare un valore se lanciamo una eccezione
        throw new MyException(k * 2);
    }

    // Una funzione che legge un file:
    // readString può lanciare una IOException, quindi dobbiamo
    // o gestirla con un try-catch
    // o dichiarare che potrebbe lanciarla, con throws
    static int readNumberInFile() throws IOException {
        String str = Files.readString(Path.of("example.txt"));
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        // Gestiamo l'IOException con un try-catch
        try {
            readNumberInFile();
        } catch (IOException e) {
            System.out.println("Il file non esiste!");
        }

        // Eccezione unchecked, NullPointerException

        /*Student s = null;
        s.getStringValue();*/

        // Eccezione unchecked, ClassCastException

        UniversityThing prof = new Prof("Giulio", "Zausa");
        /*Student student = (Student)prof;*/

        // Gestiamo la MyException
        try {
            calc(42);
        } catch (MyException e) {
            // Possiamo leggere il nostro valore custom
            System.out.println(e.x);
        }

        // Eccezione IndexOutOfBoundsException non gestita -> programma termina
        IntDynamicArray arr = new IntDynamicArray();
        arr.get(50);
    }
}
