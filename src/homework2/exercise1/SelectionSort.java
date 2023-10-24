package homework2.exercise1;

public class SelectionSort extends ASort {
    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;

            operations++;
        }

        time = System.nanoTime() - start;
    }
}
