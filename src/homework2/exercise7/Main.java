package homework2.exercise7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = sc.nextInt();

        System.out.println(sortArray(data, x));
    }

    private static int sortArray(int[] array, int x) {
        int[] data = Arrays.copyOf(array, array.length);
        int count = 0;

        for (int i = 0; i < data.length; i++)
            for (int j = i + 1; j < data.length; j++)
                if (data[i] + data[j] == x)
                    count++;

        return count;
    }
}
