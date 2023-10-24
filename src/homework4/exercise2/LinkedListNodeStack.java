package homework4.exercise2;

public class LinkedListNodeStack<E> {
    private E element;
    private LinkedListNodeStack next;

    public LinkedListNodeStack(E element, LinkedListNodeStack next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public LinkedListNodeStack getNext() {
        return next;
    }

    public void setNext(LinkedListNodeStack next) {
        this.next = next;
    }
}
