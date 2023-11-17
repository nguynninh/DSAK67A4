package homework6.exercise2;

public class TestMinHeapPriorityQueue {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> minHeapPriorityQueue = new MinHeapPriorityQueue<>();
        minHeapPriorityQueue.insert(4, "One");
        minHeapPriorityQueue.insert(3, "Two");
        minHeapPriorityQueue.insert(1, "Three");
        minHeapPriorityQueue.insert(6, "Fore");
        minHeapPriorityQueue.insert(7, "Five");
        minHeapPriorityQueue.insert(0, "Six");

        System.out.println("Priority Queue implemented using a heap (array-based) implementation:");
        System.out.println(minHeapPriorityQueue + "\n");

        System.out.println("Minimum element: \n" + minHeapPriorityQueue.removeMin() +"\n");

        System.out.println("Priority Queue after removing the minimum element:");
        System.out.println(minHeapPriorityQueue);
    }
}

