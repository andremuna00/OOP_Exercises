package it.unive.CVettori;

class Point2 {
    int x;
    int y;

    public Point2(int _x, int _y) {
        x = _x;
        y = _y;
    }

    double lengthSquared() {
        return x * x + y * y;
    }

    // Riuso del codice: ci basta implementarlo una volta sola
    double length() {
        return Math.sqrt(lengthSquared());
    }
}
