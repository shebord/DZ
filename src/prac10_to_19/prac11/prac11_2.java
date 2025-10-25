package prac10_to_19.prac11;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class prac11_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        System.out.print("Введите дату (дд.мм.гггг): ");
        String inputDate = scanner.nextLine();

        try {
            Date userDate = sdf.parse(inputDate);
            Date currentDate = new Date();

            System.out.println("Введенная дата: " + sdf.format(userDate));
            System.out.println("Текущая дата: " + sdf.format(currentDate));

            if (userDate.before(currentDate)) {
                System.out.println("Прошлое");
            } else if (userDate.after(currentDate)) {
                System.out.println("Будущее");
            } else {
                System.out.println("Сегодня");
            }

        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты!");
        }
    }
}