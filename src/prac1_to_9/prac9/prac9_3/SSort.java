package prac1_to_9.prac9.prac9_3;

import java.util.*;

class Student {
    private int iDNumber;
    private String name;
    private double gpa;

    public Student(int iDNumber, String name, double gpa) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{ID=" + iDNumber + ", name='" + name + "', GPA=" + gpa + "}";
    }
}

public class SSort {

    public static List<Student> mergeSort(List<Student> list1, List<Student> list2) {
        List<Student> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);

        return mergeSort(merged);
    }

    private static List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Student> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Student> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    private static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getIDNumber() <= right.get(j).getIDNumber()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Student> list1 = Arrays.asList(
                new Student(475, "Иван Петров", 3.8),
                new Student(867, "Мария Сидорова", 4.2),
                new Student(371, "Алексей Иванов", 3.9)
        );

        List<Student> list2 = Arrays.asList(
                new Student(926, "Елена Козлова", 4.5),
                new Student(650, "Дмитрий Смирнов", 3.7),
                new Student(982, "Ольга Новикова", 4.1)
        );

        System.out.println("Первый список:");
        for (Student s : list1) {
            System.out.println(s);
        }

        System.out.println("\nВторой список:");
        for (Student s : list2) {
            System.out.println(s);
        }

        List<Student> merged = mergeSort(list1, list2);

        System.out.println("\nОбъединенный отсортированный список:");
        for (Student s : merged) {
            System.out.println(s);
        }
    }
}