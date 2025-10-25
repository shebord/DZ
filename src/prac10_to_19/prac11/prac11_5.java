package prac10_to_19.prac11;

import java.util.*;

public class prac11_5 {
    public static void main(String[] args) {

        int size = 100000;

        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long addEndTime = System.currentTimeMillis();

        arrayList.add(0, -1);
        long addStartTime = System.currentTimeMillis();

        arrayList.remove(0);
        long removeStartTime = System.currentTimeMillis();

        arrayList.indexOf(size / 2);
        long searchTime = System.currentTimeMillis();

        System.out.println("ArrayList результаты:");
        System.out.println("Добавление в конец: " + (addEndTime - startTime) + " мс");
        System.out.println("Добавление в начало: " + (addStartTime - addEndTime) + " мс");
        System.out.println("Удаление из начала: " + (removeStartTime - addStartTime) + " мс");
        System.out.println("Поиск элемента: " + (searchTime - removeStartTime) + " мс");

        List<Integer> linkedList = new LinkedList<>();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        addEndTime = System.currentTimeMillis();

        linkedList.add(0, -1);
        addStartTime = System.currentTimeMillis();

        linkedList.remove(0);
        removeStartTime = System.currentTimeMillis();

        linkedList.indexOf(size / 2);
        searchTime = System.currentTimeMillis();

        System.out.println("\nLinkedList результаты:");
        System.out.println("Добавление в конец: " + (addEndTime - startTime) + " мс");
        System.out.println("Добавление в начало: " + (addStartTime - addEndTime) + " мс");
        System.out.println("Удаление из начала: " + (removeStartTime - addStartTime) + " мс");
        System.out.println("Поиск элемента: " + (searchTime - removeStartTime) + " мс");
    }
}