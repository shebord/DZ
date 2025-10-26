package prac10_to_19.prac14;

public class prac14_6 {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        System.out.println("user@example.com: " + "user@example.com".matches(regex));
        System.out.println("root@localhost: " + "root@localhost".matches(regex));

        System.out.println("myhost@@@com.ru: " + "myhost@@@com.ru".matches(regex));
        System.out.println("@my.ru: " + "@my.ru".matches(regex));
        System.out.println("Julia String: " + "Julia String".matches(regex));
    }
}