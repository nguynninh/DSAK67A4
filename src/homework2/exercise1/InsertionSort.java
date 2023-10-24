package homework2.exercise1;

public class InsertionSort extends ASort {
    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j -= 1;

                operations++;
            }
            array[j + 1] = key;
        }

        time = System.nanoTime() - start;
    }
}
