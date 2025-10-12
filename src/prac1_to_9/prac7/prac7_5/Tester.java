package prac1_to_9.prac7.prac7_5;

public class Tester {
    public static void main(String[] args) {
        StringProc processor = new StringProc();

        // Тестирование функций
        processor.demonstrate("Hello");
        processor.demonstrate("Programming");
        processor.demonstrate("Java");
        processor.demonstrate("A");
        processor.demonstrate("");

        // Отдельное использование функций
        String test = "Hello World";
        System.out.println("Тестовая строка: " + test);
        System.out.println("Длина: " + processor.countCharacters(test));
        System.out.println("Нечетные позиции: " + processor.getOddPositionCharacters(test));
        System.out.println("Реверс: " + processor.reverseString(test));
    }
}
