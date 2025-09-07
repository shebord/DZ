package prac2.prac2_4;

import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить компьютер");
            System.out.println("2. Удлаить компьютер");
            System.out.println("3. Найти компьютер");
            System.out.println("4. Показать все компьютеры");
            System.out.println("5. Выход");

            int f = scanner.nextInt();
            scanner.nextLine();
            if (f < 0) {
                System.out.println("Неверное значение");
            } else {
                switch (f) {
                    case 1:
                        shop.addComp();
                        break;
                    case 2:
                        shop.delComp();
                        break;
                    case 3:
                        shop.searchComp();
                        break;
                    case 4:
                        shop.getAll();
                        break;
                    case 5:
                        System.out.println("ББ");
                        return;
                    default:
                        System.out.println("Что-то не то");
                }

            }
        }
    }
}
