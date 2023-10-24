package homework2.exercise2;

public class SelectionSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0)
                    minIndex = j;
            }

            T tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }
}
