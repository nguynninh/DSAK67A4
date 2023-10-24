package homework2.exercise5;

import homework2.exercise1.BubbleSort;
import homework2.exercise1.ISort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = sc.nextInt();

        sortArray(data);

        printArray(data);
    }

    private static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    private static void printArray(int[] data) {
        for (int index : data) {
            System.out.print(index + " ");
        }
    }
}
