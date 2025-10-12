package prac1_to_9.prac8.prac8_1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        try {
            int n = scanner.nextInt();

            int count = 0;

            for (int i = 1; count < n; i++) {
                for (int j = 1; j <= i && count < n; j++) {
                    System.out.print(i + " ");
                    count++;
                }
            }

        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка ввода!");
            scanner.close();
        }
    }
}
