package prac4.prac4_1_3;

public class Test {
    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person("Антон", 12);

        person1.talk();
        person2.move();

        System.out.println("Его зовут - " + person2.getFullName() + ", ему " + person2.getAge() + " лет");

    }
}