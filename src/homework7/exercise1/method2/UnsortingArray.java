package homework7.exercise1.method2;

import homework3.exercise2.ListInterface;
import homework3.exercise2.SimpleArrayList;

public class UnsortingArray<T> implements List<T> {
    ListInterface<T> data;

    public UnsortingArray() {
        this.data = new SimpleArrayList();
    }

    public UnsortingArray(int capacity) {
        this.data = new SimpleArrayList<>(capacity);
    }

    @Override
    public void add(T value) {
        data.add(value);
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
