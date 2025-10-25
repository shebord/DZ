package prac10_to_19.prac11.prac11_3;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date birthDate = new Date(105, 5, 15); // 15 июня 2005
        Student student = new Student("Иван", "Иванов", "Информатика",
                2, "ИС-21", 4.5, birthDate);

        System.out.println("Студент: " + student);
        System.out.println("Дата рождения (короткий формат): " + student.formatBirthDate("short"));
        System.out.println("Дата рождения (средний формат): " + student.formatBirthDate("medium"));
        System.out.println("Дата рождения (полный формат): " + student.formatBirthDate("full"));
    }
}