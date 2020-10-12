package it.unive.dais.po1.bicycle;

import it.unive.dais.po1.car.Vehicle;

public class Bicycle extends Vehicle {
    private double frontTire, rearTire;
    public double frontTirePressure() {
        return frontTire;
    }
    public double rearTirePressure() {
        return rearTire;
    }
}

