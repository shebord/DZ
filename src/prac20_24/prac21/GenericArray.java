package prac20_24.prac21;

import java.lang.reflect.Array;

public class GenericArray<T> {
    private T[] array;
    private Class<T> type;

    public GenericArray(Class<T> type, int size) {
        this.type = type;
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(type, size);
        this.array = arr;
    }

    public GenericArray(T[] array) {
        this.array = array;
        if (array.length > 0) {
            this.type = (Class<T>) array.getClass().getComponentType();
        }
    }

    public void set(int index, T value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
    }

    public T get(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
    }

    public int size() {
        return array.length;
    }

    public T[] toArray() {
        return array.clone();
    }
    public static void main(String[] args) {
        GenericArray<Integer> intArray = new GenericArray<>(Integer.class, 5);
        intArray.set(0, 10);
        intArray.set(1, 20);
        intArray.set(2, 30);

        System.out.println("Элемент по индексу 1: " + intArray.get(1));
        System.out.println("Элемент по индексу 2: " + intArray.get(2));

        GenericArray<String> strArray = new GenericArray<>(String.class, 3);
        strArray.set(0, "Hello");
        strArray.set(1, "World");
        strArray.set(2, "Java");

        System.out.println("Элемент по индексу 0: " + strArray.get(0));
        System.out.println("Элемент по индексу 2: " + strArray.get(2));

        GenericArray<Double> doubleArray = new GenericArray<>(Double.class, 4);
        doubleArray.set(0, 3.14);
        doubleArray.set(1, 2.71);

        System.out.println("Элемент double по индексу 0: " + doubleArray.get(0));
    }
}