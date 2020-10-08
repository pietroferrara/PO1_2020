package it.unive.dais.po1.car;

import it.unive.dais.po1.car.fuel.*;

import java.util.Arrays;

/**
 * Class @code Car represents a car
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
public class Car {
    private double speed;

    /**
     * This represents the amount of fuel that is still in the car tank
     */
    private double fuel;

    private FuelType fuelType;

    public Car(double speed, FuelType fuelType, double fuel) {
        this.speed = speed;
        this.fuel = Math.max(0, fuel);
        this.fuelType = fuelType;
    }

    public void refuel(FuelTank tank) throws Exception {
        if(! tank.getFuelType().equals(fuelType)) return;
        else {
            fuel += tank.getAmount();
            tank.setAmount(0);
        }
    }

    /**
     * Accelerate the car by the given amount of km/h.
     * If there is not enough fuel, the car accelerates up to the maximum
     * allowed by the remaining fuel
     * If the increase is negative, it does not accelerate
     *
     * @param a the increase of speed
     */
    public void accelerate(double a) {
        if(a<0)  return;
        double conspt = a*fuelType.getFuelConsumption();
        if(conspt <= fuel) {
            speed += a;
            fuel -= conspt;
        }
        else {
            speed += fuel/fuelType.getFuelConsumption();//How much I can accelerate given the fuel I have
            fuel = 0.0;
        }
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
        double amount = tank.getAmount();
        myCar.refuel(tank);
        myCar.accelerate(20);
        System.out.println("We are done!");
        Arrays.sort(new int[]{});

    }
}
