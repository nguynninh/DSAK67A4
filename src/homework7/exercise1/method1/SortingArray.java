package homework7.exercise1.method1;

import java.util.Arrays;

public class SortingArray<T extends Comparable<T>> implements List<T> {
    private T[] data;
    private int size;
    private final int DEFAULTSIZE = 100;

    public SortingArray() {
        this.data = (T[]) new Comparable[DEFAULTSIZE];
    }

    public SortingArray(int capacity) {
        this.data = (T[]) new Comparable[capacity];
    }

    @Override
    public void add(T value) {
        if (data.length == size)
            enlarge();

        if (size == 0) {
            data[size++] = value;
            return;
        }

        for (int i = 0; i < size; i++) {
            if (value.compareTo(data[i]) <= 0) {
                for (int j = size - 1; j >= i; --j)
                    data[j + 1] = data[j];
                data[i] = value;
                size++;
                return;
            }
        }
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
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i] + ", ");
        }
        if (builder.length() > 1)
            builder.setLength(builder.length() - 2);
        return builder.append("]").toString();
    }


}
