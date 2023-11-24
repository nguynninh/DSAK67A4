package homework7.exercise1.method1;

public class UnsortingLinked<T> implements List<T> {
    class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tali;
    private int size;

    @Override
    public void add(T data) {
        try {
            if (size == 0)
                head = tali = new Node(data, head);
            else
                tali.next = new Node(data, tali.next);
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't add " + data + " at index " + size);
        }
    }

    @Override
    public int findByValue(T value) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(value))
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        Node node = head;
        while (node != null) {
            builder.append(node.data + ", ");
            node = node.next;
        }

        if (builder.length() > 1)
            builder.setLength(builder.length() - 2);

        return builder.append("]").toString();
    }

    private void checkBoundaries(int index, int size) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
    }
}
