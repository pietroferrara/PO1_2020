package it.unive.dais.po1.vehicle;

abstract public class Vehicle {
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
    protected void accelerate(double a) {
        if(a>=0)
            this.speed += a;
        else
            this.speed = 0;
    }


    /**
     * Stops the vehicle
     */
    final public void fullBreak() {
        speed = 0.0;
    }


}
