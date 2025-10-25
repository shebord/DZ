package prac10_to_19.prac11;

import java.text.SimpleDateFormat;
import java.util.*;

public class prac11_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите год: ");
            int year = scanner.nextInt();

            System.out.print("Введите месяц (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Введите число: ");
            int day = scanner.nextInt();

            System.out.print("Введите часы: ");
            int hours = scanner.nextInt();

            System.out.print("Введите минуты: ");
            int minutes = scanner.nextInt();

            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);

            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date checkedDate = calendar.getTime();

            Date date = new Date(year - 1900, month - 1, day, hours, minutes);

            System.out.println("Объект Date: " + date);
            System.out.println("Объект Calendar: " + calendar.getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Форматированная дата: " + sdf.format(calendar.getTime()));

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: неверная дата или время! Проверьте введенные значения:");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введите целые числа!");
        } catch (Exception e) {
            System.out.println("Ошибка: неверные данные - " + e.getMessage());
        }
    }
}