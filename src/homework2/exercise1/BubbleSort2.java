package homework2.exercise1;

import homework2.exercise1.ASort;

public class BubbleSort2 extends ASort {

    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            boolean is_sorter = true;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    is_sorter = false;

                    operations++;
                }
            }

            if (is_sorter) return;
        }

        time = System.nanoTime() - start;
    }
}
