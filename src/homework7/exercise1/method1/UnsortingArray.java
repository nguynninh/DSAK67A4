package homework7.exercise1.method1;

import java.util.Arrays;

public class UnsortingArray<T> implements List<T> {
    private T[] data;
    int size;
    private final int DEFAULTSIZE = 1;

    public UnsortingArray() {
        this.data = (T[]) new Object[DEFAULTSIZE];
    }

    public UnsortingArray(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value){
        if (data.length == size)
            enlarge();

        data[size++] = value;
    }

    @Override
    public int findByValue(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return i;
        }
        return -1;
    }

    private void enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
