package homework6.exercise1;

public class UnsortedArrayPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    private boolean isContainKey(Entry<K, E> arrEntry) {
        for (int i = 0; i < size; i++) {
            if (arrEntry.getKey().equals(array[i].getKey()))
                return true;
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
        if (size >= defaultSize) throw new IllegalStateException("Queue is full");
        if (isContainKey(entry)) throw new RuntimeException("Key: " + entry.getKey() + " is contain");
        array[size++] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        int minIndex = 0;
        ArrEntry<K, E> minEntry = array[0];
        for (int i = 1; i < size; i++) {
            if (minEntry.getKey().compareTo(array[i].getKey()) > 0 ) minIndex = i;
        }

        for (int i = minIndex; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return array[minIndex];
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty())
            return null;

        int minIndex = 0;
        ArrEntry<K, E> minEntry = array[0];
        for (int i = 1; i < size; i++)
            if (minEntry.getKey().compareTo(array[i].getKey()) > 0 )
                minIndex = i;

        return array[minIndex];
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++)
            builder.append(array[i] +" ");

        return builder.toString();
    }
}