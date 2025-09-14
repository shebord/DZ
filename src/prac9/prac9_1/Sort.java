package prac9.prac9_1;

import java.util.Arrays;

class Student {
    private int iDNumber;
    private String name;

    public Student(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{ID=" + iDNumber + ", name='" + name + "}";
    }
}

public class Sort {

    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student current = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].getIDNumber() > current.getIDNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = current;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(345, "Шебордаев Илья"),
                new Student(957, "Поляков Глеб"),
                new Student(981, "Помпаев Эрдем"),
                new Student(560, "Новиков Дмитрий"),
                new Student(678, "Нектов Роман")
        };

        System.out.println("Исходный массив студентов:");
        printStudents(students);

        insertionSort(students);

        System.out.println("\nОтсортированный массив студентов по iDNumber:");
        printStudents(students);
    }
}