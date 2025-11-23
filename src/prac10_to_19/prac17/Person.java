package prac10_to_19.prac17;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

class ListNode {
    Person data;
    ListNode next;

    public ListNode(Person data) {
        this.data = data;
        this.next = null;
    }
}

class Person {
    private String name;
    private int age;
    private String position;
    private String department;

    public Person() {
    }

    public Person(String name, int age, String position, String department) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.department = department;
    }

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите имя: ");
            String inputName = scanner.nextLine().trim();
            if (!inputName.isEmpty()) {
                this.name = inputName;
                break;
            }
            System.out.println("Ошибка: имя не может быть пустым!");
        }

        while (true) {
            try {
                System.out.print("Введите возраст: ");
                this.age = scanner.nextInt();
                scanner.nextLine();

                if (this.age >= 0 && this.age <= 150) {
                    break;
                } else {
                    System.out.println("Ошибка: возраст должен быть от 0 до 150 лет!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите корректный возраст (число)!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Введите должность: ");
            String inputPosition = scanner.nextLine().trim();
            if (!inputPosition.isEmpty()) {
                this.position = inputPosition;
                break;
            }
            System.out.println("Ошибка: должность не может быть пустой!");
        }

        while (true) {
            System.out.print("Введите отдел: ");
            String inputDepartment = scanner.nextLine().trim();
            if (!inputDepartment.isEmpty()) {
                this.department = inputDepartment;
                break;
            }
            System.out.println("Ошибка: отдел не может быть пустым!");
        }
    }

    public void displayToConsole() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + position);
        System.out.println("Отдел: " + department);
        System.out.println("------------------------");
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return name + "," + age + "," + position + "," + department;
    }

    // Для чтения из файла
    public static Person fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 4) {
            return new Person(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
        }
        return null;
    }
}

class PersonList {
    private ListNode head;
    private int size;

    public PersonList() {
        this.head = null;
        this.size = 0;
    }

    // Функция создания пустого списка
    public void createEmptyList() {
        this.head = null;
        this.size = 0;
        System.out.println("Пустой список успешно создан!");
    }

    // Функция добавления элемента (узла) списка
    public void addPerson(Person person) {
        if (person != null) {
            ListNode newNode = new ListNode(person);

            if (head == null) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
            System.out.println("Запись успешно добавлена!");
        } else {
            System.out.println("Ошибка: нельзя добавить пустую запись!");
        }
    }

    // Функция удаления элемента из списка
    public boolean removePerson(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Ошибка: неверный индекс записи!");
            return false;
        }

        if (index == 0) {
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        System.out.println("Запись успешно удалена!");
        return true;
    }

    // Функция вывода элемента (узла) списка на экран
    public void displayPerson(int index) {
        Person person = getPerson(index);
        if (person != null) {
            System.out.println("Запись #" + (index + 1));
            person.displayToConsole();
        } else {
            System.out.println("Ошибка: неверный индекс записи!");
        }
    }

    // Функция вывода всех элементов списка
    public void displayAllPersons() {
        if (isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.println("\n=== Все записи в списке ===");
        ListNode current = head;
        int counter = 1;
        while (current != null) {
            System.out.println("Запись #" + counter);
            current.data.displayToConsole();
            current = current.next;
            counter++;
        }
    }

    // Функция очистки списка
    public void clearList() {
        head = null;
        size = 0;
        System.out.println("Список успешно очищен!");
    }

    // Функция проверки списка на пустоту (isEmpty)
    public boolean isEmpty() {
        return head == null;
    }

    // Функция записи списка в файл
    public void saveToFile(String filename) {
        try {
            File file = new File(filename);
            System.out.println("Полный путь к файлу: " + file.getAbsolutePath());

            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            ListNode current = head;
            while (current != null) {
                writer.println(current.data.toString());
                current = current.next;
            }
            writer.close();
            System.out.println("Список успешно сохранен в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    // Функция чтения списка из файла
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            clearList();
            String line;
            while ((line = reader.readLine()) != null) {
                Person person = Person.fromString(line);
                if (person != null) {
                    addPerson(person);
                }
            }
            System.out.println("Список успешно загружен из файла: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public int getSize() {
        return size;
    }

    public Person getPerson(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Поиск по имени
    public void searchByName(String name) {
        boolean found = false;
        ListNode current = head;
        int index = 0;

        while (current != null) {
            if (current.data.getName().toLowerCase().contains(name.toLowerCase())) {
                displayPerson(index);
                found = true;
            }
            current = current.next;
            index++;
        }

        if (!found) {
            System.out.println("Записи с таким именем не найдены!");
        }
    }
}

// Класс для управления картотекой с использованием PersonList
class CardIndex {
    private PersonList personList;
    private Scanner scanner;

    public CardIndex() {
        personList = new PersonList();
        scanner = new Scanner(System.in);
    }

    // Создание пустого списка
    public void createEmptyList() {
        personList.createEmptyList();
    }

    // Добавление новой персоны
    public void addPerson() {
        System.out.println("\n=== Добавление новой записи ===");
        Person person = new Person();
        person.readFromConsole();
        personList.addPerson(person);
    }

    // Просмотр всех записей
    public void displayAllPersons() {
        personList.displayAllPersons();
    }

    // Просмотр конкретной записи
    public void displayPerson() {
        System.out.print("Введите номер записи для просмотра: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            personList.displayPerson(index);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный номер!");
        }
    }

    // Удаление записи
    public void deletePerson() {
        personList.displayAllPersons();
        if (personList.isEmpty()) {
            return;
        }

        System.out.print("Введите номер записи для удаления: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            personList.removePerson(index);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный номер!");
        }
    }

    // Поиск по имени
    public void searchByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        personList.searchByName(name);
    }

    // Очистка списка
    public void clearList() {
        System.out.print("Вы уверены, что хотите очистить весь список? (y/n): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("y")) {
            personList.clearList();
        } else {
            System.out.println("Операция отменена.");
        }
    }

    // Сохранение в файл
    public void saveToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String filename = scanner.nextLine();
        personList.saveToFile(filename);
    }

    // Загрузка из файла
    public void loadFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String filename = scanner.nextLine();
        personList.loadFromFile(filename);
    }

    // Проверка пустоты списка
    public void checkEmpty() {
        System.out.println("Список " + (personList.isEmpty() ? "пуст" : "не пуст"));
    }

    // Главное меню программы
    public void showMenu() {
        while (true) {
            System.out.println("\n=== ГУИШЕЧКА ===");
            System.out.println("1. Создать пустой список");
            System.out.println("2. Добавить запись");
            System.out.println("3. Просмотреть все записи");
            System.out.println("4. Просмотреть конкретную запись");
            System.out.println("5. Найти по имени");
            System.out.println("6. Удалить запись");
            System.out.println("7. Очистить весь список");
            System.out.println("8. Сохранить в файл");
            System.out.println("9. Загрузить из файла");
            System.out.println("10. Проверить пустоту списка");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createEmptyList();
                    break;
                case "2":
                    addPerson();
                    break;
                case "3":
                    displayAllPersons();
                    break;
                case "4":
                    displayPerson();
                    break;
                case "5":
                    searchByName();
                    break;
                case "6":
                    deletePerson();
                    break;
                case "7":
                    clearList();
                    break;
                case "8":
                    saveToFile();
                    break;
                case "9":
                    loadFromFile();
                    break;
                case "10":
                    checkEmpty();
                    break;
                case "0":
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }
}

class CardIndexApp {
    public static void main(String[] args) {
        CardIndex cardIndex = new CardIndex();
        cardIndex.showMenu();
    }
}