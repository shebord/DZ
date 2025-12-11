package prac20_24.prac25;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = scanner.nextLine();
        System.out.println(hasDigitsWithoutPlus(string));
    }

    public static boolean hasDigitsWithoutPlus(String text) {
        Pattern pattern = Pattern.compile("\\d(?!\\+)"); //(?!...) - не следует
        Matcher matcher = pattern.matcher(text);
        boolean found = matcher.find();
        return !found;
    }
}