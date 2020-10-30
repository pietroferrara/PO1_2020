package it.unive.dais.po1.car;


import it.unive.dais.po1.Printable;
import it.unive.dais.po1.car.fuel.FuelType;
import it.unive.dais.po1.vehicle.Loadable;
import it.unive.dais.po1.vehicle.LoadableUnloadable;

public class Truck extends Car implements LoadableUnloadable, Printable {
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

    public void setLoad(double l) {
        load = l;
    }

    public double getLoad() {
        return load;
    }

    @Override
    public double getMaxLoad() {
        return 3000;
    }


    public void print() {
        System.out.print("This is a truck with "+load+" kgs, at speed "+this.getSpeed());
    }

    public void unchargeLoad(double l) {
        if(load >= l) {
            load -= l;
        }
        else load = 0;
    }
}
