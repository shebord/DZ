package prac1_to_9.prac8.prac8_9;

public class Main {
    public static int countS(int a, int b) {
        if (a == 0) return 1;
        if (a > b + 1) return 0;

        return count(a, b);
    }

    private static int count(int zeros, int ones) {
        if (zeros == 0) return 1;
        if (zeros > ones + 1) return 0;

        return count(zeros, ones - 1) + count(zeros - 1, ones - 1);
    }

    public static void main(String[] args) {
        System.out.println(countS(100, 100));
        System.out.println(countS(1, 2));
    }
}
