package prac10_to_19.prac14;

public class prac14_2 {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";

        System.out.println("abcdefghijklmnopqrstuv18340".matches(regex));

        System.out.println("abcdefghijklmnoasdfasdpqrstuv18340".matches(regex));
        System.out.println("abc".matches(regex)); // false
        System.out.println("".matches(regex)); // false
    }
}
