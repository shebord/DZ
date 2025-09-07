package prac2.prac2_6;


public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3.0);
        Circle circle2 = new Circle(10.0);
        Circle circle3 = new Circle(10.0);

        System.out.println("cirlce1: ");
        System.out.println(circle1.toString());
        System.out.println("cirlce2: ");
        System.out.println(circle2.toString());



        System.out.println("Радиус окружности после setR: " + circle1.getRadius());
        System.out.println("Длина окружности cirlce2: " + circle2.getLen());
        System.out.println("Площадь окружности cirlce1: " + circle1.getArea());

        System.out.println();
        circle1.equals(circle2);
        System.out.println();
        circle3.equals(circle2);

    }
}
