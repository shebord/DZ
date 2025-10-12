package prac1_to_9.prac6.prac6_3;

public class Tester {
    public static void main(String[] args) {

        Nameable[] nameables = {
                new Planet("Земля", 6371.0),
                new Planet("Марс", 3389.5),
                new Car("Model S", "Tesla", 2023),
                new Car("Camry", "Toyota", 2022),
                new Animal("Барсик", "Кот", 3),
                new Animal("Шарик", "Собака", 5),
                new Book("Война и мир", "Лев Толстой", 1225),
                new Book("1984", "Джордж Оруэлл", 328)
        };

        System.out.println("Имена объектов:");
        System.out.println("=".repeat(30));

        for (Nameable nameable : nameables) {
            System.out.println("Имя: " + nameable.getName());

            // Дополнительная информация в зависимости от типа объекта
            if (nameable instanceof Planet) {
                Planet planet = (Planet) nameable;
                System.out.println("Тип: Планета");
                System.out.println("Радиус: " + planet.getRadius() + " км");
            } else if (nameable instanceof Car) {
                Car car = (Car) nameable;
                System.out.println("Тип: Автомобиль");
                System.out.println("Марка: " + car.getBrand() + ", Год: " + car.getYear());
            } else if (nameable instanceof Animal) {
                Animal animal = (Animal) nameable;
                System.out.println("Тип: Животное");
                System.out.println("Вид: " + animal.getSpecies() + ", Возраст: " + animal.getAge() + " лет");
            } else if (nameable instanceof Book) {
                Book book = (Book) nameable;
                System.out.println("Тип: Книга");
                System.out.println("Автор: " + book.getAuthor() + ", Страниц: " + book.getPages());
            }

            System.out.println("-".repeat(30));
        }

        System.out.println("\nДемонстрация полиморфизма:");
        System.out.println("=".repeat(30));

        printName(new Planet("Юпитер", 69911.0));
        printName(new Car("Civic", "Honda", 2021));
        printName(new Animal("Мухтар", "Собака", 7));
        printName(new Book("Мастер и Маргарита", "Михаил Булгаков", 480));
    }

    public static void printName(Nameable nameable) {
        System.out.println("Объект: " + nameable.getName());
    }
}