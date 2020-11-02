package it.unive.dais.po1;

import it.unive.dais.po1.bicycle.Bicycle;
import it.unive.dais.po1.car.Car;
import it.unive.dais.po1.car.Truck;
import it.unive.dais.po1.polygon.*;
import it.unive.dais.po1.vehicle.HorseCart;
import it.unive.dais.po1.vehicle.Loadable;
import it.unive.dais.po1.car.fuel.FuelTank;
import it.unive.dais.po1.car.fuel.FuelType;
import it.unive.dais.po1.vehicle.Racing;
import it.unive.dais.po1.vehicle.Vehicle;

import java.util.AbstractSet;
import java.util.TreeSet;

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


        Racing common_racing = new Racing();
        Car v1 = new Car(10, diesel, 10);
        Car v2 = new Car(10, diesel, 10);
        Truck v3 = new Truck(10, diesel, 10);
        Vehicle v4 = v1;
        Vehicle v5 = v3;

        v1.foo();
        v4.foo();

        v1.equals(null);

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
