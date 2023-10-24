package homework4.exercise4;

import java.util.Iterator;

public class LinkedListIterrator<E> implements Iterator<E> {
    private Node root;

    public LinkedListIterrator(Node<E> root) {
        this.root = root;
    }

    @Override
    public boolean hasNext() {
        return root != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            Object data = root.getData();
            root = root.getNext();
            return (E) data;
        }
        return null;
    }
}
