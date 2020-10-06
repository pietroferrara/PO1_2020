package it.unive.dais.po1.car.fuel;

public class FuelTank {
    private FuelType type;
    double amount;
    private static int numberOfTanks;
    private final int tankId;



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
