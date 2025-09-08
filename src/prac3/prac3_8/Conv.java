package prac3.prac3_8;

import java.util.Scanner;

public class Conv {
    public static final double EUR_R = 0.85;
    public static final double RUB_R = 73.50;

    private static  Scanner scanner = new Scanner(System.in);

    public static double convert(double value, String fromC, String toC){
        double usdV = toUSD(value, fromC);
        return fromUSD(usdV, toC);
    }

    private static double toUSD(double value, String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> value;
            case "EUR" -> value/EUR_R;
            case "RUB" -> value/RUB_R;
            default -> value;
        };
    }

    private static double fromUSD(double usdV, String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> usdV;
            case "EUR" -> usdV * EUR_R;
            case "RUB" -> usdV * RUB_R;
            default -> usdV;
        };
    }

    private static String validateCurrency() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("USD") || input.equals("RUB") || input.equals("EUR")) {
                return input;
            }

            System.out.print("Неверная валюта! Введите USD, EUR, RUB: ");
        }
    }

    private static double validDouble() {
        while (true) {
            try {
                Double number = Double.parseDouble(scanner.nextLine());
                if (number >= 0) {
                    return number;
                } else {
                    System.out.print("Число не может быть отрицательным! Введите снова: ");
                }
            } catch (Exception e){
                System.out.print("Это не число! Введите снова: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму: ");
        double value = validDouble();

        System.out.print("Из валюты(USD/EUR/RUB): ");
        String from = validateCurrency();

        System.out.print("В валюту(USD/EUR/RUB): ");
        String to = validateCurrency();

        double result = convert(value, from, to);
        System.out.printf("\nРезультат: %.2f %s = %.2f %s%n",
                value, from.toUpperCase(), result, to.toUpperCase());
    }


}
