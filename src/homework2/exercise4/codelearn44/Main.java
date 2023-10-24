package homework2.exercise4.codelearn44;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = inputArray(sc);

        int[] arraySort = sortArray(array);
        System.out.println(printArray(arraySort));
    }

    private static int[] inputArray(Scanner sc) {
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int[] sortArray(int[] array) {
        int[] arraySort = Arrays.copyOf(array, array.length);

        mergeSort(arraySort, 0, array.length - 1);

        return arraySort;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n = right - left + 1;

        int[] mergeArray = new int[n];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j])
                mergeArray[k++] = array[i++];
            else
                mergeArray[k++] = array[j++];
        }

        while (i <= mid)
            mergeArray[k++] = array[i++];

        while (j <= right)
            mergeArray[k++] = array[j++];

        for (int m = 0; m < n; m++)
            array[left + m] = mergeArray[m];
    }

    private static String printArray(int[] array) {
        String str = "";
        for (int value : array) {
            str += value + " ";
        }
        return str;
    }
}
