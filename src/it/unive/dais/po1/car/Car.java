package it.unive.dais.po1.car;

import it.unive.dais.po1.car.fuel.*;

public class Car {
    private double speed;
    private double fuel;
    private FuelType fuelType;

    public Car(double speed, FuelType fuelType, double fuel) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelType = fuelType;
    }

    public void refuel(FuelTank tank) throws Exception {
        if(! tank.getFuelType().equals(fuelType)) throw new Exception();
        else {
            fuel += tank.amount;
            tank.amount = 0;
        }
    }

    public void accelerate(double a) {
        speed += a;
        fuel -= a*fuelType.getFuelConsumption();
    }
    public void fullBreak() {
        speed = 0.0;
    }


    public static void main(String[] args) throws Exception {

        FuelType diesel = FuelType.createFuelType("diesel",  1.3, 0.3);
        FuelType diesel2 = FuelType.createFuelType("diesel",  1.35, 0.5);
        double fc = diesel2.getFuelConsumption();
        Car myCar = new Car(100, diesel, 10);
        FuelTank tank = new FuelTank(diesel, 10);
        double amount = tank.amount;
        myCar.refuel(tank);

    }
}
