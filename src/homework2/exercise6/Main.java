package homework2.exercise6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = sc.nextInt();

        System.out.println(sortArray(data, k));
    }

    private static int sortArray(int[] array, int k) {
        int[] data = Arrays.copyOf(array, array.length);

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }

        return data[k - 1];
    }
}
