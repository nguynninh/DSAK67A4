package homework3.exercise3;

import homework3.exercise2.ListInterface;

import java.util.Iterator;

public class SimpleLinkedList<T> implements ListInterface<T> {
    private Node head;
    private int size;

    @Override
    public void add(T data) {
        try {
            if (size() == 0) head = new Node(data, head);
            else {
                Node current = getNodeByIndex(size() - 1);
                current.setNext(new Node(data, current.getNext()));
            }
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't add " + data + " at index " + size());
        }
    }

    @Override
    public void add(int index, T data) {
        try {
            checkBoundaries(index, size);
            if (index == 0) {
                head = new Node(data, head);
            } else {
                Node current = getNodeByIndex(index - 1);
                current.setNext(new Node(data, current.getNext()));
            }
            size++;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't add node at index " + index);
        }
    }

    @Override
    public T get(int i) {
        Node current = null;
        try {
            checkBoundaries(i, size);
            current = head;
            for (int j = 0; j < i; j++) {
                current = current.getNext();
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't get node at index " + i);
        }
        return (T) current.getData();
    }

    @Override
    public void set(int i, T data) {
        try {
            checkBoundaries(i, size);
            Node current = getNodeByIndex(i);
            current.setData(data);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't set node at index " + i);
        }
    }


    @Override
    public void remove(T data) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.getData().equals(data)) {
                if (prev == null)
                    head = current.getNext();
                else
                    prev.setNext(current.getNext());
                size--;
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public void removeTransmittedValue(T data) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.getData().equals(data)) {
                if (prev == null)
                    head = current.getNext();
                else
                    prev.setNext(current.getNext());
                size--;
            }
            prev = current;
            current = current.getNext();
        }
    }

    @Override
    public void remove(int index) {
        try {
            checkBoundaries(index, size - 1);
            if (index == 0) {
                head = head.getNext();
            } else {
                Node current = getNodeByIndex(index - 1);
                current.setNext(current.getNext().getNext());
            }
            size--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't remove object at index " + index);
        }

    }


    @Override
    public boolean isContain(T data) {
        try {
            Node node = head;
            for (int i = 0; i < size(); i++) {
                if (node.getData().equals(data)) return true;
                node = node.getNext();
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't get node at index");
        }
        return false;
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
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator(head);
    }

    private Node getNodeByIndex(int index) {
        Node current = null;
        try {
            checkBoundaries(index, size);
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't get node at index " + index);
        }
        return current;
    }

    public void changeValue(T oldData, T newData) {
        Node current = head;

        while (current != null) {
            if (current.getData().equals(oldData)) {
                current.setData(newData);
            }
            current = current.getNext();
        }
    }

    private void checkBoundaries(int index, int size) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
    }
}
