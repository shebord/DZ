package prac20_24.prac25;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = scanner.nextLine();

        Pattern pattern = Pattern.compile("^(?i)[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$");
        //(?i) - игнор регистра
        //{2,} - два и более символа
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            System.out.println("Правельный формат");
        } else {
            System.out.println("Неправильный формат");
        }
    }
}
