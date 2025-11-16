package prac10_to_19.prac19.prac19_1;

import java.util.Scanner;

class InvalidINNException extends Exception {
    public InvalidINNException(String message) {
        super(message);
    }
}

public class exception {

    public static void progStart () {
        INN obj1 = new INN("ilia", "1234");
        boolean flag;

        flag = true;

        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя - ");
            String name1 = scanner.next();

            if (name1.equals(obj1.getName())) {
                try {
                    System.out.println("Введите инн - ");
                    String inn1 = scanner.next();

                    validateINN(inn1, obj1.getInn());

                    System.out.println("ИНН верный! Доступ разрешен.");
                    flag = false;
                }
                catch (InvalidINNException e) {
                    System.out.println(e.getMessage());
                    flag = false;
                }
            }
            else {
                System.out.println("Такого пользователя нет в системе!");
                flag=false;
            }
        }
    }

    public static void validateINN(String inn, String expectedINN) throws InvalidINNException {
        if (!inn.equals(expectedINN)) {
            throw new InvalidINNException("Неверный ИНН - вход в программу запрещен!");
        }
    }

    public static void main(String[] args) {
        exception.progStart();
    }

}