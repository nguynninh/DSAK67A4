package homework2.exercise2;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        //INPUT SYSTEM
//        Scanner sc = new Scanner(System.in);
//        int[] array = new int[sc.nextInt()];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = sc.nextInt();
//        }

        //INPUT RANDOM
        int n = 100;
        int[] array = new int[n];
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(1_000_000);
        }
        System.out.println(Arrays.toString(array));

        Integer[] arraySort = Arrays.stream(Arrays.copyOf(array, array.length)).boxed().toArray(Integer[]::new);
        ISort bubbleISort = new BubbleSort();
        bubbleISort.sort(arraySort);
        System.out.println(Arrays.toString(arraySort));

        arraySort = Arrays.stream(Arrays.copyOf(array, array.length)).boxed().toArray(Integer[]::new);
        ISort insertionISort = new InsertionSort();
        insertionISort.sort(arraySort);
        System.out.println(Arrays.toString(arraySort));

        arraySort = Arrays.stream(Arrays.copyOf(array, array.length)).boxed().toArray(Integer[]::new);
        ISort selectionISort = new SelectionSort();
        selectionISort.sort(arraySort);
        System.out.println(Arrays.toString(arraySort));

        arraySort = Arrays.stream(Arrays.copyOf(array, array.length)).boxed().toArray(Integer[]::new);
        ISort quickISort = new QuickSort();
        quickISort.sort(arraySort);
        System.out.println(Arrays.toString(arraySort));

        arraySort = Arrays.stream(Arrays.copyOf(array, array.length)).boxed().toArray(Integer[]::new);
        ISort mergeISort = new MergeSort();
        mergeISort.sort(arraySort);
        System.out.println(Arrays.toString(arraySort));
    }
}
