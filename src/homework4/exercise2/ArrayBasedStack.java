package homework4.exercise2;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayBasedStack<E> implements StackInterface<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int top;

    public ArrayBasedStack() {
        data = (E[]) new Object[CAPACITY];
        top = -1;
    }

    @Override
    public void push(E element) {
        if (top == data.length - 1)
            throw new StackOverflowError();
        data[++top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return data[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E top() {
        if (isEmpty())
            throw new EmptyStackException();
        return data[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayBasedStackIterator<>(data);
    }
}
