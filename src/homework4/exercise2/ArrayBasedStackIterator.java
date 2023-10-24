package homework4.exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBasedStackIterator<E> implements Iterator<E> {
    private E[] data;
    private int currentPosition;

    public ArrayBasedStackIterator(E[] data) {
        this.data = data;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < data.length && data[currentPosition] != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[currentPosition++];
    }
}
