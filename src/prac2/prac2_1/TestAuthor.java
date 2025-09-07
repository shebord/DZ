package prac2.prac2_1;

public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Иля", "ily@gmail.com", 'M');

        System.out.println("Имя: " + author.getName());

        System.out.println("Почта: " + author.getEmail());

        System.out.println("Пол: " + author.getGender());

        System.out.println("Информация об авторе: " + author.toString());
        System.out.println();

        author.setEmail("sneb@gmail.com");
        System.out.println("Новый email автора: " + author.getEmail());
        System.out.println("Обновленная информация: " + author.toString());
    }
}
