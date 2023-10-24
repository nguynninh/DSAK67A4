package homework4.exercise2;

import java.util.Iterator;

public class LinkedListStackIterator<E> implements Iterator<E> {

    private LinkedListNodeStack currentLinkedListNodeStack;

    public LinkedListStackIterator(LinkedListNodeStack linkedListNodeStack) {
        this.currentLinkedListNodeStack = linkedListNodeStack;
    }

    @Override
    public boolean hasNext() {
        return currentLinkedListNodeStack != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            Object payload = currentLinkedListNodeStack.getElement();
            currentLinkedListNodeStack = currentLinkedListNodeStack.getNext();
            return (E) payload;
        }
        return null;
    }
}
