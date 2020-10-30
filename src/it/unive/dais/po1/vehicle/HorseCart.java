package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.car.Truck;
import it.unive.dais.po1.car.fuel.FuelType;

public class HorseCart extends Vehicle implements Loadable {

    private double load;
    /**
     * Creates a new horse cart.
     * If the given speed is negative, they are initialized to zero.
     *
     * @param speed    the initial speed of the car
     */
    public HorseCart(double speed) {
        super(speed);
    }

    public void setLoad(double l) {
        load = l;
    }
    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return 50;
    }
}
