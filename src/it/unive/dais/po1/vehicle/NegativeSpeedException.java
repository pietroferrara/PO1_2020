package it.unive.dais.po1.vehicle;

public class NegativeSpeedException extends Exception {

    private double speed;

    public NegativeSpeedException(double a) {
        super("Negative speed not allowed:" + a);
        speed = a;
    }

    public double getSpeed() {
        return speed;
    }
}
