public class Car {
    double speed;
    double fuel;
    FuelType fuelType;

    void refuel(FuelTank tank) throws Exception {
        if(! tank.type.equals(fuelType)) throw new Exception();
        else fuel += tank.amount;
    }

    void accelerate(double a) {
        speed += a;
        fuel -= a*fuelType.FUEL_CONS;
    }
    void fullBreak() {
        speed = 0.0;
    }

    public static void main(String[] args) throws Exception {
        Car myCar = new Car();

        FuelType diesel = new FuelType();
        diesel.name = "diesel";
        diesel.costPerLiter = 1.3;
        diesel.FUEL_CONS = 0.3;

        myCar.fuelType = diesel;

        FuelTank tank = new FuelTank();
        tank.type = diesel;
        tank.amount = 34.5;


        myCar.refuel(tank);
        myCar.accelerate(90.3);
        myCar.fullBreak();

        Car yourCar = new Car();

    }
}
