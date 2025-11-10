package prac10_to_19.prac18.prac18_3;

import java.util.Scanner;

public class Exception3 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);

        } catch (Exception e) {
            System.out.println("General exception caught: " + e.getClass().getSimpleName());
        }

        myScanner.close();
    }

    public static void main(String[] args) {
        Exception3 demo = new Exception3();
        demo.exceptionDemo();
    }
}