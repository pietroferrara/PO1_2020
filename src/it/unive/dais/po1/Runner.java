package it.unive.dais.po1;

import it.unive.dais.po1.car.Truck;
import it.unive.dais.po1.polygon.*;
import it.unive.dais.po1.vehicle.HorseCart;
import it.unive.dais.po1.vehicle.Loadable;
import it.unive.dais.po1.car.fuel.FuelTank;
import it.unive.dais.po1.car.fuel.FuelType;

public class Runner {

    private static String getStringArea(Quadrilateral q) {
        return "The area is "+q.getArea();
    }


    private static void splitLoad(double load, Loadable[] v) {
        for(int i = 0; i < v.length; i++)
            v[i].chargeLoad(load/v.length);
    }


    public static void main(String[] args)  {
        /*Rectangle rectangle = new Rectangle(2, 3);
        System.out.println(getStringArea(rectangle));

        Square square = new Square(3);
        System.out.println(getStringArea(square));

        Rhombus rhombus = new Rhombus(3, 4, 5);
        System.out.println(getStringArea(rhombus));

        System.out.println("Perimeter: "+square.getPerimeter());/*
         */
        FuelType diesel = FuelType.createFuelType("diesel",  1.3, 0.3);
        FuelTank tank = new FuelTank(diesel, 10);


        HorseCart cart = new HorseCart(0);
        Truck truck = new Truck(100, diesel, 10);

        Loadable[] loadables = new Loadable[2];
        loadables[0] = cart;
        loadables[1] = truck;

        splitLoad(1000, loadables);


        //Vehicle v = new Vehicle(10);
        //v.accelerate(10);

        /*FuelType diesel = FuelType.createFuelType("diesel",  1.3, 0.3);
        FuelType diesel2 = FuelType.createFuelType("diesel",  1.35, 0.5);
        double fc = diesel2.getFuelConsumption();
        Car myCar = new Car(100, diesel, 10);
        myCar.accelerate(10);
        myCar.refuel(10);
        FuelTank tank = new FuelTank(diesel, 10);
        myCar.refuel(tank);
        Bicycle bike = new Bicycle(100, 2, 2);

        Truck truck = new Truck(100, diesel, 10);

        truck.fullBreak();


        double amount = tank.getAmount();
        myCar.refuel(tank);
        myCar.accelerate(20);
        System.out.println("We are done!");
        Arrays.sort(new int[]{});*/

    }
}
