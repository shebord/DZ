package prac1_to_9.prac6.prac6_4;

class Food implements Priceable {
    private String name;
    private double pricePerKg;
    private double weight;

    public Food(String name, double pricePerKg, double weight) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return pricePerKg * weight;
    }

    public String getName() {
        return name;
    }
}