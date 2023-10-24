package homework2.exercise4.codelearn42;

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

        for (int i = 0; i < arraySort.length; i++) {
            int key = arraySort[i];
            int j = i - 1;
            while (j >= 0 && arraySort[j] > key) {
                arraySort[j + 1] = arraySort[j];
                j -= 1;
            }
            arraySort[j + 1] = key;
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
