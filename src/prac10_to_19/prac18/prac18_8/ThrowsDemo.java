package prac10_to_19.prac18.prac18_8;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter a key: ");
                String key = myScanner.nextLine();
                if (key.trim().isEmpty()) {
                    throw new Exception("Key set to empty string");
                }
                String message = "data for " + key;
                System.out.println("Success: " + message);
                validInput = true;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        myScanner.close();
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.getKey();
    }
}
