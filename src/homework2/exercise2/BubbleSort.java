package homework2.exercise2;

public class BubbleSort<T extends Comparable<T>> implements ISort<T> {

    @Override
    public void sort(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i].compareTo(data[j]) > 0) {
                    T tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }
}
