package it.unive.IStringhe;

import java.io.InputStream;

public class MyInputStream extends InputStream {
    // Numero di caratteri stampati finora
    int n = 0;

    // Ci basta implementare la read, dato che gli altri metodi
    // come available e gli overload di read sono già implementati
    // dalla classe astratta InputStream
    public int read() {
        if (n < 5) {
            n++;
            return '4';
        } else {
            // Il carattere di fine riga dice a Scanner che l'input è finito
            return '\n';
        }
    }
}
