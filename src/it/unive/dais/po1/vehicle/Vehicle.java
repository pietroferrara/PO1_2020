package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.car.Car;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle> {
    public double speed;

    public Vehicle(double initialSpeed) {
        this.speed = initialSpeed;
    }

    public double getSpeed() {
        return speed;
    }

    /**
     * Accelerate the vehicle by the given amount of km/h.
     * If the increase is negative, it does not accelerate
     *
     * @param a the increase of speed
     */
    public void accelerate(double a) throws NegativeSpeedException {
        if(a>=0)
            this.speed += a;
        else throw new NegativeSpeedException();
    }

    /**
     * Stops the vehicle
     */
    final public void fullBreak() {
        speed = 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.speed, speed) == 0;
    }

    public Vehicle clone() {
        return new Vehicle(this.speed);
    }

    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                '}';
    }

    public int compareTo(Vehicle o) {
        if(this.equals(o)) return 0;
        if (o == null || getClass() != o.getClass()) {
            if(this instanceof Car) {
                return 1;
            }
            else return 1;
        }
        return (int) (o.speed - this.speed);
    }
}
