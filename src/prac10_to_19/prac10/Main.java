package prac10_to_19.prac10;

import java.util.*;

public class Main {
    private Student[] iDNumber;

    public void setArray(Student[] students) {
        this.iDNumber = students.clone();
    }

    public void quicksort() {
        if (iDNumber == null || iDNumber.length == 0) return;
        quicksort(0, iDNumber.length - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quicksort(low, pi - 1);
            quicksort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = iDNumber[high].getAverageGrade();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (iDNumber[j].getAverageGrade() > pivot) {
                i++;
                Student temp = iDNumber[i];
                iDNumber[i] = iDNumber[j];
                iDNumber[j] = temp;
            }
        }

        Student temp = iDNumber[i + 1];
        iDNumber[i + 1] = iDNumber[high];
        iDNumber[high] = temp;

        return i + 1;
    }

    public void mergeSort() {
        if (iDNumber == null || iDNumber.length == 0) return;
        mergeSort(0, iDNumber.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        Student[] leftArray = Arrays.copyOfRange(iDNumber, left, mid + 1);
        Student[] rightArray = Arrays.copyOfRange(iDNumber, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].getAverageGrade() > rightArray[j].getAverageGrade()) {
                iDNumber[k++] = leftArray[i++];
            } else {
                iDNumber[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            iDNumber[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            iDNumber[k++] = rightArray[j++];
        }
    }

    public void sortByLastName() {
        Arrays.sort(iDNumber, (s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
    }

    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }

    public static Student[] mergeArrays(Student[] arr1, Student[] arr2) {
        Student[] merged = new Student[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        return merged;
    }

    public static void main(String[] args) {
        Main sorter = new Main();

        Student[] list1 = {
                new Student("Иван", "Иванов", "Информатика", 2, "ИС-21", 4.5),
                new Student("Петр", "Петров", "Математика", 1, "М-11", 3.8),
                new Student("Мария", "Сидорова", "Физика", 3, "Ф-31", 4.9)
        };

        Student[] list2 = {
                new Student("Алексей", "Смирнов", "Математика", 4, "М-41", 4.7),
                new Student("Елена", "Попова", "Физика", 2, "Ф-21", 3.9)
        };

        System.out.println("Первый список:");
        sorter.setArray(list1);
        sorter.outArray();

        System.out.println("\nВторой список:");
        sorter.setArray(list2);
        sorter.outArray();

        Student[] merged = mergeArrays(list1, list2);
        sorter.setArray(merged);

        System.out.println("\nПОСЛЕ ОБЪЕДИНЕНИЯ");
        sorter.outArray();

        System.out.println("\nБЫСТРАЯ СОРТИРОВКА ПО БАЛЛУ");
        sorter.quicksort();
        sorter.outArray();

        System.out.println("\nСОРТИРОВКА СЛИЯНИЕМ ПО БАЛЛУ");
        sorter.setArray(merged);
        sorter.mergeSort();
        sorter.outArray();

        System.out.println("\nСОРТИРОВКА ПО ФАМИЛИИ");
        sorter.setArray(merged);
        sorter.sortByLastName();
        sorter.outArray();
    }
}
