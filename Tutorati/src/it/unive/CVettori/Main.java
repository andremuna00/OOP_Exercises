package it.unive.CVettori;

public class Main {
    public static void main(String[] args) {
        Point2 p2 = new Point2(2,3);
        System.out.println(p2.length()); // stamperà sqrt(2*2 + 3*3)

        Point3 p3 = new Point3(2,3, 5);
        System.out.println(p3.length()); // stamperà sqrt(2*2 + 3*3 + 5*5)

        // Point3 è compatibile con Point2: un riferimento a Point2 può puntare ad un Point3
        Point2 pTest = p3;

        // stamperà sqrt(2*2 + 3*3 + 5*5), dal momento che verranno invocati
        // i metodi della classe di cui abbiamo fatto la new (Point3)
        System.out.println(pTest.length());
    }
}