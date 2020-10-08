package it.unive.dais.po1.car.fuel;

import java.util.HashMap;
import java.util.Map;

public class FuelType {
    private final String name;
    private double costPerLiter;
    private final double FUEL_CONS;
    private final int id;

    private static int numberOfTypes = 0;

    private FuelType() {
        this("unknown", 0, 0.05);
    }

    private FuelType(String name, double costPerLiter) {
        this(name, costPerLiter, 0);
    }

    private FuelType(String name, double costPerLiter, double FUEL_CONS) {
        this.name = name;
        this.costPerLiter = Math.max(0, costPerLiter);
        this.FUEL_CONS = Math.max(0, FUEL_CONS);
        id = numberOfTypes;
        numberOfTypes++;
    }

    private static Map<String, FuelType> alreadyCreatedFuelTypes = new HashMap<>();

    static public FuelType createFuelType(String name, double costPerLiter, double FUEL_CONS) {
        if(alreadyCreatedFuelTypes.containsKey(name))
            return alreadyCreatedFuelTypes.get(name);
        FuelType result = new FuelType(name, costPerLiter, FUEL_CONS);
        alreadyCreatedFuelTypes.put(name, result);
        return result;
    }

    public double getFuelConsumption() {
        return FUEL_CONS;
    }
}