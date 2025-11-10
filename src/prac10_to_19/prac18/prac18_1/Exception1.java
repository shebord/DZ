package prac10_to_19.prac18.prac18_1;

public class Exception1 {
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1 demo = new Exception1();
        demo.exceptionDemo();
    }
}