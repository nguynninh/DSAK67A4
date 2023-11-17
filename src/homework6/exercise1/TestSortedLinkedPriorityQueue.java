package homework6.exercise1;

public class TestSortedLinkedPriorityQueue {
    public static void main(String[] args) {
        PriorityQueueInterface<Integer, String> linkedPriorityQueue = new SortedLinkedPriorityQueue<>();
        
        linkedPriorityQueue.insert(3, "Three");
        linkedPriorityQueue.insert(1, "One");
        linkedPriorityQueue.insert(4, "Four");
        linkedPriorityQueue.insert(2, "Two");

        System.out.println("Linked Priority Queue after insertion:");
        System.out.println(linkedPriorityQueue.print());

        Entry<Integer, String> minEntry = linkedPriorityQueue.removeMin();
        System.out.println("\nRemoved Min Entry: " + minEntry);

        System.out.println("\nLinked Priority Queue after removal:");
        System.out.println(linkedPriorityQueue.print());

        Entry<Integer, String> min = linkedPriorityQueue.min();
        System.out.println("\nMinimum Entry without removal: " + min);

        System.out.println("\nSize of Linked Priority Queue: " + linkedPriorityQueue.size());
        System.out.println("Is Linked Priority Queue empty? " + linkedPriorityQueue.isEmpty());
    }
}