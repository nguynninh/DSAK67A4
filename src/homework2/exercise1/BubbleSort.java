package homework2.exercise1;

public class BubbleSort extends ASort {

    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    operations++;
                }
            }
        }

        time = System.nanoTime() - start;
    }
}
