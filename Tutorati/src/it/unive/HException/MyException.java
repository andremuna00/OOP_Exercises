package it.unive.HException;

public class MyException extends Throwable {
    int x;

    public MyException(int x) {
        this.x = x;
    }
}
