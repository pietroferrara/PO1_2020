package it.unive.dais.po1.vehicle;

import java.util.Objects;

public class Vehicle extends Object {
    private double speed;

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
    public void accelerate(double a) {
        if(a>=0)
            this.speed += a;
        else
            this.speed = 0;
    }

        public static void foo() { System.out.println("Vehicle 1");
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
}
