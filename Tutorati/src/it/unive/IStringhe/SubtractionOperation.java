package it.unive.IStringhe;

public class SubtractionOperation implements CalculatorOperation {
    public int getResult(String exp) {
        System.out.println("Performing subtraction");

        String[] tokens = exp.split("[-]");
        int sum = 0;
        int i = 0;
        for (String t : tokens) {
            int n = Integer.parseInt(t);
            if (i == 0){
                sum = n;
            } else {
                sum = sum - n;
            }
            i++;
        }
        return sum;
    }

    public boolean isOperation(String exp) {
        System.out.println("Checking if it's a subtraction");
        return exp.contains("-");
    }
}
