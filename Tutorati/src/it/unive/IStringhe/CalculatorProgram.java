package it.unive.IStringhe;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorProgram {
    public static void main(String[] args) {
        // TEST CON INPUTSTREAM CUSTOM
        // Proviamo a vedere come si comporta Scanner con uno stream custom
        // Vediamo come possiamo chiamare nextInt() che legge un numero intero
        // ed effettivamente legge i nostri byte fino alla fine
        // printando il numero intero 44444
        MyInputStream myInputStream = new MyInputStream();
        Scanner scannerTest = new Scanner(myInputStream);
        System.out.println(scannerTest.nextInt());

        // CALCOLATRICE
        // Utilizziamo stavolta Scanner con l'input da console (System.in)
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();

        // Possiamo creare un'array di strategie, verificando
        // per ognuna se è applicabile, e in caso applicarla
        ArrayList<CalculatorOperation> operations = new ArrayList<>();
        operations.add(new SumOperation());
        operations.add(new SubtractionOperation());
        operations.add(new SubtractionOperation());
        operations.add(new SubtractionOperation());

        for (CalculatorOperation op : operations) {
            // L'operazione è quella che ci interessa?
            if (op.isOperation(exp)){
                // Se si, calcola e stampa il risultato
                int result = op.getResult(exp);
                System.out.println(result);
            }
        }
    }
}
