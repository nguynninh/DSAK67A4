package homework6.exercise1;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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
            if (entry.getKey().equals(curNode.getKey()))
                return true;
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
            if (newEntry.getKey().compareTo(bot.getKey()) >= 0) {
                bot.next = newEntry;
                bot = newEntry;
            } else if (newEntry.getKey().compareTo(top.getKey()) <= 0) {
                newEntry.next = top;
                top = newEntry;
            } else {
                NodeEntry<K, E> prev = top;
                NodeEntry<K, E> curr = top.next;

                while (curr != null && curr.getKey().compareTo(newEntry.getKey()) < 0) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = newEntry;
                newEntry.next = curr;
            }
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

        NodeEntry<K, E> minEntry = top;
        top = top.next;
        size--;

        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty())
            return null;
        return top;
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