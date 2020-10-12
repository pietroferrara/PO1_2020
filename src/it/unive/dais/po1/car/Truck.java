package it.unive.dais.po1.car;


import it.unive.dais.po1.car.fuel.FuelType;

public class Truck extends Car {
    private double load;

    /**
     * Creates a new car.
     * If the given speed and fuel amount are negative, they are initialized to zero.
     *
     * @param speed    the initial speed of the car
     * @param fuelType the type of the fuel of the car
     * @param fuel     the amount of fuel in the car tank
     */
    public Truck(double speed, FuelType fuelType, double fuel) {
        super(speed, fuelType, fuel);
    }

    public void chargeLoad(double l) {
        load += l;
    }
}
