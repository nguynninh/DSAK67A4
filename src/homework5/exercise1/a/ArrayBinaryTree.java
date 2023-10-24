package homework5.exercise1.a;

import homework5.exercise1.BinaryTreeInterface;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    // [0,  0A,  0B,    0A+,  0A-,   0B+,   OB-,  0A+^,0A+*,0A-^,0A-*,0B+^,0B+*,OB-^,OB-*]
    // 2^0, 2^1, 2^1+1, 2^2,  2^2+1, 2^2+2, 2^2+3, ...
    // 0     1     2    3      4      5      6     7 ...
    private E[] array;
    private int size = 0;
    private final int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    @Override
    public T root() {
        return (T) array[0];
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
    public int numChildren(T p) {
        return numChil(p);
    }

    @Override
    public T parent(T p) {
        return (T) array[((int) p) / 2];
    }

    @Override
    public T left(T p) {
        return (T) array[((int) p) * 2 + 1];
    }

    @Override
    public T right(T p) {
        return (T) array[((int) p) * 2 + 2];
    }

    @Override
    public T sibling(T p) {
        return null;
    }

    //PRIVATE
    private int numChil(T p) {
        int count = 0;
        if (array[(int) p] == null)
            return count;

        if (left(p) != null) numChil(left(p));
        if (right(p) != null) numChil(right(p));
        return ++count;
    }
}