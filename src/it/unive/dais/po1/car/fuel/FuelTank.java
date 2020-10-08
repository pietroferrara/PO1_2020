package it.unive.dais.po1.car.fuel;

/**
 *
 * @since 2.0
 */
public class FuelTank {
    private FuelType type;
    private double amount;
    private final int tankId;

    private static int numberOfTanks;

    public FuelTank(FuelType type, double amount) {
        this.type = type;
        this.amount = Math.max(0, amount);
        this.tankId = FuelTank.numberOfTanks;
        FuelTank.numberOfTanks++;
    }

    public FuelType getFuelType() {
        return this.type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = Math.max(0, amount);
    }
}
