package homework2.exercise2;

import java.util.Comparator;

public interface ISort<T extends Comparable<T>> {
    void sort(T[] data);
}
