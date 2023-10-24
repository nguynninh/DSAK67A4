package homework4.exercise4;

import java.util.Iterator;

public class ArrayQueueIterator<E> implements Iterator<E> {
    private E[] queue;
    private int currentPosition;

    public ArrayQueueIterator(E[] queue) {
        this.queue = queue;
        currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < queue.length && queue[currentPosition] != null;
    }

    @Override
    public E next() {
        return queue[currentPosition++];
    }
}


