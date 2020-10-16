package it.unive.dais.po1.bicycle;

import it.unive.dais.po1.vehicle.Vehicle;

public class Bicycle extends Vehicle {

    public Bicycle(double speed, double frontTire, double rearTire) {
        super(speed);
        this.frontTire = frontTire;
        this.rearTire = rearTire;
    }

    private double frontTire, rearTire;
    public double frontTirePressure() {
        return frontTire;
    }
    public double rearTirePressure() {
        return rearTire;
    }



}

