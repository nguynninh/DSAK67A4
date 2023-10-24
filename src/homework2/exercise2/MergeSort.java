package homework2.exercise2;

public class MergeSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(T[] array, int left, int mid, int right) {
        int n = right - left + 1;

        Comparable[] mergeArray = new Comparable[array.length];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right)
            if (array[i].compareTo(array[j]) <= 0)
                mergeArray[k++] = array[i++];
            else
                mergeArray[k++] = array[j++];

        while (i <= mid)
            mergeArray[k++] = array[i++];

        while (j <= right)
            mergeArray[k++] = array[j++];

        for (int m = 0; m < n; m++)
            array[left + m] = (T) mergeArray[m];
    }
}
