package prac1_to_9.prac6.prac6_3;

class Car implements Nameable {
    private String name;
    private String brand;
    private int year;

    public Car(String name, String brand, int year) {
        this.name = name;
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}
