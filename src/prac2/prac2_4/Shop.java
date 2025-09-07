package prac2.prac2_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Comp> computers;
    private Scanner scanner;

    public Shop() {
        computers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addComp() {
        System.out.println("Введите компьютер");

        System.out.print("Брэнд: ");
        String brand = scanner.nextLine();

        System.out.print("Модель: ");
        String model = scanner.nextLine();

        System.out.print("Процессор: ");
        String processor = scanner.nextLine();

        System.out.print("Видеокарта: ");
        String GPU = scanner.nextLine();

        System.out.print("ОЗУ: ");
        int ram = ValidInt();

        System.out.print("Память: ");
        int storage = ValidInt();

        System.out.print("Цена: ");
        int price = ValidInt();

        Comp comp = new Comp(brand, model, processor, GPU, ram, storage, price);
        computers.add(comp);

        System.out.println("Компьютер добавлен!");
    }

    public void delComp() {
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст!!!");
            return;
        }

        getAll();

        System.out.println("\nВведите номер компьютера: ");
        int num = ValidInt() - 1;

        if (num >= 0 && num < computers.size()) {
            Comp removed = computers.remove(num);
            System.out.println("Компьютер удален: " + "\n" + removed);
        } else {
            System.out.println("Неверный номер");
        }
    }

    public void getAll() {
        if (computers.isEmpty()) {
            System.out.println("Компьютеров нет в магазине!");
        }
        else{
            System.out.println("\nВсе компьютеры которые есть в магазине: ");
            for (int i = 0; i < computers.toArray().length; i++) {
                System.out.println(computers.get(i));
            }
        }
    }

    public void searchComp() {
        if (computers.isEmpty()) {
            System.out.println("Магазин пуст");
            return;
        }

        System.out.println("\n1. Поиск по бренду");
        System.out.println("2. Поиск по процессору");
        System.out.println("3. Поиск по видеокарте");
        System.out.println("4. Поиск по объему ОЗУ");
        System.out.println("5. Поиск по объему памяти");
        System.out.println("6. Поиск по цене");
        System.out.println("Выберете критерий поиска: ");

        int poisk = scanner.nextInt();
        scanner.nextLine();
        List<Comp> results = new ArrayList<>();

        switch (poisk) {
            case 1:
                System.out.println("Введите бренд:");
                String brand = scanner.nextLine();
                for (Comp comp : computers) {
                    if (comp.getBrand().equalsIgnoreCase(brand)) {
                        results.add(comp);
                    }
                }
                break;
            case 2:
                System.out.println("Введите процессор:");
                String processor = scanner.nextLine();
                for (Comp comp : computers) {
                    if (comp.getProcessor().equalsIgnoreCase(processor)) {
                        results.add(comp);
                    }
                }
                break;
            case 3:
                System.out.println("Введите видеокарту:");
                String GPU = scanner.nextLine();
                for (Comp comp : computers) {
                    if (comp.getGPU().equalsIgnoreCase(GPU)) {
                        results.add(comp);
                    }
                }
                break;
            case 4:
                System.out.println("Введите объем ОЗУ:");
                int ram = scanner.nextInt();
                for (Comp comp : computers) {
                    if (comp.getRam() >= ram) {
                        results.add(comp);
                    }
                }
                break;
            case 5:
                System.out.println("Введите объем памяти:");
                int storage = scanner.nextInt();
                for (Comp comp : computers) {
                    if (comp.getStorage() >= storage) {
                    results.add(comp);
                    }
                }
                break;
            case 6:
                System.out.println("Введите цену:");
                double price = scanner.nextInt();
                for (Comp comp : computers) {
                    if (comp.getPrice() <= price) {
                        results.add(comp);
                    }
                }
                break;
            default:
                System.out.println("Неверный выбор");
                return;
        }
        Result(results);
    }

    private void Result(List<Comp> results) {
        if (results.isEmpty()) {
            System.out.println("Нет результатов поиска");
        } else {
            System.out.println("\nРезультаты поиска");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + "\n" + results.get(i));
            }
        }
    }

    private int ValidInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число! \n");
            }
        }
    }
}