package prac1;

public class pr1_4 {
    public static void main(String[] args) {
       for (int i = 1; i <= 10; i++) {
           double num = 0.0;

           for (int n = 1; n <= i; n++) {
               num += 1.0 / n;
           }

           System.out.printf("H(%d) = %.6f%n", i, num);
       }
    }
}
