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

        FuelType unknown = new FuelType();
        FuelType diesel = new FuelType("diesel",  1.3, 0.3);
        FuelType petrol = new FuelType("benzina",  1.5);

        myCar.fuelType = diesel;

        FuelTank tank = new FuelTank(diesel, 34.5);
        FuelTank tank2 = new FuelTank(diesel, 32.5);

        System.out.println(tank2.tankId);

        FuelTank.resetTanksCount();

        FuelTank tank3 = new FuelTank(diesel, 31.5);


        myCar.refuel(tank);
        myCar.accelerate(90.3);
        myCar.fullBreak();

        Car yourCar = new Car();

    }
}
