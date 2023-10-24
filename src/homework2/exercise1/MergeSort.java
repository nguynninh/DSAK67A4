package homework2.exercise1;

public class MergeSort extends ASort {
    @Override
    public void sort(int[] array) {
        long start = System.nanoTime();

        mergeSort(array, 0, array.length - 1);

        time = System.nanoTime() - start;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n = right - left + 1;

        int[] mergeArray = new int[n];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j])
                mergeArray[k++] = array[i++];
            else
                mergeArray[k++] = array[j++];
            operations++;
        }

        while (i <= mid) {
            mergeArray[k++] = array[i++];
            operations++;
        }

        while (j <= right) {
            mergeArray[k++] = array[j++];
            operations++;
        }

        for (int m = 0; m < n; m++)
            array[left + m] = mergeArray[m];
    }
}
