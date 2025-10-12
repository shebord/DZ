package prac1_to_9.prac6.prac6_11;

class CelsiusTemperature implements Convertable {
    private double celsius;

    public CelsiusTemperature(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    @Override
    public double convert() {
        return celsius;
    }

    public double toKelvin() {
        return celsius + 273.15;
    }

    public double toFahrenheit() {
        return celsius * 9/5 + 32;
    }
}