package homework7.exercise1.method2;

import homework3.exercise2.ListInterface;
import homework3.exercise3.SimpleLinkedList;

import java.util.Iterator;

public class UnsortingLinked<T> implements List<T> {
    ListInterface<T> data;

    public UnsortingLinked() {
        data = new SimpleLinkedList<>();
    }

    @Override
    public void add(T data) {
        this.data.add(data);
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
