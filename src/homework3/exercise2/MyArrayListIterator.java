package homework3.exercise2;

import java.util.Iterator;

public class MyArrayListIterator implements Iterator {
    private Object[] data;
    private int currentPosition;

    public MyArrayListIterator(Object[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < data.length && data[currentPosition] != null;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return data[currentPosition++];
        }
        return null;
    }
}

