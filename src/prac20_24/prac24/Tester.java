package prac20_24.prac24;

public class Tester {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();

        Complex defaultComplex = factory.createComplex();
        System.out.println("Число по умолчанию: " + defaultComplex);

        Complex customComplex = factory.createComplex(3, -2);
        System.out.println("Кастомное число: " + customComplex);

        System.out.println("Real часть: " + customComplex.getReal());
        System.out.println("Image часть: " + customComplex.getImage());
    }
}