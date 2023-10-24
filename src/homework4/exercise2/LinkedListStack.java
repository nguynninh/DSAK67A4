package homework4.exercise2;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {

    private LinkedListNodeStack stack = null;

    @Override
    public void push(E element) {
        if (isEmpty()) {
            stack = new LinkedListNodeStack(element, null);
        } else {
            LinkedListNodeStack nodeStack = new LinkedListNodeStack(element, stack);
            stack = nodeStack;
        }
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();

        LinkedListNodeStack root = stack;
        stack = stack.getNext();
        return (E) root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        return (E) stack.getElement();
    }

    @Override
    public int size() {
        int count = 0;
        LinkedListNodeStack linkedListNodeStack = stack;
        while (linkedListNodeStack != null) {
            linkedListNodeStack = linkedListNodeStack.getNext();
            count++;
        }
        return count;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator<>(stack);
    }
}
