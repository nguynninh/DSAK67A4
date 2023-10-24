package homework1.exercise2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        //Input System
//        System.out.print("Enter the number of elements in the sequence: ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        System.out.print("Enter the elements of the sequence: ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        //Input Random
        int n = (int) (Math.pow(10, 8) + 1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(1000);
        }

        Array<Integer> array = new Array<>();

        System.out.println("Prime numbers in the sequence: ");
        array.findAndPrintElements(arr);
        System.out.println();

        System.out.println("Square numbers in the sequence: ");
        array.findAndPrintElements(Arrays.stream(arr).boxed().toArray(Integer[]::new), num -> array.isPerfectNumber((Integer) num));

    }
}
