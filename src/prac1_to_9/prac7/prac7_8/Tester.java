package prac1_to_9.prac7.prac7_8;

public class Tester {
    public static void main(String[] args) {
        Printable[] items = {
                new Book("Война и мир"),
                new Magazine("Наука и жизнь"),
                new Book("Преступление и наказание"),
                new Magazine("Forbes"),
                new Book("Мастер и Маргарита")
        };

        Book.printBooks(items);
    }
}
