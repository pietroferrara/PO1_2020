package it.unive.dais.po1.car.fuel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class represents a type of fuel. Only an instance per name of fuel can exist.
 *
 * @author Pietro Ferrara
 * @since 1.0
 */
@XmlRootElement
@XmlType
public class FuelType {

    /**
     * The name of the fuel
     */
    @XmlAttribute
    private final String name;

    /**
     * The cost of a liter of fuel
     */
    @XmlAttribute
    private double costPerLiter;

    /**
     * The consumption of fuel, represented as km per liter
     */
    @XmlAttribute
    private final double FUEL_CONS;


    public FuelType() {
        this.name = "unknown";
        this.FUEL_CONS = 0;
    }

    /**
     * Creates a fuel type
     *
     * @param name the name of the fuel type
     * @param costPerLiter the cost of one liter of fuel of this type
     * @param FUEL_CONS the consumption (km/l)
     */
    private FuelType(String name, double costPerLiter, double FUEL_CONS) {
        this.name = name;
        this.costPerLiter = Math.max(0, costPerLiter);
        this.FUEL_CONS = Math.max(0, FUEL_CONS);
    }


    /**
     * Returns the cost per liter of this fuel type
     *
     * @return the cost per liter
     */
    public double getCostPerLiter() {
        return this.costPerLiter;
    }

    /**
     * Creates and returns a fuel type. If a fuel type with the given name was previously created,
     * the method returns the existing instance (with the cost per liter and fuel consumption set
     * when this was created). Otherwise, it creates and returns a new fuel type caching it.
     *
     * @param name the name of the fuel type
     * @param costPerLiter the cost of one liter of fuel of this type
     * @param FUEL_CONS the consumption (km/l)
     * @return an instance of fuel type with the given name
     */
    static public FuelType createFuelType(String name, double costPerLiter, double FUEL_CONS) {
        FuelType result = FuelTypeCache.getFuelTypeFromName(name);
        if(result==null) {
            result = new FuelType(name, costPerLiter, FUEL_CONS);
            FuelTypeCache.storeFuelType(result);
        }
        return result;
    }

    /**
     * Return the fuel consumption of this type of fuel
     * @return the fuel consumption
     */
    public double getFuelConsumption() {
        return FUEL_CONS;
    }

    /**
     * Return the name of the fuel type
     *
     * @return the name of the fuel type
     */
    public String getName() {
        return name;
    }
}