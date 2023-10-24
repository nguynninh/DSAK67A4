package homework4.practice10.linkedlist;

class MyCircularDeque {
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front;
    private Node rear;
    private final int capacity;
    private int top = -1;

    public MyCircularDeque(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        if (front == null)
            rear = front = new Node(value, null);
        else
            front = new Node(value, front);
        top++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        if (front == null)
            rear = front = new Node(value, null);
        else {
            rear.next = new Node(value, rear.next);
            rear = rear.next;
        }
        top++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        front = front.next;
        top--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        Node node = front;
        for (int i = 0; i < top - 1; i++) {
            node = node.next;
        }

        node.next = null;
        rear = node;
        top--;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return front.data;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return rear.data;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */