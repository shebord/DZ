package prac3.prac3_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class RandomD {
    public static void main(String[] args) {
        ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            double rand1 = rand.nextDouble();
            list1.add(rand1 * 100);
        }

        for (int z = 0; z < 100; z++){
            list2.add(Math.random() * 100);
        }

        System.out.println(list1);
        System.out.println(list2 + "\n");

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(list1);
        System.out.println(list2);
    }
}