package homework6.exercise2;

import homework6.exercise1.Entry;
import homework6.exercise1.SortedArrayPriorityQueue;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K key, E element) {
            this.key = key;
            this.element = element;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public String toString() {
            return "{" + key + " - " + element + "}";
        }
    }

    ArrEntry<K, E> headPQ[];
    int size = 0;
    final int defaultSize = 100;

    public MinHeapPriorityQueue() {
        headPQ = new ArrEntry[defaultSize];
    }

    protected void upHead() {
        ArrEntry<K, E> newArr[] = headPQ;

        int index = size() - 1;
        int parentIdx = (index - 1) / 2;

        while (index > 0 && newArr[index].getKey().compareTo(newArr[parentIdx].getKey()) < 0) {
            swap(parentIdx, index);
            index = parentIdx;
            parentIdx = (index - 1) / 2;
        }
    }
    protected void downHead() {
        ArrEntry<K, E> newArr[] = headPQ;

        int index = 0;
        int leftIdx = index * 2 + 1;

        while (leftIdx < size()) {
            int rightIdx = leftIdx + 1;
            int minIdx = leftIdx;

            if (rightIdx < size() && newArr[leftIdx].getKey().compareTo(newArr[rightIdx].getKey()) > 0) {
                minIdx = rightIdx;
            }

            if (newArr[index].getKey().compareTo(newArr[minIdx].getKey()) > 0) {
                swap(minIdx, index);
                index = minIdx;
                leftIdx = index * 2 + 1;
            } else
                break;
        }
    }

    public void swap(int i, int j) {
        ArrEntry<K, E> temp = headPQ[j];
        headPQ[j] = headPQ[i];
        headPQ[i] = temp;
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
    public void insert(K k, E e) {
        if (size == headPQ.length) {
            headPQ = Arrays.copyOf(headPQ, headPQ.length * 2);
        }
        headPQ[size] = new ArrEntry<>(k,e);
        size++;
        upHead();
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty())
            return null;

        ArrEntry<K, E> result = headPQ[0];
        headPQ[0] = headPQ[size() - 1];
        headPQ[size() - 1] = null;
        size--;
        downHead();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                result.append("{" + headPQ[i].getKey() + " - " + headPQ[i].getValue() + "}");
            else
                result.append("{" + headPQ[i].getKey() + " - " + headPQ[i].getValue() + "}")
                        .append(", ");
        }
        return result.toString();
    }
}
