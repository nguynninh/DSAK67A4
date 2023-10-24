package homework4.exercise4;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    private Node<E> front;
    private Node<E> rear;

    @Override
    public void enqueue(E element) {
        if (front == null) {
            rear = front = new Node<>(element, null);
        } else {
            Node<E> node = rear;
            rear = new Node<>(element,null);
            node.setNext(rear);
        }
    }

    @Override
    public E dequeue() {
        if (front == null)
            throw new IllegalStateException("Queue is empty!");

        E data = front.getData();
        front = front.getNext();
        return data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterrator(front);
    }
}
