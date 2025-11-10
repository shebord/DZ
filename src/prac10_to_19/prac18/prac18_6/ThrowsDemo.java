package prac10_to_19.prac18.prac18_6;

public class ThrowsDemo {

    public void printMessage(String key) {
        try {
            getDetails(key);
        } catch (NullPointerException e) {
            System.out.println("Caught exception in printMessage: " + e.getMessage());
            System.out.println("Using default key instead");
            getDetails("default");
        }
    }

    public void getDetails(String key) {
        if(key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("Key details: " + key.toUpperCase());
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();

        System.out.println("Testing with valid key");
        demo.printMessage("hello");

        System.out.println("\nTesting with null key");
        demo.printMessage(null);
    }
}