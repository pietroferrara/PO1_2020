package it.unive.dais.po1.car.fuel;

public class FuelTank {
    private FuelType type;
    public double amount;
    private static int numberOfTanks;
    private final int tankId;



    public FuelTank(FuelType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.tankId = FuelTank.numberOfTanks;
        FuelTank.numberOfTanks++;
    }

    public FuelType getFuelType() {
        return this.type;
    }

    static void resetTanksCount() {
        numberOfTanks = 0;
    }

}
