package homework6.exercise1;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E eValue;

        public ArrEntry(K k, E e) {
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
            return "ArrEntry{" +
                    "key=" + key +
                    ", eValue=" + eValue +
                    '}';
        }
    }

    ArrEntry<K, E>[] array;
    int size = 0;
    final int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
    }

    public SortedArrayPriorityQueue(ArrEntry<K, E>[] array) {
        this.array = array;
    }

    private boolean isContainKey(Entry<K, E> arrEntry) {
        for (int i = 0; i < size; i++)
            if (arrEntry.getKey().equals(array[i].getKey()))
                return true;
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
        if (size >= defaultSize)
            throw new IllegalStateException("Queue is full");
        if (isContainKey(entry))
            throw new IllegalStateException("Key: " + entry.getKey() + " is contain");

        int i = 0;
        if (size != 0) {
            for (i = size - 1; i >= 0; i--) {
                if (entry.getKey().compareTo(array[i].getKey()) <= 0)
                    break;
                array[i + 1] = array[i];
            }
            array[i + 1] = (ArrEntry<K, E>) entry;
        } else
            array[i] = (ArrEntry<K, E>) entry;

        size++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty())
            return null;

        Entry<K, E> minEntry = array[size - 1];
        array[--size] = null;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty())
            return null;
        return array[size - 1];
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++)
            builder.append(array[i] +" ");

        return builder.toString();
    }
}