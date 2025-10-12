package prac1_to_9.prac6.prac6_11;

class Temperature implements Convertable {
    private double value;
    private TempScale scale;

    public Temperature(double value, TempScale scale) {
        this.value = value;
        this.scale = scale;
    }

    @Override
    public double convert() {
        return toCelsius();
    }

    public double toCelsius() {
        switch (scale) {
            case CELSIUS:
                return value;
            case KELVIN:
                return value - 273.15;
            case FAHRENHEIT:
                return (value - 32) * 5/9;
            default:
                return value;
        }
    }

    public double toKelvin() {
        switch (scale) {
            case CELSIUS:
                return value + 273.15;
            case KELVIN:
                return value;
            case FAHRENHEIT:
                return (value - 32) * 5/9 + 273.15;
            default:
                return value;
        }
    }

    public double toFahrenheit() {
        switch (scale) {
            case CELSIUS:
                return value * 9/5 + 32;
            case KELVIN:
                return (value - 273.15) * 9/5 + 32;
            case FAHRENHEIT:
                return value;
            default:
                return value;
        }
    }
}
