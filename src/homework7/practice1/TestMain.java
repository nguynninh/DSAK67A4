package homework7.practice1;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++)
            array[i] = sc.nextInt();

        System.out.println(Solution.isRepresentingBST(array, n));
    }
}