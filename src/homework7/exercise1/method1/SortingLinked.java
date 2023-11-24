package homework7.exercise1.method1;

public class SortingLinked<T extends Comparable<T>> implements List<T> {
    class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    @Override
    public void add(T value) {
        try {
            if (size == 0 || value.compareTo((T) head.data) <= 0) {
                head = new Node(value, head);
            } else {
                Node node = head;
                while (node.next != null && value.compareTo((T) node.next.data) > 0) {
                    node = node.next;
                }
                node.next = new Node(value, node.next);
            }
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't add " + value + " at index " + size);
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
}
