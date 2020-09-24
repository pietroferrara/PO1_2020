class FuelType {
    String name;
    double costPerLiter;
    double FUEL_CONS;
    static int numberOfTypes = 0;
    final int id;

    public FuelType() {
        this("unknown", 0, 0.05);
    }

    public FuelType(String name, double costPerLiter) {
        this(name, costPerLiter, 0);
    }

    public FuelType(String name, double costPerLiter, double FUEL_CONS) {
        this.name = name;
        this.costPerLiter = costPerLiter;
        this.FUEL_CONS = FUEL_CONS;
        id = numberOfTypes;
        numberOfTypes++;
    }
}