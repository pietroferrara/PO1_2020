package it.unive.dais.po1.car.fuel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * This class represents a fuel tank.
 *
 * @author Pietro Ferrara
 * @since 2.0
 */
@XmlRootElement
@XmlType
public class FuelTank {

    /**
     * The type of fuel contained in the tank
     */
    @XmlElement
    private FuelType type;

    /**
     * The amount of fuel in liters in the tank
     */
    private double amount;

    /**
     * The id of the tank
     */
    @XmlAttribute
    private final int tankId;

    public FuelTank() {
        tankId = 0;
    }

    /**
     * A counter of how many tanks have been already created
     */
    private static int numberOfTanks;

    /**
     * Creates a tank of fuel. If the given amount is negative, it creaes an empty tank.
     *
     * @param type the type of fuel
     * @param amount the amount of fuel in the tank
     */
    public FuelTank(FuelType type, double amount) {
        this.type = type;
        this.amount = Math.max(0, amount);
        this.tankId = FuelTank.numberOfTanks;
        FuelTank.numberOfTanks++;
    }


    /**
     * Returns the cost per liter of fuel type of the fuel in this tank
     *
     * @return the cost per liter
     */
    public double getFuelCost() {
        return this.type.getCostPerLiter();
    }

    /**
     * Returns the type of fuel in the tank
     *
     * @return the type of fuel
     */
    public FuelType getFuelType() {
        return this.type;
    }

    /**
     * Returns the amount of fuel in liters in the tank
     *
     * @return the amount of fuel
     */
    @XmlAttribute
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of fuel to the given value. If the given amount is negative, it
     * empties the tank
     * @param amount the amount of fuel
     */
    public void setAmount(double amount) {
        this.amount = Math.max(0, amount);
    }

    static public void resetTanksId() {
        FuelTank.numberOfTanks = 0;
    }
}
