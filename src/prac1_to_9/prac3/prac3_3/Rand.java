package prac1_to_9.prac3.prac3_3;

import java.util.ArrayList;
import java.util.Random;

public class Rand {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Random random = new Random();

        int min = 10;
        int max = 99;

        for (int i = 0; i < 5; i++) {
            int rand1 = random.nextInt(max - min + 1) + min;
            list.add(rand1);
        }

        System.out.println(list + "\n");

        for (int n = 0; n < list.toArray().length - 1; n++){
            if (list.get(n) >= list.get(n + 1)) {
                System.out.println("Массив не возрастающий!!!");
                return;
            }
        }
        System.out.println("Массив строго возрастающий!!!");
    }
}
