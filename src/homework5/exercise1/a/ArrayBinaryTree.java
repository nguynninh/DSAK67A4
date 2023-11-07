package homework5.exercise1.a;

import homework5.exercise1.BinaryTreeInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    // [0,  0A,  0B,    0A+,  0A-,   0B+,   OB-,  0A+^,0A+*,0A-^,0A-*,0B+^,0B+*,OB-^,OB-*]
    // 2^0, 2^1, 2^1+1, 2^2,  2^2+1, 2^2+2, 2^2+3, ...
    // 0     1     2    3      4      5      6     7 ...
    private E[] array;
    private int size = 0;
    private final int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    @Override
    public void setData(Object data) {
        if (data instanceof Object[]) {
            Object[] objectArray = (Object[]) data;
            for (Object o : objectArray)
                array[size++] = (E) o;
        }
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
        Integer leftPos = ((int) p) * 2 + 1;
        return (leftPos < defaultSize) ? (T) leftPos : null;
    }

    @Override
    public T right(T p) {
        Integer rightPos = ((int) p) * 2 + 2;
        return (rightPos < defaultSize) ? (T) rightPos : null;
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

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void printTree(int p, int level, StringBuilder builder) {
        if (p <= size && array[p] != null) {
            printTree(2 * p + 1, level + 1, builder);
            if (level != 0) {
                for (int i = 0; i < level; i++) {
                    builder.append("\t\t");
                }
                builder.append(array[p] + "\n");
            } else {
                builder.append((Integer) array[p]);
            }
            printTree(2 * p + 2, level + 1, builder);
        }
    }

    @Override
    public boolean addDataToFile() {
        try {
            final String file = "src/homework5/exercise1/a/array_binary_tree.txt";
            FileWriter fw = new FileWriter(file);
            fw.write(toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        printTree(0, 0, builder);
        return builder.toString();
    }
}