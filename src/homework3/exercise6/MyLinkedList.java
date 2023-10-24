package homework3.exercise6;

public class MyLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private int size = 0;

    public MyLinkedList() {

    }

    public int size() {
        return size;
    }

    public int get(int index) {
        Node current = null;
        try {
            checkBoundaries(index, size);
            current = head;
            for (int j = 0; j < index; j++) {
                current = current.next;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't get node at index " + index);
        }
        return current.data;
    }

    public void addAtHead(int val) {
        try {
            if (size == 0) head = new Node(val, head);
            else {
                Node current = new Node(val, head);
                head = current;
            }
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't add " + val + " at index " + size);
        }
    }

    public void addAtTail(int val) {
        try {
            if (size == 0) head = new Node(val, head);
            else {
                Node current = getNodeByIndex(size - 1);
                current.next = new Node(val, current.next);
            }
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't add " + val + " at index " + size);
        }
    }

    public void addAtIndex(int index, int val) {
        try {
            checkBoundaries(index, size);
            Node current = getNodeByIndex(index);
            current.data = val;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't set node at index " + index);
        }
    }

    public void deleteAtIndex(int index) {
        try {
            checkBoundaries(index, size - 1);
            if (index == 0)
                head = head.next;
            else {
                Node current = getNodeByIndex(index - 1);
                current.next = current.next.next;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Can't delete node at index " + index);
        }
        size--;
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
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
