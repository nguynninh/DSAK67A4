package homework3.exercise2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int size;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }


    @Override
    public void add(T data) {
        if (array.length == size())
            enlarge();
        array[size++] = data;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        if (array.length == size)
            enlarge();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        size++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size())
            throw new ArrayIndexOutOfBoundsException();
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >= size())
            throw new ArrayIndexOutOfBoundsException();
        if (size() == array.length)
            enlarge();
        for (int j = size(); j > i; --j) {
            array[j] = array[j - 1];
        }
    }

    @Override
    public void remove(T data) {
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (data.equals(array[i])) {
                index = i;
            }
        }

        remove(index);
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size() - 1; i++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < size(); i++) {
            if (data.equals(array[i]))
                return true;
        }
        return false;
    }

    @Override
    public int lastIndexOf(T data) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (data.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        Arrays.sort(array, 0, size);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[defaultSize];
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator(array);
    }

    private void enlarge() {
        array = Arrays.copyOf(array, array.length * 2);
    }
}
