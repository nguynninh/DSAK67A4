package homework6.exercise1;

public class TestUnsortedArrayPriorityQueue {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, String> priorityQueue = new UnsortedArrayPriorityQueue<>();

        priorityQueue.insert(3, "Three");
        priorityQueue.insert(1, "One");
        priorityQueue.insert(4, "Four");
        priorityQueue.insert(2, "Two");

        System.out.println("Priority Queue after insertion:\n" + priorityQueue.print());

        Entry<Integer, String> minEntry = priorityQueue.removeMin();
        System.out.println("\nRemoved Min Entry: " + minEntry);

        System.out.println("\nPriority Queue after removal:\n" + priorityQueue.print());

        Entry<Integer, String> min = priorityQueue.min();
        System.out.println("\nMinimum Entry without removal: " + min);

        System.out.println("\nSize of Priority Queue: " + priorityQueue.size());
        System.out.println("Is Priority Queue empty? " + priorityQueue.isEmpty());
    }
}
