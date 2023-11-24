package homework7.exercise1.method2;

import homework3.exercise2.ListInterface;
import homework3.exercise2.SimpleArrayList;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingArray<T> implements List<T> {
    ListInterface<T> data;

    public SortingArray() {
        this.data = new SimpleArrayList<>();
    }

    public SortingArray(int capacity) {
        this.data = new SimpleArrayList<>(capacity);
    }

    @Override
    public void add(T value) {
        data.add(value);
        data.sort();
    }

    @Override
    public int findByValue(T value) {
        return data.lastIndexOf(value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (T element : data)
            result.append(element).append(", ");

        if (result.length() > 1)
            result.setLength(result.length() - 2);

        return result.append("]").toString();
    }
}
