package prac1_to_9.prac1;

public class pr1_5 {
    public static long factorial(int i) {
        if (i < 0) {
            return -1;
        }
        long result = 1;

        for (int n = 1; n <= i; n++) {
            result = result * n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int chisl : num) {
            long fact = factorial(chisl);
            if (fact == -1) {
                System.out.println("Error");
            } else{
                System.out.println(chisl + "! =" + fact);
            }
        }
    }
}
