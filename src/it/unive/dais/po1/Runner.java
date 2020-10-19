package it.unive.dais.po1;

import it.unive.dais.po1.bicycle.Bicycle;
import it.unive.dais.po1.car.Car;
import it.unive.dais.po1.car.Truck;
import it.unive.dais.po1.vehicle.Vehicle;
import it.unive.dais.po1.car.fuel.FuelTank;
import it.unive.dais.po1.car.fuel.FuelType;

import java.util.Arrays;

public class Runner {


    public static void main(String[] args)  {
        /*Rectangle rectangle = new Rectangle();
        rectangle.edge1Length = 2;
        rectangle.edge2Length = 3;
        System.out.println("Area of rectangle: "+rectangle.getArea());

        Square square = new Square(3);
        double area = square.getArea();
        System.out.println("Area of square: "+area);*/


        //Vehicle v = new Vehicle(10);
        //v.accelerate(10);

        FuelType diesel = FuelType.createFuelType("diesel",  1.3, 0.3);
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
        Arrays.sort(new int[]{});

    }
}
