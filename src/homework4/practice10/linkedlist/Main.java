package homework4.practice10.linkedlist;

public class Main {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}