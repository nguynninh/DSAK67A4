package homework2.exercise4.codelearn43;

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

        for (int i = 0; i < arraySort.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arraySort.length; j++) {
                if (arraySort[j] < arraySort[minIndex])
                    minIndex = j;
            }

            int tmp = arraySort[minIndex];
            arraySort[minIndex] = arraySort[i];
            arraySort[i] = tmp;
        }

        return arraySort;
    }

    private static String printArray(int[] array) {
        String str = "";
        for (int value : array) {
            str += value + " ";
        }
        return str;
    }
}
