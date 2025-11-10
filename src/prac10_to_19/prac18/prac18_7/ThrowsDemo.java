package prac10_to_19.prac18.prac18_7;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key = myScanner.next();
        printDetails(key);
    }

    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Error in printDetails: " + e.getMessage());
        }
    }

    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}