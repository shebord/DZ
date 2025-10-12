package prac1_to_9.prac7.prac7_4;

public class Tester {
    public static void main(String[] args) {
        MathFunc math = new MathFunc();

        // Тестирование возведения в степень
        System.out.println("=== Тестирование возведения в степень ===");
        System.out.println("2^3 = " + math.power(2, 3));
        System.out.println("5^2 = " + math.power(5, 2));
        System.out.println("4^0.5 = " + math.power(4, 0.5));

        // Тестирование модуля комплексного числа
        System.out.println("\n=== Тестирование модуля комплексного числа ===");
        System.out.println("|3 + 4i| = " + math.complexModulus(3, 4));
        System.out.println("|1 + 1i| = " + math.complexModulus(1, 1));
        System.out.println("|5 + 12i| = " + math.complexModulus(5, 12));

        // Тестирование длины окружности
        System.out.println("\n=== Тестирование длины окружности ===");
        double radius1 = 5.0;
        double radius2 = 10.0;
        System.out.println("Длина окружности с радиусом " + radius1 + " = " + math.circleLength(radius1));
        System.out.println("Длина окружности с радиусом " + radius2 + " = " + math.circleLength(radius2));

        // Тестирование площади круга
        System.out.println("\n=== Тестирование площади круга ===");
        System.out.println("Площадь круга с радиусом " + radius1 + " = " + math.circleArea(radius1));
        System.out.println("Площадь круга с радиусом " + radius2 + " = " + math.circleArea(radius2));

        // Демонстрация использования PI из интерфейса
        System.out.println("\n=== Использование PI из интерфейса ===");
        System.out.println("Значение PI: " + MathCalculable.PI);
    }
}
