package it.unive.IStringhe;

public interface CalculatorOperation {
    // È l'operazione di quella classe?
    boolean isOperation(String exp);

    // Calcola il risultato
    int getResult(String exp);
}
