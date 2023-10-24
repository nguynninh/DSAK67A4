package homework3.exercise3;

import java.util.Iterator;

public class MyLinkedListIterator implements Iterator {
    private Node currentNode;

    public MyLinkedListIterator(Node node) {
        this.currentNode = node;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Object payload = currentNode.getData();
            currentNode = currentNode.getNext();
            return payload;
        }
        return null;
    }
}


