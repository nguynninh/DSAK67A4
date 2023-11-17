package homework6.exercise1;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E eValue;

        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.eValue = e;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return eValue;
        }

        @Override
        public String toString() {
            return "NodeEntry{" +
                    "key=" + key +
                    ", eValue=" + eValue +
                    ", next=" + next +
                    '}';
        }
    }

    private NodeEntry<K, E> top;
    private NodeEntry<K, E> bot;
    private int size = 0;

    private boolean isContainKey(Entry<K, E> entry) {
        NodeEntry curNode = top;

        while (curNode != null) {
            if (entry.getKey().equals(curNode.getKey())) return true;
            curNode = curNode.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (isContainKey(entry))
            throw new IllegalStateException("Key: " + entry.getKey() + " is contain");

        NodeEntry<K, E> newEntry = (NodeEntry<K, E>) entry;
        if (top == null) {
            top = newEntry;
            bot = newEntry;
        } else {
            bot.next = newEntry;
            bot = newEntry;
        }

        size++;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newEntry = new NodeEntry<>(k, e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty())
            return null;

        NodeEntry<K, E> minPrev = null;
        NodeEntry<K, E> minCurr = top;
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> curr = top;

        while (curr != null) {
            if (minCurr.getKey().compareTo(curr.getKey()) > 0) {
                minPrev = prev;
                minCurr = curr;
            }
            prev = curr;
            curr = curr.next;
        }

        if (minPrev != null)
            minPrev.next = minCurr.next;
        else
            top = minCurr.next;

        if (minCurr == bot)
            bot = minPrev;

        size--;
        return minCurr;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;

        NodeEntry<K, E> minEntry = top;
        NodeEntry<K, E> curr = top;

        while (curr != null) {
            if (minEntry.getKey().compareTo(curr.getKey()) > 0)
                minEntry = curr;

            curr = curr.next;
        }

        return minEntry;
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        NodeEntry curNode = top;

        while (curNode != null) {
            builder.append(curNode + " ");
            curNode = curNode.next;
        }

        return builder.toString();
    }
}