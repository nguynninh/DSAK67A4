package homework4.exercise4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Use ArrayQueue: ");
        QueueInterface<Integer> arrayQueue = new ArrayQueue<>(5);
        testQueue(arrayQueue);
        System.out.println();

        System.out.println("Use LinkedListQueue:");
        QueueInterface<Integer> linkedListQueue = new LinkedListQueue<>();
        testQueue(linkedListQueue);
    }

    private static void testQueue(QueueInterface queueInterface) {
        QueueInterface<Integer> queue = queueInterface;
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.isEmpty());
        System.out.println(printQueue(queue));

        System.out.println("1st deletion: " + queue.dequeue());
        System.out.println("2st deletion: " + queue.dequeue());
        System.out.println("3st deletion: " + queue.dequeue());
        System.out.println("4st deletion: " + queue.dequeue());
        System.out.println("5st deletion: " + queue.dequeue());

        System.out.println(queue.isEmpty());
        System.out.println(printQueue(queue));
    }

    private static String printQueue(QueueInterface queue) {
        StringBuilder builder = new StringBuilder("[");

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next() + " ");
        }
        return builder.append("]").toString();
    }
}
