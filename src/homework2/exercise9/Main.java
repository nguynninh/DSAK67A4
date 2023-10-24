package homework2.exercise9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt(); //Bắt đầu từ 1
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = sc.nextInt();

        System.out.println(findIndex(data, t));
    }

    private static int findIndex(int[] data, int t) {
        int count = 1;
        for (int i = 0; i < data.length; i++)
            if (data[i] < data[t - 1])
                count++;

        return count;
    }
}
