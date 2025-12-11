package prac20_24.prac25;

import java.util.Scanner;

//2, 4, 2
public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = scanner.nextLine();

        System.out.println(string.matches("^abcdefghijklmnopqrstuv18340$"));
    }
}
