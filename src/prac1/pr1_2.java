package prac1;

import java.util.Scanner;

public class pr1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size;
        do {
            System.out.print("Введите размер: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error");
                scanner.next();
            }
            size = scanner.nextInt();
        } while (size < 0);

        int[] num = new int[size];

        System.out.println("Массив: ");
        int i = 0;
        do {
            System.out.print(i + 1 + " ");
            while (!scanner.hasNextInt()){
                System.out.println("Error");
                scanner.next();
            }
            num[i] = scanner.nextInt();
            i++;
        } while (i < size);

        int sum = 0;
        i = 0;
        do {
            sum += num[i];
            i++;
        } while (i < size);

        int max = num[0];
        i = 1;
        while (i < size) {
            if (num[i] > max) {
                max = num[i];
            }
            i++;
        }
        int min = num[0];
        i = 1;
        while (i < size) {
            if (num[i] < min) {
                min = num[i];
            }
            i++;
        }

        System.out.println("\nСумма: " + sum);
        System.out.println("Минимальное: " + min);
        System.out.println("Максимальное: " + max);
        System.out.println("Ср арифм: " + (double) sum / size);
    }
}