package it.unive.IStringhe;

public class SumOperation implements CalculatorOperation {
    public int getResult(String exp) {
        System.out.println("Performing sum");

        // Divide la stringa sul carattere +
        String[] tokens = exp.split("[+]");
        int sum = 0;
        for (String t : tokens) {
            int n = Integer.parseInt(t);
            sum = sum + n;
        }
        return sum;
    }

    public boolean isOperation(String exp) {
        System.out.println("Checking if it's a sum");
        // Se l'espressione contiene una +, allora è una somma
        return exp.contains("+");
    }
}
