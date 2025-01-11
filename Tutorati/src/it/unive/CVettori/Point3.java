package it.unive.CVettori;

class Point3 extends Point2 {
    // Ci basta aggiungere solo il campo z: x e y vengono ereditati da Point2
    int z;

    public Point3(int _x, int _y, int _z) {
        // Chiamiamo il costruttore di Point2 che inizializza x e y
        super(_x, _y);

        // Ci basta inizializzare solo z
        z = _z;
    }

    double lengthSquared() {
        // Chiama lengthSquared del nostro padre (Point2) che calcola x*x + y*y, aggiungendo z*z
        return super.lengthSquared() + z * z;
    }
}
