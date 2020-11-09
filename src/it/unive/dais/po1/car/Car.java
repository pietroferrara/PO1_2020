package it.unive.dais.po1.car;

import it.unive.dais.po1.bicycle.Bicycle;
import it.unive.dais.po1.car.fuel.*;
import it.unive.dais.po1.vehicle.Vehicle;

import java.util.Objects;

/**
 * This class represents a car with a speed and a fuel tank. The methods of this class allows to accelerate, brake,
 * and refuel that car.
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
public class Car extends Vehicle {

    /**
     * This field contains the amount of fuel in liters that is still in the car tank
     */
    private double fuel;

    /**
     * This field contains the type of fuel of the car
     */
    private FuelType fuelType;


    /**
     * Creates a new car.
     * If the given speed and fuel amount are negative, they are initialized to zero.
     *
     * @param speed the initial speed of the car
     * @param fuelType the type of the fuel of the car
     * @param fuel the amount of fuel in the car tank
     */
    public Car(double speed, FuelType fuelType, double fuel) {
        super(Math.max(0, speed));
        this.fuel = Math.max(0, fuel);
        this.fuelType = fuelType;
    }
    public Car(FuelType fuelType, double fuel) {
        this(0, fuelType, fuel);
    }

    /**
     * Returns the cost per liter of fuel type of this car
     *
     * @return the cost per liter
     */

    public double getFuelCost() {
        return this.fuelType.getCostPerLiter();
    }

    /**
     * Refuels the car with the amount of fuel in the given tank.
     * If the type of fuel in the tank is different from the one of the car, this
     * method does nothing. Otherwise, it refuels the car, and it empties the tank.
     *
     * @param tank the tank of fuel to refuel the car
     */
    public void refuel(FuelTank tank)
    {
        if(! tank.getFuelType().equals(fuelType)) return;
        else {
            fuel += tank.getAmount();
            tank.setAmount(0);
        }
    }


    public void refuel(double amount)
    {
        fuel += amount;
    }

    /**
     * Accelerate the car by the given amount of km/h and it consumes the fuel accordingly.
     * If there is not enough fuel, the car accelerates up to the maximum
     * allowed by the remaining fuel
     * If the increase is negative, it does not accelerate
     *
     * @param a the increase of speed
     */
    final public void accelerate(double a) {
        super.accelerate(a);
        if(a<0)  return;
        double conspt = a*fuelType.getFuelConsumption();
        if(conspt <= fuel) {
            super.accelerate(a); //super.speed += a;
            fuel -= conspt;
        }
        else {
            super.accelerate(fuel/fuelType.getFuelConsumption());//this.speed += fuel/fuelType.getFuelConsumption();//How much I can accelerate given the fuel I have
            fuel = 0.0;
        }
    }

    public static void foo() { System.out.println("Vehicle 2");
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + super.getSpeed() +
                ", fuel=" + fuel +
                ", fuelType=" + fuelType +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Double.compare(car.fuel, fuel) == 0 &&
                Objects.equals(fuelType, car.fuelType);
    }

    public int hashCode() {
        return Objects.hash(fuel, fuelType);
    }
/*public boolean isFuelEmpty() {
        if(fuel <= 0) {
            super.speed = super.speed * 0.9;
            return true;
        }
        else
            return false;
    }*/


}
