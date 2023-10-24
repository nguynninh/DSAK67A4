package homework3.exercise5.exercise2x;

public class LinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public void add(T data) {
        try {
            if (size() == 0)
                head = new Node(data, head);
            else {
                Node current = getNodeByIndex(size() - 1);
                current.next = new Node(data, current.next);
            }
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't add " + data + " at index " + size());
        }
    }

    public T get(int i) {
        Node current = null;
        try {
            checkBoundaries(i, size);
            current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't get node at index " + i);
        }
        return (T) current.data;
    }

    public void set(int i, T data) {
        try {
            checkBoundaries(i, size);
            Node current = getNodeByIndex(i);
            current.data = data;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't set node at index " + i);
        }
    }


    public void remove(T data) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null)
                    head = current.next;
                else
                    prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }


    public boolean isContain(T data) {
        try {
            Node node = head;
            for (int i = 0; i < size(); i++) {
                if (node.data.equals(data)) return true;
                node = node.next;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't get node at index");
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    private Node getNodeByIndex(int index) {
        Node current = null;
        try {
            checkBoundaries(index, size);
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't get node at index " + index);
        }
        return current;
    }

    private void checkBoundaries(int index, int size) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        String s = "[";
        Node root = head;
        while (root != null) {
            s += root.data + " ";
            root = root.next;
        }
        return s + "]";
    }
}

