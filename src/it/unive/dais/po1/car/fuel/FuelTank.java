package it.unive.dais.po1.car.fuel;

public class FuelTank {
    FuelType type;
    double amount;
    static int numberOfTanks;
    final int tankId;



    public FuelTank(FuelType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.tankId = FuelTank.numberOfTanks;
        FuelTank.numberOfTanks++;
    }

    static void resetTanksCount() {
        numberOfTanks = 0;
    }

}
