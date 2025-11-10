package prac10_to_19.prac18.prac18_2;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Error: Not a valid integer");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        }

        myScanner.close();
    }

    public static void main(String[] args) {
        Exception2 demo = new Exception2();
        demo.exceptionDemo();
    }
}