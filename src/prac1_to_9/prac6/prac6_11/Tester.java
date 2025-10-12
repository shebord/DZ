package prac1_to_9.prac6.prac6_11;

public class Tester {
    public static void main(String[] args) {
        System.out.println("=== Конвертер температур ===");

        CelsiusTemperature temp1 = new CelsiusTemperature(25);
        System.out.println("\nТемпература 25°C:");
        System.out.println("В Кельвинах: " + temp1.toKelvin() + " K");
        System.out.println("В Фаренгейтах: " + temp1.toFahrenheit() + " °F");

        Temperature temp2 = new Temperature(0, TempScale.CELSIUS);
        System.out.println("\nТемпература 0°C:");
        System.out.println("В Кельвинах: " + temp2.toKelvin() + " K");
        System.out.println("В Фаренгейтах: " + temp2.toFahrenheit() + " °F");

        Temperature temp3 = new Temperature(100, TempScale.CELSIUS);
        System.out.println("\nТемпература 100°C:");
        System.out.println("В Кельвинах: " + temp3.toKelvin() + " K");
        System.out.println("В Фаренгейтах: " + temp3.toFahrenheit() + " °F");

        Temperature fahrenheitTemp = new Temperature(212, TempScale.FAHRENHEIT);
        System.out.println("\nТемпература 212°F:");
        System.out.println("В Цельсиях: " + fahrenheitTemp.toCelsius() + " °C");
        System.out.println("В Кельвинах: " + fahrenheitTemp.toKelvin() + " K");

        System.out.println("\n=== Использование интерфейса Convertable ===");
        Convertable[] converters = {
                new CelsiusTemperature(0),
                new CelsiusTemperature(100),
                new Temperature(273.15, TempScale.KELVIN)
        };

        for (Convertable converter : converters) {
            System.out.println("Конвертированное значение: " + converter.convert() + " °C");
        }
    }
}