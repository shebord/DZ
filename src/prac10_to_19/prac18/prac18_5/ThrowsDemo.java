package prac10_to_19.prac18.prac18_5;

public class ThrowsDemo {
    public void getDetails(String key) {
        if(key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("Key processed: " + key);
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();

        demo.getDetails("validKey");

        demo.getDetails(null);
    }
}