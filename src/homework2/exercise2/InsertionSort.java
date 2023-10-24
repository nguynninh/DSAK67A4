package homework2.exercise2;

public class InsertionSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
    }
}
