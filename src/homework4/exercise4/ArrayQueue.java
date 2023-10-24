package homework4.exercise4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (n == count)
            throw new IllegalStateException("Queue is full");
        queue[(top + count) % n] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E element = queue[top];
        queue[top] = null;
        top = (top + 1) % n;
        count--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator(queue);
    }
}
