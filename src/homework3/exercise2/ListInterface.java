package homework3.exercise2;

public interface ListInterface<T> extends Iterable<T> {
    void add(T data);

    void add(int index, T data);

    T get(int i);

    void set(int i, T data);

    void remove(T data);
    void remove(int index);

    boolean isContain(T data);

    int lastIndexOf(T data);

    void sort();

    int size();

    boolean isEmpty();

    void clear();
}
